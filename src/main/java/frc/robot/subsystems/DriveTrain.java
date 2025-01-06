// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

<<<<<<< HEAD
import com.ctre.phoenix6.hardware.Pigeon2;

=======
>>>>>>> bceb5b7b3410344b45ec5c8f1445b9b1e60aa4f2
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModuleState;
<<<<<<< HEAD
=======
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
>>>>>>> bceb5b7b3410344b45ec5c8f1445b9b1e60aa4f2
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.subsystems.Swerve.SwerveModule;

public class DriveTrain extends SubsystemBase {
  // Locations for the swerve modules relative to the robot center.
  Translation2d m_frontLeftLocation = new Translation2d(0.381, 0.381);
  Translation2d m_frontRightLocation = new Translation2d(0.381, -0.381);
  Translation2d m_backLeftLocation = new Translation2d(-0.381, 0.381);
  Translation2d m_backRightLocation = new Translation2d(-0.381, -0.381);

  // Creating kinematics using the modules' location.
  SwerveDriveKinematics kinematics = new SwerveDriveKinematics(
    m_frontLeftLocation, m_frontRightLocation, m_backLeftLocation, m_backRightLocation
  );

  /*Declare the four Swerve Modules
   *(
   * speedMotorID, directionMotorID, 
   * distanceEncoderChannelA, distanceEncoderChannelB, 
   * directionEncoderChannelA, directionEncoderChannelB
   * )
  */
  SwerveModule frontLeftModule = new SwerveModule(
    Constants.SwerveMotorsID.FRONT_LEFT_SPEED_MOTOR_ID, Constants.SwerveMotorsID.FRONT_LEFT_DIRECTION_MOTOR_ID,
    Constants.SwerveEncodersChannels.FRONT_LEFT_DISTANCE_ENCODER_CHANNEL_A, Constants.SwerveEncodersChannels.FRONT_LEFT_DISTANCE_ENCODER_CHANNEL_B,
    Constants.SwerveEncodersChannels.FRONT_LEFT_DIRECTION_ENCODER_CHANNEL_A, Constants.SwerveEncodersChannels.FRONT_LEFT_DIRECTION_ENCODER_CHANNEL_B
    );
  
  SwerveModule frontRightModule = new SwerveModule(
    Constants.SwerveMotorsID.FRONT_RIGHT_SPEED_MOTOR_ID, Constants.SwerveMotorsID.FRONT_RIGHT_DIRECTION_MOTOR_ID,
    Constants.SwerveEncodersChannels.FRONT_RIGHT_DISTANCE_ENCODER_CHANNEL_A, Constants.SwerveEncodersChannels.FRONT_RIGHT_DISTANCE_ENCODER_CHANNEL_B, 
    Constants.SwerveEncodersChannels.FRONT_RIGHT_DIRECTION_ENCODER_CHANNEL_A, Constants.SwerveEncodersChannels.FRONT_RIGHT_DIRECTION_ENCODER_CHANNEL_B
    );
  
  SwerveModule backLeftModule = new SwerveModule(
    Constants.SwerveMotorsID.BACK_LEFT_SPEED_MOTOR_ID, Constants.SwerveMotorsID.BACK_LEFT_DIRECTION_MOTOR_ID,
    Constants.SwerveEncodersChannels.BACK_LEFT_DISTANCE_ENCODER_CHANNEL_A, Constants.SwerveEncodersChannels.BACK_LEFT_DISTANCE_ENCODER_CHANNEL_B,
    Constants.SwerveEncodersChannels.BACK_LEFT_DIRECTION_ENCODER_CHANNEL_A, Constants.SwerveEncodersChannels.BACK_LEFT_DIRECTION_ENCODER_CHANNEL_B
    );
  
  SwerveModule backRightModule = new SwerveModule(
    Constants.SwerveMotorsID.BACK_RIGHT_SPEED_MOTOR_ID, Constants.SwerveMotorsID.BACK_RIGHT_DIRECTION_MOTOR_ID,
    Constants.SwerveEncodersChannels.BACK_RIGHT_DISTANCE_ENCODER_CHANNEL_A, Constants.SwerveEncodersChannels.BACK_RIGHT_DISTANCE_ENCODER_CHANNEL_B, 
    Constants.SwerveEncodersChannels.BACK_RIGHT_DIRECTION_ENCODER_CHANNEL_A, Constants.SwerveEncodersChannels.BACK_RIGHT_DIRECTION_ENCODER_CHANNEL_B
    );  

  // Module desired states
  SwerveModuleState[] moduleStates;

<<<<<<< HEAD
  // Swerve gyro (pigeon 2)
  private Pigeon2 swerve_gyro = new Pigeon2(Constants.SwerveGyro.SWERVE_GYRO_ID);
=======
  // Swerve gyro
  // To Do: Pass the port
  private ADXRS450_Gyro swerve_gyro = new ADXRS450_Gyro();
>>>>>>> bceb5b7b3410344b45ec5c8f1445b9b1e60aa4f2

  public DriveTrain() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  /*@param speeds is a tuple containing (forward(m/s), strafe(m/s), rotationSpeed(rad/s))*/
  public void teleOP(ChassisSpeeds speeds) {
    moduleStates = kinematics.toSwerveModuleStates(speeds);

    applyModuleStates(moduleStates);
    return;
  }

  public void rotateInPlace(double rotateSpeed) {
    /*Takes the right joystick's x input to determine rotation speed*/
    ChassisSpeeds speeds = new ChassisSpeeds(0, 0, rotateSpeed);
    moduleStates = kinematics.toSwerveModuleStates(speeds);
      
    applyModuleStates(moduleStates);
    return;
  }

  public void rotate90degrees(boolean clockwise) {
    /*Clockwise if the right joystick's x input is positive, counterclockwise if negative*/
<<<<<<< HEAD
    double currentAngle = swerve_gyro.getYaw().getValueAsDouble();
=======
    double currentAngle = swerve_gyro.getAngle();
>>>>>>> bceb5b7b3410344b45ec5c8f1445b9b1e60aa4f2
    double targetAngle;
    
    if (clockwise) { // When button A is pressed
      targetAngle = currentAngle + 90.0;
    }
    else { // When button B is pressed
      targetAngle = currentAngle - 90.0;
    }

    // Keeps running until the target is reached.
    while (Math.abs(swerve_gyro.getAngle() - targetAngle) > 2.0) { // Set a tolerance
      // Set an arbitriary rotation speed of 30 degrees.
      ChassisSpeeds speeds = new ChassisSpeeds(0, 0, Math.toRadians(30));
      moduleStates = kinematics.toSwerveModuleStates(speeds);
      
      applyModuleStates(moduleStates);
    }

    // Since the method is not called continously, modules are stoped here.
    stopModules();
    return;
  }

  public void applyModuleStates(SwerveModuleState[] moduleStates) {
    /* Apply the speeds for each module in the following order:
     * FrontLeft - FrontRight - BackLeft- BackRight
     */
    // Make sure that moduleStates has the information for each of the four modules.
    if (moduleStates.length != 4) {
      return;
    }

    frontLeftModule.setDesiredState(moduleStates[0]);
    frontRightModule.setDesiredState(moduleStates[1]);
    backLeftModule.setDesiredState(moduleStates[2]);
    backRightModule.setDesiredState(moduleStates[3]);
    return;
  }

  public void stopModules() {
    /*Sets all speed & rotation motors to zero*/
    ChassisSpeeds speeds = new ChassisSpeeds(0, 0, 0);
    moduleStates = kinematics.toSwerveModuleStates(speeds);

    applyModuleStates(moduleStates);
    return;
  }
}
