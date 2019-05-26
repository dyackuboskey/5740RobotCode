package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
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
        Spool.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        outSpool.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        RobotDrive drive = new RobotDrive(FrontL, FrontR, BackL, BackR);

        lGrab = hardwareMap.servo.get("LeftGrab");
        rGrab = hardwareMap.servo.get("RightGrab");
        cArm = hardwareMap.servo.get("Arm");

        Claw claw = new Claw(lGrab, rGrab);

        lGrab.setPosition(.5);
        rGrab.setPosition(.5);
        cArm.setPosition(.5);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            telemetry.addData("Status", "Running");
            telemetry.update();

            double LStickY = -gamepad1.left_stick_y;
            double LStickX = gamepad1.left_stick_x;
            double RStickX = gamepad1.right_stick_x;
            double Grab = gamepad1.left_trigger;
            double spool = gamepad1.right_trigger;
            boolean toggleButton = gamepad1.left_bumper;
            boolean up = gamepad1.dpad_up;
            boolean down = gamepad1.dpad_down;

            drive.mechanumDrive(LStickY, LStickX, RStickX);

            claw.toggleGrab(Grab, toggleButton);

            //this is to pull the arm back in
            if(gamepad1.right_bumper){
                Spool.setDirection(DcMotor.Direction.REVERSE);
                outSpool.setDirection(DcMotor.Direction.FORWARD);
                Spool.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
                outSpool.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
                Spool.setPower(spool);
                outSpool.setPower(-spool);
            }
            else{
                Spool.setDirection(DcMotorSimple.Direction.FORWARD);
                outSpool.setDirection(DcMotorSimple.Direction.FORWARD);
                Spool.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
                outSpool.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
                Spool.setPower(spool);
                outSpool.setPower(-spool);
            }



            //this is to move the arm up and down
            if (up){
                outSpool.setPower(-.5);
            }
            else if (down){
                outSpool.setPower(.5);
            }
            else{
                outSpool.setPower(0);
            }
            //Spool.setPower(spool);
            //outSpool.setPower(-spool);
        }
    }
}
