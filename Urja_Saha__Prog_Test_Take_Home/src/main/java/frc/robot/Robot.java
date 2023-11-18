// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

import edu.wpi.first.wpilibj.Joystick;





public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;

  //declare and initialize all motor controllers...one motor controller for each wheel

  private CANSparkMax leftFront=new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless);
  private CANSparkMax leftBack=new CANSparkMax(2, CANSparkMaxLowLevel.MotorType.kBrushless);
  
  private CANSparkMax rightFront=new CANSparkMax(3, CANSparkMaxLowLevel.MotorType.kBrushless);
  private CANSparkMax rightBack=new CANSparkMax(4, CANSparkMaxLowLevel.MotorType.kBrushless);





  //declare and initialize the joystick
  private Joystick m_driveJoystick=new Joystick(0);


  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();
  }

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {

    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {
    //check how much time has passed since robot initialized
    double time=Timer.getFPGATimestamp();

    if(time<10){
    
      leftFront.set(0.5);    //doesn't have to be 0.5...can be any speed from [-1,1]
      leftBack.set(0.5);

      rightFront.set(-0.5);
      rightBack.set(-0.5);
    }

    else{  //turn then stop motors 
    
      leftFront.set(0.5);  
      leftBack.set(0.5);

      rightFront.set(0.5); //invert right side so it turns 90˚
      rightBack.set(0.5);



      leftFront.set(0);    
      leftBack.set(0);

      rightFront.set(0);
      rightBack.set(0);
    }

  }

  @Override
  public void teleopInit() {

    


  }


  double motorSpeed=0.5; //define motor speed...I took 0.5, but it can be changed according to competition needs
  @Override
  public void teleopPeriodic() {  
    //constantly get speed and turn data from the robot

    double speed= -m_driveJoystick.getRawAxis(1); //axis number from lab view...here assuming 1 is the power axis and 4 is the turning axis
    double turn=m_driveJoystick.getRawAxis(4);

    //get the power output for the left and right side

    double leftPower=speed+turn;
    double rightPower=speed-turn;

    leftFront.set(leftPower); //set motors to decided speed
    leftBack.set (leftPower);
   
    rightFront.set(-rightPower);
    rightBack.set(-rightPower);

  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}
