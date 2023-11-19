package frc.robot;

/**
 * 
 * I had downloaded and installed Phoenix library from 
 * https://maven.ctr-electronics.com/release/com/ctre/phoenixpro/PhoenixProAnd5-frc2023-latest.json
 */

import com.ctre.phoenix.sensors.PigeonIMU;
import com.ctre.phoenix.sensors.PigeonIMU.PigeonState;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.subsystems.GyroSubsystem;



public class RobotContainer {
    private final GyroSubsystem gyroSubsystem = new GyroSubsystem();
    private final ExampleSubsystem ExampleSubsystem = new ExampleSubsystem();// Used for my quesiton #2

    public RobotContainer() {
        configureButtonBindings();
        configureCommands();
    }

    private void configureButtonBindings() {
        // The button bindings to perfom which one to what command go here
    }

    private void configureCommands() {
        CommandScheduler.getInstance().setDefaultCommand(gyroSubsystem, new UpdateGyroCommand(gyroSubsystem));

        // This is my autonomous-command 
        CommandScheduler.getInstance().schedule(new AutonomousCommand(gyroSubsystem, ExampleSubsystem));
    }

}