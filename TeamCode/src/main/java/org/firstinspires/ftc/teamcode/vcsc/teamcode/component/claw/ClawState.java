package org.firstinspires.ftc.teamcode.vcsc.teamcode.component.claw;

import org.firstinspires.ftc.teamcode.vcsc.core.abstracts.state.State;

public class ClawState extends State<ClawState> {
    boolean isOpen;


    public void open() {
        isOpen = true;
        notifyActuators();
    }

    public void close() {
        isOpen = false;
        notifyActuators();
    }
    
    public void toggle() {
        if (isOpen) {
            close();

        } else {
            open();
        }
        
    }

    public boolean getIsOpen() {
        return isOpen;
    }
}
