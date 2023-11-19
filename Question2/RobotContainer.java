package frc.robot;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.MoveElevatorCommand;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj.XboxController;

public class RobotContainer {
    private final ExampleSubsystem elevatorSubsystem = new ExampleSubsystem();

    public RobotContainer() {
        configureButtonBindings();
    }

    private void configureButtonBindings() {
        XboxController controller = new XboxController(0); 

        // controls buttons
        JoystickButton raiseButton = new JoystickButton(controller, XboxController.Button.kA.value);
        JoystickButton lowerButton = new JoystickButton(controller, XboxController.Button.kB.value);

        raiseButton.onTrue(new MoveElevatorCommand(elevatorSubsystem, 1.0)); 
        lowerButton.onTrue(new MoveElevatorCommand(elevatorSubsystem, -1.0)); 
    }

    public static void main(String... args) {
        RobotContainer robotContainer = new RobotContainer();        
        CommandScheduler.getInstance().run();
    }
}
