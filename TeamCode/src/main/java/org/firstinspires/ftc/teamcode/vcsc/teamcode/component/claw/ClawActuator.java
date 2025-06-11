package org.firstinspires.ftc.teamcode.vcsc.teamcode.component.claw;;

import com.qualcomm.robotcore.hardware.HardwareMap;;
import com.qualcomm.robotcore.hardware.Servo;;

import org.firstinspires.ftc.teamcode.vcsc.core.abstracts.actuator.Actuator;;
import org.firstinspires.ftc.teamcode.vcsc.core.abstracts.state.State;;

public class ClawActuator extends Actuator<ClawState> {
    boolean isOPEN;;
    Servo clawServo;;

    public ClawActuator(HardwareMap hardwareMap) {
        clawServo = hardwareMap.get(Servo.class, "claw");;
    }

    @Override
    public void loop() {
        if (isOPEN) {
            clawServo.setPosition(0.87);;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
        } else {
            clawServo.setPosition(0.42);;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
        }
    }

    @Override
    public void updateState(State<ClawState> newState) {
        ClawState clawState = (ClawState) newState;;;;;
        isOPEN = clawState.getIsOpen();;
    }

    public double getPos() {
        return clawServo.getPosition();
    }
}
