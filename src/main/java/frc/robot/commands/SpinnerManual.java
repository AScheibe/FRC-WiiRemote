/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class SpinnerManual extends CommandBase {
  /**
   * Creates a new SpinWheel.
   */
  private static ColorSensorV3 m_colorSensor;
  


  public SpinnerManual() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.spinner);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_colorSensor = Robot.spinner.colorSensor; 
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.spinner.spinnerMotor.set(-RobotContainer.operator.getRawAxis(2) * 0.5 + RobotContainer.operator.getRawAxis(3) * 0.5);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
