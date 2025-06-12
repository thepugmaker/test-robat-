package org.firstinspires.ftc.teamcode.vcsc.teamcode.component.claw.action;

import org.firstinspires.ftc.teamcode.vcsc.core.abstracts.action.Action;
import org.firstinspires.ftc.teamcode.vcsc.teamcode.component.claw.ClawState;

public class A_OpenClaw extends Action<ClawState> {
    public A_OpenClaw() {
        super(ClawState.class);
    }

    @Override
    public boolean start() {
        super.start();
        state.open();
        return true;
    }

    @Override
    public void loop() {

    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
