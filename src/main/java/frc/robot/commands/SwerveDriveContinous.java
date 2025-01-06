// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveTrain;

public class SwerveDriveContinous extends Command {
  DriveTrain driveTrain;
  XboxController controller;

  /** Creates a new SwerveDriveContinous. */
  public SwerveDriveContinous(DriveTrain driveTrain, XboxController controller) {
    this.driveTrain = driveTrain;
    this.controller = controller;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // Left joystick's 'Y' value would be for forward speed and 'X' value for strafe speed.
    double forwardSpeed = (Math.abs(controller.getLeftY()) > 0.1) ? controller.getLeftY() * 0.8 : 0.0; // Set a deadzone of 0.1; Max value = 0.8
    double strafeSpeed = (Math.abs(controller.getLeftX()) > 0.1) ? controller.getLeftX() * 0.8 : 0.0; // Set a deadzone of 0.1; Max value = 0.8

    // Right joystick's 'X' value would determine rotation speed.
    double rotateSpeed = (Math.abs(controller.getRightX()) > 0.1) ? controller.getRightX() * 0.8 : 0.0; // Set a deadzone of 0.1; Max value = 0.8

    // If just rotateSpeed input does not equal 0, call rotateInPlace.
    if (rotateSpeed != 0.0 && (forwardSpeed == 0.0 && strafeSpeed == 0.0)) {
      driveTrain.rotateInPlace(rotateSpeed);
    }
    else { // Else, use teleOP.
      driveTrain.teleOP(new ChassisSpeeds(forwardSpeed, strafeSpeed, rotateSpeed));
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // Stop the driveTrain when the command ends.
    driveTrain.stopModules();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // This command sould never finish on its own in teleOP mode
    return false;
  }
}
