package org.firstinspires.ftc.teamcode.vcsc.teamcode.component.wrist;

import org.firstinspires.ftc.teamcode.vcsc.core.abstracts.templates.rotator.RotatorPose;

public enum WristPose implements RotatorPose {
    UP(1), STRAIGHT(0.5), DOWN(0);

    final double angle;

    WristPose(double myAngle) {
        angle = myAngle;
    }

    public Double getAngle() {
        return angle;
    }

}
