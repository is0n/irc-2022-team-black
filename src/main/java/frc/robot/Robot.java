// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Arm;
import frc.robot.commands.AutoDrive;
import frc.robot.commands.BasicAuto;
import frc.robot.commands.Drive;
import frc.robot.commands.MoveArm;

public class Robot extends TimedRobot {
  private Joystick lj, rj;
  private JoystickButton armLift, armLower;

  private Drivetrain drivetrain = new Drivetrain(0, 1);
  private Drive drive;
  private Arm arm = new Arm(2);

  private Command autoCommand = new BasicAuto(drivetrain, arm);
  

  @Override
  public void robotInit() {
    this.lj = new Joystick(0);
    this.rj = new Joystick(1);
    armLift = new JoystickButton(this.lj, 1);
    armLower = new JoystickButton(this.rj, 1);
    this.drive = new Drive(this.drivetrain, this.lj, this.rj);
  }

  @Override
  public void teleopInit() {
    this.autoCommand.end(false);
    this.drive.schedule();
    this.drive.initialize();
    this.armLift.whenPressed(new MoveArm(arm, true));
    this.armLower.whenPressed(new MoveArm(arm, false));
  }

  @Override
  public void teleopPeriodic() {
    this.drive.execute();
  }

  @Override
  public void autonomousInit() {
    this.drive.end(true);
    this.autoCommand.schedule();
  }

  @Override
  public void autonomousPeriodic() {
    this.autoCommand.execute();
  }
}