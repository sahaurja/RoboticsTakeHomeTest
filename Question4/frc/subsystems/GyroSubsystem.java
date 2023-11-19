package frc.subsystems;


import com.ctre.phoenix.sensors.PigeonIMU;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class GyroSubsystem extends SubsystemBase {
    private final PigeonIMU pigeonIMU = new PigeonIMU(0); 

    public GyroSubsystem() {
        // Additional setup, if needed
    }

    public double getHeading() {
        double[] ypr = new double[3];
        pigeonIMU.getYawPitchRoll(ypr);
        return ypr[0];
    }
}

