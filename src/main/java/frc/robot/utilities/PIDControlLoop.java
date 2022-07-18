package frc.robot.utilities;

import java.util.ArrayList;

public class PIDControlLoop
{
    public static ArrayList<PIDController> activePIDList;

    public PIDControlLoop()
    {
        activePIDList = new ArrayList<PIDController>();
    }
    public static void UpdatePIDControllers()
    {
        for(int i = 0; i < activePIDList.size(); i++)
        {
            activePIDList.get(i).update();
            
        }
    }
}