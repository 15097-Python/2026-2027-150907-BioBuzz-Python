package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx; // Added for velocity control

@TeleOp(name = "Motors")
public class Motors extends LinearOpMode {

    @Override
    public void runOpMode() {
        DcMotorEx FL = hardwareMap.get(DcMotorEx.class, "FL");
        DcMotorEx FR = hardwareMap.get(DcMotorEx.class, "FR");
        DcMotorEx BL = hardwareMap.get(DcMotorEx.class, "BL");
        DcMotorEx BR = hardwareMap.get(DcMotorEx.class, "BR");

        FL.setDirection(DcMotor.Direction.REVERSE);
        BL.setDirection(DcMotor.Direction.REVERSE);

        FL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        FR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        final double MAX_TICKS_PER_SECOND = 2800.0;

        waitForStart();

        while (opModeIsActive()) {
            double y = 0;
            if (gamepad1.dpad_up) y = 1.0;
            else if (gamepad1.dpad_down) y = -1.0;

            double x = 0;
            if (gamepad1.dpad_right) x = 1.0;
            else if (gamepad1.dpad_left) x = -1.0;

            double rx = gamepad1.right_stick_x;

            double denom = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1.0);

            FL.setVelocity(((y + x + rx) / denom) * MAX_TICKS_PER_SECOND);
            BL.setVelocity(((y - x + rx) / denom) * MAX_TICKS_PER_SECOND);
            FR.setVelocity(((y - x - rx) / denom) * MAX_TICKS_PER_SECOND);
            BR.setVelocity(((y + x - rx) / denom) * MAX_TICKS_PER_SECOND);
        }
    }
}