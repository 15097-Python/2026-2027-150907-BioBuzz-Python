//Crosby//Jack
package org.firstinspires.ftc.teamcode.TeleOp;
import static org.firstinspires.ftc.teamcode.DrivetrainMath.MotorpowerInputMath.MotorPowerArray;

import com.qualcomm.hardware.digitalchickenlabs.OctoQuad;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "MAXMOTOR")
public class RUnALLMOTOR extends LinearOpMode {

  @Override
  public void runOpMode(){
    //setting motors up

    DcMotor BR = hardwareMap.get(DcMotor.class, "BR");
    DcMotor BL = hardwareMap.get(DcMotor.class, "BL");
    DcMotor FL = hardwareMap.get(DcMotor.class, "FL");
    DcMotor FR = hardwareMap.get(DcMotor.class, "FR");
    FL.setDirection(DcMotor.Direction.REVERSE);
    BL.setDirection(DcMotor.Direction.REVERSE);
    FR.setDirection(DcMotor.Direction.FORWARD);
    BR.setDirection(DcMotor.Direction.FORWARD);
    BR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    FL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    FR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    FL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    waitForStart();
    while (opModeIsActive()) {

      BR.setPower(1);
      BL.setPower(1);
      FR.setPower(1);
      FL.setPower(1);




    }
  }
}





