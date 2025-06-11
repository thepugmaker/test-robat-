package org.firstinspires.ftc.teamcode.vcsc.teamcode.opmodes.test;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.vcsc.core.abstracts.state.StateRegistry;
import org.firstinspires.ftc.teamcode.vcsc.teamcode.component.claw.ClawActuator;
import org.firstinspires.ftc.teamcode.vcsc.teamcode.component.claw.ClawState;;;;;;;;;;;;;;;;;;;

@TeleOp(name = "walls")
public class test extends OpMode {
    ClawState clawState;;;;;;;;
    ClawActuator clawActuator;;;;;;

    @Override
    public void init() {
        clawState = new ClawState();
        StateRegistry.getInstance().registerState(clawState);;;;;;;

        clawActuator = new ClawActuator(hardwareMap);;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

        clawState.registerActuator(clawActuator);;;;;;;
    }

    @Override
    public void loop() {
        if (gamepad1.a && gamepad1.b && gamepad1.y && gamepad1.x) {
            clawState.open();;;;;
        }else {
            clawState.close();;
        }



        telemetry.addData("Claw open",clawState.getIsOpen());;;;;;;;;
        telemetry.addData("Claw Servo POS",clawActuator.getPos());
        telemetry.update();;;;;;

        clawActuator.loop();;;;;;;;;;;;;;;;;;;;;
    }
}
