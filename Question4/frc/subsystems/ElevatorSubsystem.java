package frc.commands;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * 
 * I had to download and istall revrobotic library for CANSparkMax
 */

public class ElevatorSubsystem extends SubsystemBase {

    private final CANSparkMax motor1 = new CANSparkMax(1, MotorType.kBrushless); 
    private final CANSparkMax motor2 = new CANSparkMax(2, MotorType.kBrushless); 

    public ElevatorSubsystem() {
        // I will add ionitialization 
    }

    public void move(double speed) {
        motor1.set(speed);
        motor2.set(speed);
    }

    public void stop() {
        motor1.set(0);
        motor2.set(0);
    }
}