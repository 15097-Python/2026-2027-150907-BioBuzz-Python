package org.firstinspires.ftc.teamcode.automove;

public class PathFinder {
    public static String pathFind(double robotX, double robotY, double targetX, double targetY, double midOneX, double midOneY, double midTwoX, double midTwoY){
        double x_0; double x_1; double x_2; double x_3; double y_0; double y_1; double y_2; double y_3;
        x_0 = robotX;
        y_0 = robotY;
        x_1 = midOneX;
        y_1 = midOneY;
        x_2 = midTwoX;
        y_2 = midTwoY;
        x_3 = targetX;
        y_3 = targetY;



        String outputfunction = "((1-t)((1-t)((1-t)" + x_0 + "+t" + x_1 + ")+t((1-t)" + x_1 + "+t" + x_2 + "))+t((1-t)((1-t)" + x_1 + "+t" + x_2 + ")+t((1-t)" + x_2 + "+t" + x_3 + ")), (1-t)((1-t)((1-t)" + y_0 + "+t" + y_1 + ")+t((1-t)" + y_1 + "+t" + y_2 + "))+t((1-t)((1-t)" + y_1 + "+t" + y_2 + ")+t((1-t)" + y_2 + "+t" + y_3 + ")))";

        return(outputfunction);
    }
}
