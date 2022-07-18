package frc.robot.utilities;

import edu.wpi.first.wpilibj.Encoder;

public class EncoderPIDSource implements PIDSource
{
    private Encoder encoder;
    public EncoderPIDSource(Encoder encoder)
    {
        this.encoder = encoder;
    }

    @Override
    public double PIDGet() 
    {
        return encoder.get();
    }
    
}