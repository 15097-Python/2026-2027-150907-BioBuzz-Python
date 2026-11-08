package org.firstinspires.ftc.teamcode.DrivetrainMath;

import org.firstinspires.ftc.teamcode.TeleOp.TeleOp;

public class AccelLimit {
    public double targetVelocity = 0;
    public double currentVelocity = 0;
    public void setTargetVelocity(double newTargetVelocity) {
        this.targetVelocity = newTargetVelocity;
    }
    public void LimitAcceleration() {
        if (TeleOp.timer.milliseconds() % 100 <= 10) {

            final double accelerationDelta = .2;
            double velocityDelta = targetVelocity - currentVelocity;
            if (Math.abs(velocityDelta) < accelerationDelta) {
                this.currentVelocity = targetVelocity;
                return;
            }
            if (velocityDelta > 0) this.currentVelocity += accelerationDelta;
            if (velocityDelta < 0) this.currentVelocity -= accelerationDelta;
        }
    }
}
