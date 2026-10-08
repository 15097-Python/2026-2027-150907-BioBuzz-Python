package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Motors")
public class Motors extends LinearOpMode {

    @Override
    public void runOpMode() {
        DcMotor FL = hardwareMap.get(DcMotor.class, "FL");
        DcMotor FR = hardwareMap.get(DcMotor.class, "FR");
        DcMotor BL = hardwareMap.get(DcMotor.class, "BL");
        DcMotor BR = hardwareMap.get(DcMotor.class, "BR");

        FL.setDirection(DcMotor.Direction.REVERSE);
        BL.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();

        while (opModeIsActive()) {
            double y  = -gamepad1.left_stick_y;
            double x  =  gamepad1.left_stick_x;
            double rx =  gamepad1.right_stick_x;

            double denom = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1.0);

            FL.setPower((y + x + rx) / denom);
            BL.setPower((y - x + rx) / denom);
            FR.setPower((y - x - rx) / denom);
            BR.setPower((y + x - rx) / denom);
        }
    }
}