// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

/* Get access to motors and encoders of each module
 * Define functions to set the module's state
 * Define functions to get the module's state
*/

package frc.robot.subsystems.Swerve;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxAlternateEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.Encoder;

/** Add your docs here. */
public class SwerveModule {
    // Module motors
    CANSparkMax speedMotor;
    CANSparkMax directionMotor;

    // Module encoders
    Encoder distanceEncoder;
    Encoder directionEncoder;

    // Module absolute encoder
    RelativeEncoder absoluteEncoder;

    public SwerveModule(int speedMotorID, int directionMotorID, 
        int distanceEncoderChannelA, int distanceEncoderChannelB, 
        int directionEncoderChannelA, int directionEncoderChannelB
        ) {
        // Motors
        speedMotor = new CANSparkMax(speedMotorID, MotorType.kBrushless);
        directionMotor = new CANSparkMax(directionMotorID, MotorType.kBrushless);

        // Encoders
        distanceEncoder = new Encoder(distanceEncoderChannelA, distanceEncoderChannelB);
        directionEncoder = new Encoder(directionEncoderChannelA, directionEncoderChannelB);

        // Absolute encoder
        // TO DO: change countsPerRev
        absoluteEncoder = directionMotor.getAlternateEncoder(SparkMaxAlternateEncoder.Type.kQuadrature, 0);

        // Set the wheel direction to the absolute encoder value
        // TO DO: ask
        setDirectionMotor(absoluteEncoder.getPositionConversionFactor());
    }

    public void setDesiredState(SwerveModuleState desiredState) {
        SwerveModuleState optimizedState = SwerveModuleState.optimize(desiredState, Rotation2d.fromDegrees(getAngle()));
        setSpeedMotor(optimizedState.speedMetersPerSecond);
        setDirectionMotor(optimizedState.angle.getDegrees());
    }

    public void setSpeedMotor(double speed) {
        speedMotor.set(speed);
        return;
    }

    public void setDirectionMotor(double angle) {
        directionMotor.set(angle);
        return;
    }

    public double getAngle() {
        return directionEncoder.getDistance();
    }
}
