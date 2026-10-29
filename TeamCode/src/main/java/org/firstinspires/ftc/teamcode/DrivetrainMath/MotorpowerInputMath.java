package org.firstinspires.ftc.teamcode.DrivetrainMath;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

//CrosbySigmaJohnson
public class MotorpowerInputMath {
    /**
     * This function intakes all driver inputs including left stick inputs and right stick inputs
     *
     * @param leftstickinputx        the left stick's x input
     * @param leftstickinputy        the left stick's y input
     * @param targetturn             the right stick's x value
     * @param currentrelativeheading the gyro scope's value based off of the initial heading which eventualy sholud be based off of the rotation of the robot from the limelight
     * @return output x, y, and turn motor power values
     */
    public static double[] MotorPowerArray(double leftstickinputx, double leftstickinputy, double targetturn, float currentrelativeheading, boolean slowmode) {

        double targetdrivey = leftstickinputx * cos(currentrelativeheading) - leftstickinputy * sin(currentrelativeheading);
        double targetdrivex = leftstickinputx * sin(currentrelativeheading) + leftstickinputy * cos(currentrelativeheading);

        double BRmotorpower = targetdrivey + targetdrivex - targetturn;
        double BLmotorpower = targetdrivey - targetdrivex + targetturn;
        double FRmotorpower = (targetdrivey - targetdrivex) - targetturn;
        double FLmotorpower = targetdrivey + targetdrivex + targetturn;
        if (slowmode) return new double[]{BRmotorpower / 4, BLmotorpower / 4, FRmotorpower / 4, FLmotorpower / 4};
        return new double[]{BRmotorpower, BLmotorpower, FRmotorpower, FLmotorpower};
    }
}
