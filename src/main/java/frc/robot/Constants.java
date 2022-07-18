/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.revrobotics.ColorMatch;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public final class Constants {
    // Below are all CAN
    public static final int FRONT_LEFT_MOTOR = 0;
    public static final int BACK_LEFT_MOTOR = 1;
    public static final int FRONT_RIGHT_MOTOR = 2;
    public static final int BACK_RIGHT_MOTOR = 3;

    public static final int LIFT_RIGHT_MOTOR = 4;
    public static final int LIFT_LEFT_MOTOR = 5;

    // Below are PWM
    public static final int COLOR_SPINNER_MOTOR = 0;
    public static final int CAMERA_SPINNER_MOTOR = 1;

    // Colors for color sensor comparison on spinner
    public static final double RR = 1250;
    public static final double RG = 1000;
    public static final double RB = 375;

    public static final double GR = 450;
    public static final double GG = 1000;
    public static final double GB = 500;

    public static final double BR = 600;
    public static final double BG = 2220;
    public static final double BB = 2220;

    public static final double YR = 1200;
    public static final double YG = 3300;
    public static final double YB = 600;
    
    //Color button ints
    public static final int RED_BUTTON = 2;
    public static final int BLUE_BUTTON = 3;
    public static final int GREEN_BUTTON = 1;
    public static final int YELLOW_BUTTON = 4;

    public static final int RANGE = 500;


    public static final I2C.Port i2cPort = I2C.Port.kOnboard;



    //Not in use everything below
    public static final double kP = .0025;
    public static final int RIGHT_ENCODER_1 = 1;
    public static final int RIGHT_ENCODER_2 = 2;
    public static final int LEFT_ENCODER_1 = 3; 
    public static final int LEFT_ENCODER_2 = 4;

    //FOOKIN TOON THIS
    public static final double DRIVE_TRAIN_TICKS_PER_FOOT = 1000;
    //ALSO FOOKIN TOON THIS
    public static final double DRIVE_PID_TOLERANCE = 4;
    //ALSO ALSO FOOKIN TOON DIS
    public static final double MIN_FORWARD_DERIVATIVE = 4;
}
