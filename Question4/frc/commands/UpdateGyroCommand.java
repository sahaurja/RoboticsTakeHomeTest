package frc.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.subsystems.GyroSubsystem;

public class UpdateGyroCommand extends CommandBase {
    private final GyroSubsystem gyroSubsystem;

    public UpdateGyroCommand(GyroSubsystem gyroSubsystem) {
        this.gyroSubsystem = gyroSubsystem;
        addRequirements(gyroSubsystem);
    }

    @Override
    public void execute() {
        double heading = gyroSubsystem.getHeading();
        SmartDashboard.putNumber("Urja's Gyro", heading);
    }
}