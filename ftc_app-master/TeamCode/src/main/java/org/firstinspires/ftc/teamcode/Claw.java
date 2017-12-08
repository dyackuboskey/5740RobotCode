package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Colton on 12/8/2017.
 * This code is for the claw on the 2017 ftc robot
 * There are two options:
 *  grab (a regular claw operation)
 *  toggleGrab(the claw sets to the normal position of the trigger but if the right bumper is pressed the claw stays
 *  at the last position of the trigger)
 */

public class Claw {
    Servo lGrab , rGrab;
    private boolean Btoggle;
    private double lGrablastPos = 0;
    private double rGrablastPos = 0;

    public Claw (Servo lGrab,Servo rGrab ){
        this.lGrab = lGrab;
        this.rGrab = rGrab;
    }

    public void grab (double Grab){
        lGrab.setPosition((.5*Grab)+.5);
        rGrab.setPosition((-.5*Grab)+1);
    }

    public void toggleGrab (double Grab, boolean toggleButton){
        if (toggleButton){
            if (Btoggle){
                Btoggle = false;
            }
            else {
                Btoggle = true;
                lGrablastPos = (.5*Grab)+.5;
                rGrablastPos = (-.5*Grab)+1;
            }
        }
        if (Btoggle){
            lGrab.setPosition(lGrablastPos);
            rGrab.setPosition(rGrablastPos);
        }
        else{
            grab(Grab);

        }
    }
}
