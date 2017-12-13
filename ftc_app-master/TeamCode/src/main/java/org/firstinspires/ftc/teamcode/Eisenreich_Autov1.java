package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import java.util.Timer;

/**
 * Created by Colton on 12/13/2017.
 */

@Autonomous
public class Eisenreich_Autov1 extends LinearOpMode {

    private DcMotor FrontL;
    private DcMotor FrontR;
    private DcMotor BackL;
    private DcMotor BackR;
    private Servo lGrab;
    private Servo rGrab;
    private DcMotor Spool;
    private DcMotor outSpool;
    private Servo cArm;

    @Override
    public void runOpMode() {

        FrontL = hardwareMap.dcMotor.get("FrontL");
        FrontR = hardwareMap.dcMotor.get("FrontR");
        BackL = hardwareMap.dcMotor.get("BackL");
        BackR = hardwareMap.dcMotor.get("BackR");

        FrontR.setDirection(DcMotorSimple.Direction.REVERSE);
        BackR.setDirection(DcMotorSimple.Direction.REVERSE);
        FrontL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FrontR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BackL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BackR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        Spool = hardwareMap.dcMotor.get("Spool");
        outSpool = hardwareMap.dcMotor.get("outSpool");
        Spool.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        outSpool.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        RobotDrive drive = new RobotDrive(FrontL, FrontR, BackL, BackR);

        lGrab = hardwareMap.servo.get("LeftGrab");
        rGrab = hardwareMap.servo.get("RightGrab");
        cArm = hardwareMap.servo.get("Arm");

        Claw claw = new Claw(lGrab, rGrab);

        lGrab.setPosition(.5);
        rGrab.setPosition(.5);
        cArm.setPosition(1);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            telemetry.addData("Status", "Running");
            telemetry.update();

            claw.grab(1);
            sleep(50);
            cArm.setPosition(.5);
            sleep(50);
            drive.encoderDrive(3,0,0);
            sleep(1000);
            drive.encoderDrive(0,3,0);

        }
    }
}
