// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

  /*Swerve modules' IDs for speed & direction motors*/
  public static class SwerveMotorsID {
    // Swerve front left module.
    public static final int FRONT_LEFT_SPEED_MOTOR_ID = 0;
    public static final int FRONT_LEFT_DIRECTION_MOTOR_ID = 0;

    // Swerve front right module.
    public static final int FRONT_RIGHT_SPEED_MOTOR_ID = 0;
    public static final int FRONT_RIGHT_DIRECTION_MOTOR_ID = 0;

    // Swerve back left module.
    public static final int BACK_LEFT_SPEED_MOTOR_ID = 0;
    public static final int BACK_LEFT_DIRECTION_MOTOR_ID = 0;

    // Swerve back right module.
    public static final int BACK_RIGHT_SPEED_MOTOR_ID = 0;
    public static final int BACK_RIGHT_DIRECTION_MOTOR_ID = 0;
  }

  /*Swerve modules' Channels A & B for distance & direction encoders*/
  public static class SwerveEncodersChannels {
    // Swerve front left module.
    public static final int FRONT_LEFT_DISTANCE_ENCODER_CHANNEL_A = 0;
    public static final int FRONT_LEFT_DISTANCE_ENCODER_CHANNEL_B = 0;
    public static final int FRONT_LEFT_DIRECTION_ENCODER_CHANNEL_A = 0;
    public static final int FRONT_LEFT_DIRECTION_ENCODER_CHANNEL_B = 0;

    // Swerve front right module.
    public static final int FRONT_RIGHT_DISTANCE_ENCODER_CHANNEL_A = 0;
    public static final int FRONT_RIGHT_DISTANCE_ENCODER_CHANNEL_B = 0;
    public static final int FRONT_RIGHT_DIRECTION_ENCODER_CHANNEL_A = 0;
    public static final int FRONT_RIGHT_DIRECTION_ENCODER_CHANNEL_B = 0;

    // Swerve back left module.
    public static final int BACK_LEFT_DISTANCE_ENCODER_CHANNEL_A = 0;
    public static final int BACK_LEFT_DISTANCE_ENCODER_CHANNEL_B = 0;
    public static final int BACK_LEFT_DIRECTION_ENCODER_CHANNEL_A = 0;
    public static final int BACK_LEFT_DIRECTION_ENCODER_CHANNEL_B = 0;

    // Swerve back right module.
    public static final int BACK_RIGHT_DISTANCE_ENCODER_CHANNEL_A = 0;
    public static final int BACK_RIGHT_DISTANCE_ENCODER_CHANNEL_B = 0;
    public static final int BACK_RIGHT_DIRECTION_ENCODER_CHANNEL_A = 0;
    public static final int BACK_RIGHT_DIRECTION_ENCODER_CHANNEL_B = 0;
  }

  public class SwerveGyro {
    public static final int SWERVE_GYRO_ID = 0;
  }
}
