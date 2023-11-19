package frc.commands;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.subsystems.ElevatorSubsystem;
import frc.subsystems.GyroSubsystem;

public class AutonomousCommand extends CommandBase {
    private final GyroSubsystem gyroSubsystem;
    private final ElevatorSubsystem elevatorSubsystem;
    private final double targetAngle = 90.0; // Adjust the target angle

    public AutonomousCommand(GyroSubsystem gyroSubsystem, ElevatorSubsystem elevatorSubsystem) {
        this.gyroSubsystem = gyroSubsystem;
        this.elevatorSubsystem = elevatorSubsystem;
        addRequirements(gyroSubsystem, elevatorSubsystem);
    }

    @Override
    public void initialize() {
        //reset the sub system 
    }

    @Override
    public void execute() {
        double currentAngle = gyroSubsystem.getHeading();

        if (currentAngle >= targetAngle) {
            elevatorSubsystem.move(1.0);
            SmartDashboard.putBoolean("Movement", true);
        } else {
            SmartDashboard.putBoolean("Movement", false);
        }
    }

    @Override
    public boolean isFinished() {        
        return true;
    }

    @Override
    public void end(boolean interrupted) {        
        elevatorSubsystem.stop();
    }
}