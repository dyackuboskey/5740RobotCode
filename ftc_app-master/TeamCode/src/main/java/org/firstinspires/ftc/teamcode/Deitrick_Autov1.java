package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Created by rdeitrick on 11/14/2017.
 */
@Autonomous

public class Auto extends LinearOpMode {

    private DcMotor FrontL;
    private DcMotor FrontR;
    private DcMotor BackL;
    private DcMotor BackR;

    @Override
    public void runOpMode() {

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        FrontL = hardwareMap.dcMotor.get("FrontL");
        FrontR = hardwareMap.dcMotor.get("FrontR");
        BackL = hardwareMap.dcMotor.get("BackL");
        BackR = hardwareMap.dcMotor.get("BackR");


        FrontR.setDirection(DcMotorSimple.Direction.FORWARD);
        FrontR.setPower(5);
        FrontL.setDirection(DcMotorSimple.Direction.FORWARD);
        FrontL.setPower(5);
        BackR.setDirection(DcMotorSimple.Direction.REVERSE);
        BackR.setPower(5);
        BackL.setDirection(DcMotorSimple.Direction.REVERSE);
        BackL.setPower(5);

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            telemetry.addData("Status", "Running");
            telemetry.update();



        }
    }
}
