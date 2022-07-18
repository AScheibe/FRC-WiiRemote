/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Lift extends SubsystemBase {
  /**
   * Creates a new Lift.
   */
  public static WPI_VictorSPX liftMotorRight;
  public static WPI_VictorSPX liftMotorLeft;

  public Lift() {
    liftMotorRight = new WPI_VictorSPX(Constants.LIFT_RIGHT_MOTOR);
    liftMotorLeft = new WPI_VictorSPX(Constants.LIFT_LEFT_MOTOR);

    liftMotorRight.setSafetyEnabled(false);
    liftMotorLeft.setSafetyEnabled(false);
  }

  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
