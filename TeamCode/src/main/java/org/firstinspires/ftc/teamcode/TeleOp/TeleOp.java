package org.firstinspires.ftc.teamcode.TeleOp;
import static org.firstinspires.ftc.teamcode.DrivetrainMath.MotorpowerInputMath.MotorPowerArray;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.DrivetrainMath.MotorpowerInputMath;
@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "TeleOp!!!uwu")
public class TeleOp extends LinearOpMode {
  @Override
  public void runOpMode(){
    //setting motors up
    DcMotor BR = hardwareMap.get(DcMotor.class, "BR");
    DcMotor BL = hardwareMap.get(DcMotor.class, "BL");
    DcMotor FL = hardwareMap.get(DcMotor.class, "FL");
    DcMotor FR = hardwareMap.get(DcMotor.class, "FR");
    FL.setDirection(DcMotor.Direction.REVERSE);
    BL.setDirection(DcMotor.Direction.REVERSE);
    FL.setDirection(DcMotor.Direction.FORWARD);
    BR.setDirection(DcMotor.Direction.FORWARD);
    BR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    FL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    FR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    FL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    waitForStart();
    while (opModeIsActive()) {

      //Stick inputting, evaluating, and setting motor power
      double leftstickinputy = gamepad1.left_stick_y;
      double leftstickinputx = gamepad1.left_stick_x;
      double targetturn = gamepad1.right_stick_x;
      boolean slowmode = gamepad1.left_trigger_pressed;
      boolean fireinthehole = gamepad1.right_trigger_pressed;
      double currentrelativeheading = 0;
      double[] motorpowerarray = MotorpowerInputMath.MotorPowerArray(leftstickinputy, -leftstickinputx, targetturn, currentrelativeheading);
      double BRmotorpower = motorpowerarray[0];
      double BLmotorpower = motorpowerarray[1];
      double FRmotorpower = motorpowerarray[2];
      double FLmotorpower = motorpowerarray[3];
      BR.setPower(BRmotorpower);
      BL.setPower(BLmotorpower);
      FR.setPower(FRmotorpower);
      FL.setPower(FLmotorpower);




    }
  }
}





