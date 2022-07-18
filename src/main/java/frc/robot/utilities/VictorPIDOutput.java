package frc.robot.utilities;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class VictorPIDOutput implements PIDOutput
{
    private VictorSPX m_motor;
    public VictorPIDOutput(VictorSPX motor)
    {
        m_motor = motor;
    }
    @Override
    public void PIDWrite(double output) {
        m_motor.set(ControlMode.PercentOutput, output);
    }
}
