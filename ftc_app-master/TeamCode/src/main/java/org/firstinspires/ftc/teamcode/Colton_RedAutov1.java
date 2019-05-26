package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Colton on 11/7/2017.
 */

@Autonomous
public class Colton_RedAutov1 extends LinearOpMode {
    private DcMotor FrontL;
    private DcMotor FrontR;
    private DcMotor BackL;
    private DcMotor BackR;
    private ColorSensor color;
    private Servo colorArm;

    @Override
    public void runOpMode() {
        FrontL = hardwareMap.dcMotor.get("FrontL");
        FrontR = hardwareMap.dcMotor.get("FrontR");
        BackL = hardwareMap.dcMotor.get("BackL");
        BackR = hardwareMap.dcMotor.get("BackR");

        colorArm = hardwareMap.servo.get("BillyJean");

        color = hardwareMap.colorSensor.get("Billy");

        RobotDrive drive = new RobotDrive(FrontL, FrontR, BackL, BackR);

        FrontL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FrontR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BackL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BackR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        colorArm.setPosition(0);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            telemetry.addData("Status", "Running");
            telemetry.update();

            int colorB = color.blue();
            colorArm.setPosition(.5);

            if(colorB > 700){
                drive.mechanumDrive(0, .5,0);
                sleep(1000);
                drive.mechanumDrive(0, 0, 0);
                colorArm.setPosition(0);
            }
            else{
                drive.mechanumDrive(0, -.5,0);
                sleep(1000);
                drive.mechanumDrive(0, 0, 0);
                colorArm.setPosition(0);
            }

        }
    }
}
