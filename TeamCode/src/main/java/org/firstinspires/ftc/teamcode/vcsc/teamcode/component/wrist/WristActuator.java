package org.firstinspires.ftc.teamcode.vcsc.teamcode.component.wrist;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.vcsc.core.abstracts.templates.rotator.RotatorActuator;

public class WristActuator extends RotatorActuator<WristState, WristPose> {

    public WristActuator(HardwareMap hardwareMap) {
        super(hardwareMap, "wristpivot");

    }
}
