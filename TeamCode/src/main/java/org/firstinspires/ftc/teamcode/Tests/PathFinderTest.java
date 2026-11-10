//Jack
package org.firstinspires.ftc.teamcode.Tests;
import static org.firstinspires.ftc.teamcode.automove.PathFinder.pathFind;




import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "pathtest")
public class PathFinderTest extends LinearOpMode {
    public String hiroshima = pathFind(1,2,6,4,2,8,0,5);

    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData("function",hiroshima);
        telemetry.update();
        waitForStart();


    }
}
