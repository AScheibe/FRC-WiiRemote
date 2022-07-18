/*----------------------------------------------------------------------------*/
/* Copyright (c) 2016-2020 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.utilities;

import edu.wpi.first.hal.HAL;
import edu.wpi.first.hal.FRCNetComm.tResourceType;
import edu.wpi.first.wpilibj.GenericHID;

public class WiiRemote extends GenericHID {
  
	private enum Button {
    kOne(1),
    kTwo(2),
    kA(3),
    kB(4),
    kBack(6),
    kStart(5);

    private int value;

    Button(int value) {
      this.value = value;
    }
  }

  public WiiRemote(final int port) {
    super(port);

    HAL.report(tResourceType.kResourceType_Joystick, port); //Read that all custom joysticks need this
  }

  public boolean getAButtonPressed() {
    return getRawButtonPressed(Button.kA.value);
  }

  public boolean getAButtonReleased() {
    return getRawButtonReleased(Button.kA.value);
  }

  public boolean getBButtonPressed() {
    return getRawButtonPressed(Button.kB.value);
  }

  public boolean getBButtonReleased() {
    return getRawButtonReleased(Button.kB.value);
  }

    public double getDPadX(){
        return getRawAxis(0);
    }
    public double getDPadY(){
        return getRawAxis(1);
    }

  public boolean getOneButtonPressed() {
    return getRawButtonPressed(Button.kOne.value);
  }


  public boolean getOneButtonReleased() {
    return getRawButtonReleased(Button.kOne.value);
  }

  
  public boolean getTwoButtonPressed() {
    return getRawButtonPressed(Button.kTwo.value);
  }

  
  public boolean getTwoButtonReleased() {
    return getRawButtonReleased(Button.kTwo.value);
  }
   
  public boolean getStartButtonPressed() {
    return getRawButtonPressed(Button.kStart.value);
  }

  
  public boolean getStartButtonReleased() {
    return getRawButtonReleased(Button.kStart.value);
  }

  public double getTurnHorizontal(){
    return getRawAxis(3);
}

public double getTiltVertical(){
    return getRawAxis(2);
}

//Below methods need to be overriden due to abstract class
  @Override
  public double getX(Hand hand) {
    return 0;
  }

  @Override
  public double getY(Hand hand) {
    return 0;
  }
}