package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
    private MotorController arm;
    public Arm(int aport) {
        this.arm = new VictorSP(aport);
    }
    

    public void drive(double as) {
        this.arm.set(as);
    }

    public void stop() {
        this.arm.stopMotor();
    }
}