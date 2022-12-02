package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Arm;

public class BasicAuto extends SequentialCommandGroup{
    
    private Drivetrain drivetrain;
    private Arm arm;

    public BasicAuto(Drivetrain dt, Arm arm) {

        drivetrain = dt;
        this.arm = arm;

        addCommands(
            new AutoDrive(drivetrain, 0.23, 0.23).withTimeout(2),
            new AutoDrive(drivetrain, 0, 0),
            new AutoShoot(arm, 0.5).withTimeout(1.5),
            new AutoShoot(arm, -0.5).withTimeout(1.5),
            new AutoShoot(arm, 0) 
        );
    }
}
