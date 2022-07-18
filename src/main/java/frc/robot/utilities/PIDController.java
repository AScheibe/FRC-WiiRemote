package frc.robot.utilities;


public class PIDController
{
    private double m_kp;
    private double m_ki;
    private double m_kd;
    private PIDSource m_pidSource;
    private PIDOutput m_pidOutput;
    private double m_pidTarget;
    private double m_tolerance;
    private boolean m_isEnabled;
    private double pCurrent;
    private double iCurrent;
    private double dCurrent;
    private double previousError;
    private double error;
    private double outVal;

    public PIDController(double kp, double ki, double kd, PIDSource source, PIDOutput output)
    {
        m_kp = kp;
        m_ki = ki;
        m_kd = kd;
        m_pidSource = source;
        m_pidOutput = output;
    }

    public void setTolerance(double tolerance)
    {
        m_tolerance = tolerance;
    }
    public void setTarget(double target)
    {
        m_pidTarget = target;
    }
    public boolean isOnTarget()
    {
        return (Math.abs(m_pidSource.PIDGet() - m_pidTarget) < Math.abs(m_tolerance));
    }
    public void reset()
    {
        pCurrent = 0;
        iCurrent = 0;
        dCurrent = 0;
        error = 0;
        previousError = 0;
        disable();
    }

    public void enable()
    {
        if(!m_isEnabled)
        {
            PIDControlLoop.activePIDList.add(this);
            m_isEnabled = true;
        }
    }
    public void disable()
    {
        if(m_isEnabled)
        {
            PIDControlLoop.activePIDList.remove(this);
            m_pidOutput.PIDWrite(0);
        }
    }
    public void update()
    {
        if(m_isEnabled)
        {
            previousError = error;
            error = m_pidTarget - m_pidSource.PIDGet();
            pCurrent = error;
            iCurrent += (error*.02); // Integral is increased by the error*time (which is .02 seconds using normal IterativeRobot)
            dCurrent = (error - previousError) / .02;
            outVal = m_kp*error + m_ki*iCurrent + m_kd*dCurrent;
            m_pidOutput.PIDWrite(normalize(outVal));
        }

    }

    public double normalize(double input)
    {
        if(input > 1)
        {
            return 1;
        }
        if(input < -1)
        {
            return -1;
        }
        return input;
    }

    public double getDerivative()
    {
        return dCurrent;
    }
    public double getIntegral()
    {
        return iCurrent;
    }
    public double getProportional()
    {
        return pCurrent;
    }
}