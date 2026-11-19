package org.firstinspires.ftc.teamcode.Turrets;

import static java.lang.Math.atan2;
import static java.lang.Math.sqrt;
import static java.lang.Math.toRadians;

import org.firstinspires.ftc.teamcode.Octomom.OctoQuadFWv3;

public class B29Math {
    public static double AimerMath(OctoQuadFWv3.LocalizerDataBlock localizer){
        float robotx = localizer.posX_mm;
        float roboty = localizer.posY_mm;
        float robotangleR = localizer.heading_rad;
        float robotvx = localizer.velX_mmS;
        float robotvy = localizer.velY_mmS;
        float targetx = 0;
        float targety = 0;
        float xdelta = robotx - targety;
        float ydelta = roboty - targety;
        double distance = sqrt(xdelta*xdelta+ydelta*ydelta);
        double ballvel = distance * 1;
        double time = distance/ballvel;
        double rawangle = atan2(ydelta + robotvy * time,xdelta + robotvx * time);
        double realangle = rawangle - robotangleR;
        double turretPosition = (realangle / toRadians(180));
        return(turretPosition);
    }
}
