package frc.robot.commands;

import frc.robot.subsystems.Arm;
import edu.wpi.first.wpilibj2.command.CommandBase; 

public class AutoShoot extends CommandBase {
    private Arm arm;
    private double speed;

    public AutoShoot(Arm arm, double speed) {
        this.arm = arm;
        this.speed = speed;
        
        addRequirements(arm);
    }
    
    @Override
    public void initialize() {
        arm.stop();
    }

    @Override
    public void execute() {
        arm.drive(speed);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean stop) {
        arm.stop();
    }
}