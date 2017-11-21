package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Colton on 11/3/2017.
 *
 * Note:
 *  GyroDrive is still in testing
 *
 * TO CALL THIS FUNCTION
 *  First initialize all drive train motors
 *  Name them how ever you want
 *  Initialize the robot drive with this line;
 *  RobotDrive drive = new RobotDrive(FontLeftMotor,FrontRightMotor, BackLeftMotor, BackRightMotor);
 *      This line intializes the robot drive procedure with these certain motors. "drive" is the variable
 *      that is used for this robot drive(you can name it what ever you want). It must also correspond with
 *      "drive" in the next line.
 *  To call the mechanumDrive:
 *  drive.mechanumDrive(LeftStickY[or your forward velocity],LeftStickX[or your strafe velocity], RightStickX[or your turn velocity]);
 */

public class RobotDrive {
    DcMotor FrontL, FrontR, BackL, BackR;
    public RobotDrive(DcMotor FrontL, DcMotor FrontR, DcMotor BackL, DcMotor BackR){
        this.FrontL = FrontL;
        this.FrontR = FrontR;
        this.BackL = BackL;
        this.BackR = BackR;

    }
    public void mechanumDrive (double Lsticky, double Lstickx, double Rstickx){
        FrontL.setPower((Lsticky+(.75*Lstickx))+Rstickx);
        FrontR.setPower((Lsticky-(.75*Lstickx))-Rstickx);
        BackL.setPower((Lsticky-(.75*Lstickx))+Rstickx);
        BackR.setPower((Lsticky+(.75*Lstickx))-Rstickx);
    }
    public void gyroDrive (double Lsticky, double Lstickx, double Rstickx, double gyro){
        FrontL.setPower(((Lsticky-gyro)+(.75*(Lstickx+gyro)))+Rstickx);
        FrontR.setPower(((Lsticky-gyro)-(.75*(Lstickx+gyro)))-Rstickx);
        BackL.setPower(((Lsticky-gyro)-(.75*(Lstickx+gyro)))+Rstickx);
        BackR.setPower(((Lsticky-gyro)+(.75*(Lstickx+gyro)))-Rstickx);
    }
}
