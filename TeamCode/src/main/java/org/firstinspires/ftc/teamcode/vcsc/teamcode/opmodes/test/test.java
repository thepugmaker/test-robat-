package org.firstinspires.ftc.teamcode.vcsc.teamcode.opmodes.test;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.vcsc.core.abstracts.state.StateRegistry;
import org.firstinspires.ftc.teamcode.vcsc.core.abstracts.task.TaskManager;
import org.firstinspires.ftc.teamcode.vcsc.core.abstracts.task.TaskSequence;
import org.firstinspires.ftc.teamcode.vcsc.core.abstracts.templates.rotator.actions.A_SetRotatorPose;
import org.firstinspires.ftc.teamcode.vcsc.core.util.GlobalTelemetry;
import org.firstinspires.ftc.teamcode.vcsc.teamcode.component.claw.ClawActuator;
import org.firstinspires.ftc.teamcode.vcsc.teamcode.component.claw.ClawState;
import org.firstinspires.ftc.teamcode.vcsc.teamcode.component.claw.action.A_CloseClaw;
import org.firstinspires.ftc.teamcode.vcsc.teamcode.component.claw.action.A_OpenClaw;
import org.firstinspires.ftc.teamcode.vcsc.teamcode.component.claw.action.A_ToggleClaw;
import org.firstinspires.ftc.teamcode.vcsc.teamcode.component.wrist.WristActuator;
import org.firstinspires.ftc.teamcode.vcsc.teamcode.component.wrist.WristPose;
import org.firstinspires.ftc.teamcode.vcsc.teamcode.component.wrist.WristState;;;;;;;;;;;;;;;;;;;

@TeleOp(name = "walls")
public class test extends OpMode {
    ClawState clawState;;;;;;;;
    ClawActuator clawActuator;;;;;;
    WristState wristState;
    WristActuator wristActuator;
    TaskManager taskManager = TaskManager.getInstance();;;;;;;;;;;;

    boolean processed = false;;;;;;;;;;;;;;;;;;;;;;

    @Override
    public void init() {
        GlobalTelemetry.init(telemetry);
        clawState = new ClawState();
        StateRegistry.getInstance().registerState(clawState);;;;;;;

        clawActuator = new ClawActuator(hardwareMap);;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

        clawState.registerActuator(clawActuator);;;;;;;

        wristState = new WristState();
        StateRegistry.getInstance().registerState(wristState);

        wristActuator = new WristActuator(hardwareMap);
        wristState.registerActuator(wristActuator);
    }

    @Override
    public void loop() {
        TaskSequence weloveSemiColons = new TaskSequence(new A_OpenClaw())
                .thenDelay(3000)
                .then(new A_CloseClaw(),new A_SetRotatorPose<>(WristState.class, WristPose.UP))
                .thenDelay(3000)
                .then(new A_OpenClaw(),new A_SetRotatorPose<>(WristState.class, WristPose.DOWN))
                .thenDelay(3000)
                .then(new A_CloseClaw(),new A_SetRotatorPose<>(WristState.class, WristPose.UP));


        if (gamepad1.a) {
            //&& gamepad1.b && gamepad1.x && gamepad1.y && gamepad1.left_bumper && gamepad1.right_bumper
            if (!processed) {
                taskManager.runTask(weloveSemiColons);;;;;;;;;;;;;;;;;;;;;;;;;;;;;
            }
            processed = true;;;;;;;;;;;;
        } else {
            processed = false;;;;;;;;
        }
//;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

        telemetry.addData("Claw open",clawState.getIsOpen());;;;;;;;;;;;;;;;;;;;;;;;;;
        telemetry.addData("Claw Servo POS",clawActuator.getPos());;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
        telemetry.update();

        clawActuator.loop();;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
        wristActuator.loop();
        taskManager.loop();;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
    }
}
