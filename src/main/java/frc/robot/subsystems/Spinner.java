/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.SpinnerManual;

public class Spinner extends SubsystemBase {
  /**
   * Creates a new Spinner.
   */
  public static PWMVictorSPX spinnerMotor;
  public static ColorSensorV3 colorSensor;
  
  public Spinner() 
  {
    spinnerMotor = new PWMVictorSPX(Constants.COLOR_SPINNER_MOTOR);
    colorSensor = new ColorSensorV3(Constants.i2cPort);
    spinnerMotor.setSafetyEnabled(false);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
