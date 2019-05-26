package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Colton on 12/8/2017.
 *
 * This code is for the claw on the 2017 ftc robot
 * There are two options:
 *  grab (a regular claw operation)
 *  toggleGrab(the claw sets to the normal position of the trigger but if the right bumper is pressed the claw stays
 *  at the last position of the trigger)
 *
 *  Input:
 *      A double for position
*   Output:
 *      A servo position between 5 and 1 for the left and .5 and 0 for the right
 */

public class Claw {
    Servo lGrab , rGrab;
    private boolean Btoggle;
    private double lGrablastPos;
    private double rGrablastPos;

    public Claw (Servo lGrab,Servo rGrab ){
        this.lGrab = lGrab;
        this.rGrab = rGrab;
    }

    public void grab (double Grab){
        lGrab.setPosition((.5*-Grab)+.5);
        rGrab.setPosition((.5*Grab)+.5);
    }

    public void toggleGrab (double Grab, boolean toggleButton){
        if (Btoggle){
            lGrab.setPosition(lGrablastPos);
            rGrab.setPosition(rGrablastPos);
        }
        else{
            lGrab.setPosition((.5*-Grab)+.5);
            rGrab.setPosition((.5*Grab)+.5);
        }
        if (toggleButton){
            if (Btoggle){
                Btoggle = false;
            }
            else if (!Btoggle) {
                Btoggle = true;
                lGrablastPos = (.5*-Grab)+.5;
                rGrablastPos = (.5*Grab)+.5;
            }
        }
    }
}
