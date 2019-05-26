package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


/**
 * Created by Nicholas B.
 */

@Autonomous
public class Blackburn_Auto_Rev1 extends LinearOpMode {
    private DcMotor FrontL;
    private DcMotor FrontR;
    private DcMotor BackL;
    private DcMotor BackR;

    @Override
    public void runOpMode() {
        FrontL = hardwareMap.dcMotor.get ( "FrontL" );
        FrontR = hardwareMap.dcMotor.get ( "FrontR" );
        BackL = hardwareMap.dcMotor.get ( "BackL" );
        BackR = hardwareMap.dcMotor.get ( "BackR" );
        waitForStart ();
        telemetry.addData ( "Status","Running" );
        FrontL.setDirection ( DcMotorSimple.Direction.FORWARD );
        FrontR.setDirection ( DcMotorSimple.Direction.FORWARD );
        BackR.setDirection ( DcMotorSimple.Direction.REVERSE);
        BackL.setDirection ( DcMotorSimple.Direction.REVERSE );
        telemetry.update ();
        while (true){
            FrontR.setPower ( 10 );
            FrontL.setPower ( 10 );
            BackR.setPower ( 10 );
            BackL.setPower ( 10 );
        }


    }
}







