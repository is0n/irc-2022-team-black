package frc.robot.commands;

import frc.robot.subsystems.Arm;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class MoveArm extends CommandBase {
    private Arm arm;
    private boolean isUp;

    public MoveArm(Arm a, boolean isUp) {
        arm = a;
        this.isUp = isUp;
        super.addRequirements(a);
    }

    @Override
    public void initialize() {
        arm.stop();
    }

    @Override
    public void execute() {
        arm.drive((isUp) ? 1:-1 );
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