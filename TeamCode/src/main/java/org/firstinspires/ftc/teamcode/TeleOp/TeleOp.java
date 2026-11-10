//Crosby//Jack//Crosby
package org.firstinspires.ftc.teamcode.TeleOp;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.teamcode.DrivetrainMath.MotorpowerInputMath.MotorPowerArray;
import static org.firstinspires.ftc.teamcode.Octomom.OctomomInitialization.OctomomInitializations;

import com.qualcomm.hardware.digitalchickenlabs.OctoQuad;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.DrivetrainMath.AccelLimit;
import org.firstinspires.ftc.teamcode.DrivetrainMath.MotorpowerInputMath;

import org.firstinspires.ftc.teamcode.Octomom.OctoQuadFWv3;
import org.firstinspires.ftc.teamcode.Octomom.OctomomInitialization.*;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "TeleOp!!!uwu")
public class TeleOp extends LinearOpMode {
  float robotHeadingR;
  short robotMMPosX;
  short robotMMPosY;
  final double motorMaxVelocity = 99999999;
  public AccelLimit yStick = new AccelLimit();
  public AccelLimit xStick = new AccelLimit();
  public AccelLimit turn = new AccelLimit();
  public static ElapsedTime timer = new ElapsedTime();
  @Override
  public void runOpMode(){
    //setting motors up
    OctoQuadFWv3 oq =  hardwareMap.get(OctoQuadFWv3.class, "OctoQuadFWv3");
    OctoQuadFWv3.LocalizerDataBlock localizer;
    localizer = new OctoQuadFWv3.LocalizerDataBlock();
    DcMotorEx BR = hardwareMap.get(DcMotorEx.class, "BR");
    DcMotorEx BL = hardwareMap.get(DcMotorEx.class, "BL");
    DcMotorEx FL = hardwareMap.get(DcMotorEx.class, "FL");
    DcMotorEx FR = hardwareMap.get(DcMotorEx.class, "FR");
    FL.setDirection(DcMotor.Direction.REVERSE);
    BL.setDirection(DcMotor.Direction.REVERSE);
    FR.setDirection(DcMotor.Direction.FORWARD);
    BR.setDirection(DcMotor.Direction.FORWARD);
    BR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    FL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    FR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    FL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    OctomomInitializations(oq);
    waitForStart();
    while (opModeIsActive()) {
      oq.readLocalizerData(localizer);
      if(gamepad1.dpad_down) oq.resetLocalizerAndCalibrateIMU();

      if (localizer.crcOk) {
        // Read and display valid localizer data here
        robotHeadingR = localizer.heading_rad;
        robotMMPosX = localizer.posX_mm;
        robotMMPosY = localizer.posY_mm;
      }

      //Stick inputting, evaluating, and setting motor power

      yStick.setTargetVelocity(gamepad1.left_stick_y);
      xStick.setTargetVelocity(gamepad1.left_stick_x);
      turn.setTargetVelocity(gamepad1.right_stick_x);
      yStick.LimitAcceleration();
      xStick.LimitAcceleration();
      turn.LimitAcceleration();



      boolean slowmode = gamepad1.left_trigger_pressed;
      boolean fireinthehole = gamepad1.right_trigger_pressed;
      double[] motorpowerarray = MotorPowerArray(-xStick.currentVelocity, yStick.currentVelocity, turn.currentVelocity, robotHeadingR);
      double BRmotorpower = motorpowerarray[0] ;
      double BLmotorpower = motorpowerarray[1] ;
      double FRmotorpower = motorpowerarray[2] ;
      double FLmotorpower = motorpowerarray[3] ;
      BR.setVelocity(BRmotorpower*motorMaxVelocity);
      BL.setVelocity(BLmotorpower*motorMaxVelocity);
      FR.setVelocity(FRmotorpower*motorMaxVelocity);
      FL.setVelocity(FLmotorpower*motorMaxVelocity);


      telemetry.addData("x",localizer.posX_mm);
      telemetry.addData("y",localizer.posY_mm);
      telemetry.addData("BRmotorpower",BRmotorpower);
      telemetry.addData("BLmotorpower",BLmotorpower);
      telemetry.addData("FRmotorpower",FRmotorpower);
      telemetry.addData("FLmotorpower",FLmotorpower);
      telemetry.addData("robotheading",robotHeadingR);
      telemetry.addData("BRmotorspeed",BR.getVelocity());
      telemetry.addData("BLmotorspeed",BL.getVelocity());
      telemetry.addData("FRmotorspeed",FR.getVelocity());
      telemetry.addData("FLmotorspeed",FL.getVelocity());
      telemetry.update();

    }
  }
}





