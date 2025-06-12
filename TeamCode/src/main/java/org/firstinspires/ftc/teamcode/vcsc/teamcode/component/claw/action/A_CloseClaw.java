package org.firstinspires.ftc.teamcode.vcsc.teamcode.component.claw.action;

import org.firstinspires.ftc.teamcode.vcsc.core.abstracts.action.Action;
import org.firstinspires.ftc.teamcode.vcsc.teamcode.component.claw.ClawState;

public class A_CloseClaw extends Action<ClawState> {
    public A_CloseClaw() {
        super(ClawState.class);
    }

    @Override
    public boolean start() {
        super.start();
        state.close();
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
