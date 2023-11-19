package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ExampleSubsystem;

/**
 * The Up and DOwn command
 */
public class MoveElevatorCommand extends CommandBase {
    private final ExampleSubsystem elevatorSubsystem;
    private final double speed;

    public MoveElevatorCommand(ExampleSubsystem elevatorSubsystem, double speed) {
        this.elevatorSubsystem = elevatorSubsystem;
        this.speed = speed;
        addRequirements(elevatorSubsystem);
    }

    @Override
    public void initialize() {
        elevatorSubsystem.move(speed);
    }

    @Override
    public void end(boolean isStop) {
        elevatorSubsystem.stop();
    }

    @Override
    public boolean isFinished() {
       
        return true;
    }
}