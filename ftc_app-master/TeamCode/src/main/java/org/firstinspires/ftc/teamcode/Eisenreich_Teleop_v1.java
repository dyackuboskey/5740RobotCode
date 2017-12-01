package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Colton on 11/21/2017.
 */
@TeleOp

public class Eisenreich_Teleop_v1 extends LinearOpMode {

    private DcMotor FrontL;
    private DcMotor FrontR;
    private DcMotor BackL;
    private DcMotor BackR;
    private Servo lGrab;
    private Servo rGrab;
    //private DcMotor Spool;

    @Override
    public void runOpMode() {

        FrontL = hardwareMap.dcMotor.get("FrontL");
        FrontR = hardwareMap.dcMotor.get("FrontR");
        BackL = hardwareMap.dcMotor.get("BackL");
        BackR = hardwareMap.dcMotor.get("BackR");

        FrontL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FrontR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BackL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BackR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        //Spool = hardwareMap.dcMotor.get("Spool");
        //Spool.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        RobotDrive drive = new RobotDrive(FrontL, FrontR, BackL, BackR);

        lGrab = hardwareMap.servo.get("LeftGrab");
        rGrab = hardwareMap.servo.get("RightGrab");

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        double LStickY = gamepad1.left_stick_y;
        double LStickX = gamepad1.left_stick_x;
        double RStickX = gamepad1.right_stick_x;
        double Grab = gamepad1.right_trigger;
        //double spool = gamepad1.left_trigger;

        lGrab.setPosition(.5);
        rGrab.setPosition(.5);

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            telemetry.addData("Status", "Running");
            telemetry.update();

            drive.mechanumDrive(LStickY, LStickX, RStickX);

            //Spool.setPower(spool);

            if(Grab >= 1){
                lGrab.setPosition(1);
                rGrab.setPosition(0);
            }
            else{
                lGrab.setPosition(.5);
                rGrab.setPosition(.5);
            }


        }
    }
}
