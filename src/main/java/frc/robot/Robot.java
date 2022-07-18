/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

//Test
package frc.robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.*;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.DriveContinous;
import frc.robot.commands.DriveForwards;
import frc.robot.commands.MoveLift;
import frc.robot.commands.SpinCamera;
import frc.robot.commands.SpinnerManual;
import frc.robot.subsystems.CameraSpinner;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Lift;
import frc.robot.subsystems.Spinner;
import frc.robot.utilities.PIDControlLoop;


/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;
  private RobotContainer m_robotContainer;
  public static CameraSpinner cameraSpinner;
  public static DriveTrain driveTrain;
  public static AHRS ahrs;
  public static UsbCamera camera1;
  public static UsbCamera camera2;
  public static Lift lift;
  public static Spinner spinner;
  
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();

    // Subsystems
    lift = new Lift();
    lift.setDefaultCommand(new MoveLift());
    
    driveTrain = new DriveTrain();
    driveTrain.setDefaultCommand(new DriveContinous());

    spinner = new Spinner();
    spinner.setDefaultCommand(new SpinnerManual());

    cameraSpinner = new CameraSpinner();
    cameraSpinner.setDefaultCommand(new SpinCamera());
    
    lift.liftMotorLeft.set(0.05);
    lift.liftMotorRight.set(0.05);

    // Camera stuff
    
    ahrs = new AHRS(SPI.Port.kMXP);
    ahrs.enableLogging(true);
    CameraServer.getInstance().startAutomaticCapture(0);
    CameraServer.getInstance().startAutomaticCapture(1);
    //Ignore Below
    PIDControlLoop p = new PIDControlLoop();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
    PIDControlLoop.UpdatePIDControllers();

    SmartDashboard.putNumber("Gyro X: ", ahrs.getRawGyroX());
    SmartDashboard.putNumber("Gyro Y: ", ahrs.getRawGyroY());
    SmartDashboard.putNumber("Gyro Z: ", ahrs.getRawGyroZ());
    SmartDashboard.putNumber("Update Count: ", ahrs.getUpdateCount());
    SmartDashboard.putNumber("Y Velocity: ", ahrs.getVelocityY());
    SmartDashboard.putNumber("Y Displacement: ", ahrs.getDisplacementY());
    SmartDashboard.putNumber("Angle", ahrs.getAngle());
    SmartDashboard.putNumber("Update Rate: ", ahrs.getActualUpdateRate());
    SmartDashboard.putNumber("Y Displacement: ", ahrs.getDisplacementY());
    SmartDashboard.putNumber("Red: ", spinner.colorSensor.getRed());
    SmartDashboard.putNumber("Blue: ", spinner.colorSensor.getBlue());
    SmartDashboard.putNumber("Green: ", spinner.colorSensor.getGreen());
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  /**
   * This autonomous runs the autonomous command selected by your {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit() {
    CommandScheduler.getInstance().schedule(new DriveForwards());
    CommandScheduler.getInstance().run();
    
    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    CommandScheduler.getInstance().enable();
    CommandScheduler.getInstance().run();
    
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
