package frc.robot.utilities;

import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;

public class DriveCalibrate
{
    public static void calibrateNav()
    {
        while(Robot.ahrs.getAngle() > 0.5 || Robot.ahrs.getAngle() < -0.5)
        {
            Robot.ahrs.calibrate();
        }
    }




}
