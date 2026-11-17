package org.firstinspires.ftc.teamcode.Auto;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;


import com.pedropathing.follower.Follower;
import org.firstinspires.ftc.teamcode.pedro.Constants;
import com.pedropathing.api.PoseFactory;
import com.pedropathing.math.Pose;
import static com.pedropathing.api.Paths.*;
import com.pedropathing.paths.Path;
import com.pedropathing.ivy.Scheduler;
import static com.pedropathing.ivy.Scheduler.schedule;
import com.pedropathing.ivy.Command;
import static com.pedropathing.ivy.groups.Groups.*;
import static com.pedropathing.ivy.commands.Commands.*;
import static com.pedropathing.ivy.pedro.PedroCommands.follow;
import static com.pedropathing.ivy.groups.Groups.sequential;

@Autonomous
public class Autononmous extends OpMode {
    private Follower follower;
    private final PoseFactory p = PoseFactory.radians();
    private final Pose startPose = p.of(24, 24, 0);
    private final Pose park = p.of(48, 48, Math.toRadians(90));
    private Path park() {
        return line(startPose, park).linear(startPose, park);
    }
    @Override
    public void init() {
        follower = Constants.create(hardwareMap);
        follower.setPose(startPose);
        Scheduler.reset();


    }
    @Override
    public void start() {
        schedule(follow(follower, park()));
    }
    @Override
    public void loop() {
        follower.update();
        Scheduler.execute();
    }
}