/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import java.util.ArrayList;

import com.ctre.phoenix.motorcontrol.GroupMotorControllers;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.utilities.EncoderPIDSource;
import frc.robot.utilities.PIDController;
import frc.robot.utilities.PIDOutput;
import frc.robot.utilities.PIDOutputGroup;
import frc.robot.utilities.VictorPIDOutput;

public class DriveTrain extends SubsystemBase {
  /**
   * Creates a new DriveTrain.
   */
  public static WPI_VictorSPX frontRightMotor;
  public static WPI_VictorSPX frontLeftMotor;
  public static WPI_VictorSPX backRightMotor;
  public static WPI_VictorSPX backLeftMotor;

  private static ArrayList<PIDOutput> leftMotorsList;
  private static ArrayList<PIDOutput> rightMotorsList;

  private static Encoder leftEncoder;
  private static Encoder rightEncoder;

  public static VictorPIDOutput frontLeftPIDOutput;
  public static VictorPIDOutput frontRightPIDOutput;
  public static VictorPIDOutput backRightPIDOutput;
  public static VictorPIDOutput backLeftPIDOutput;

  public static PIDOutputGroup leftMotors;
  public static PIDOutputGroup rightMotors;

  public static SpeedControllerGroup leftMotorGroup;
  public static SpeedControllerGroup rightMotorGroup;

  public static EncoderPIDSource leftEncoderPIDSource;
  public static EncoderPIDSource rightEncoderPIDSource;
  
  public static PIDController rightPID;
  public static PIDController leftPID;

  public static DifferentialDrive dDrive;

  public DriveTrain() {
    frontLeftMotor = new WPI_VictorSPX(Constants.FRONT_LEFT_MOTOR);
    frontRightMotor = new WPI_VictorSPX(Constants.FRONT_RIGHT_MOTOR);
    backRightMotor = new WPI_VictorSPX(Constants.BACK_RIGHT_MOTOR);
    backLeftMotor = new WPI_VictorSPX(Constants.BACK_LEFT_MOTOR);

    frontLeftMotor.setSafetyEnabled(false);
    frontRightMotor.setSafetyEnabled(false);
    backLeftMotor.setSafetyEnabled(false);
    backRightMotor.setSafetyEnabled(false);

    frontLeftPIDOutput = new VictorPIDOutput(frontLeftMotor);
    frontRightPIDOutput = new VictorPIDOutput(frontRightMotor);
    backRightPIDOutput = new VictorPIDOutput(backRightMotor);
    backLeftPIDOutput = new VictorPIDOutput(backLeftMotor);

    leftMotorsList = new ArrayList<PIDOutput>();
    rightMotorsList = new ArrayList<PIDOutput>();

    leftMotorsList.add(frontLeftPIDOutput);
    leftMotorsList.add(backLeftPIDOutput);

    rightMotorsList.add(frontRightPIDOutput);
    rightMotorsList.add(backRightPIDOutput);
    
    leftMotors = new PIDOutputGroup(leftMotorsList);
    rightMotors = new PIDOutputGroup(rightMotorsList);

    leftEncoder = new Encoder(Constants.LEFT_ENCODER_1, Constants.LEFT_ENCODER_2);
    rightEncoder = new Encoder(Constants.RIGHT_ENCODER_1, Constants.RIGHT_ENCODER_2);

    leftEncoderPIDSource = new EncoderPIDSource(leftEncoder);
    rightEncoderPIDSource = new EncoderPIDSource(rightEncoder);

    rightMotorGroup = new SpeedControllerGroup(frontRightMotor, backRightMotor);
    leftMotorGroup = new SpeedControllerGroup(frontLeftMotor, backLeftMotor);

    dDrive = new DifferentialDrive(rightMotorGroup, leftMotorGroup);

    rightPID = new PIDController(1, 1, 1, rightEncoderPIDSource, rightMotors);
    leftPID = new PIDController(1, 1, 1, leftEncoderPIDSource, leftMotors);



    
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
