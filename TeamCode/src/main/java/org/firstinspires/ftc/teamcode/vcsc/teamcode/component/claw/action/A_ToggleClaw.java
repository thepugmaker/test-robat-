package org.firstinspires.ftc.teamcode.vcsc.teamcode.component.claw.action;

import org.firstinspires.ftc.teamcode.vcsc.core.abstracts.action.Action;
import org.firstinspires.ftc.teamcode.vcsc.teamcode.component.claw.ClawState;

public class A_ToggleClaw extends Action<ClawState> {
    public A_ToggleClaw() {
        super(ClawState.class);
    }

    @Override
    public boolean start() {
        super.start();
        state.toggle();
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
