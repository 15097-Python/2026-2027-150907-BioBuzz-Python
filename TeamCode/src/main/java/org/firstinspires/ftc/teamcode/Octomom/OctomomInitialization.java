//Crosby
package org.firstinspires.ftc.teamcode.Octomom;
import static com.qualcomm.hardware.digitalchickenlabs.OctoQuad.EncoderDirection.FORWARD;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.hardware.digitalchickenlabs.OctoQuad;

public class OctomomInitialization {
    public static OctoQuad OctomomInitializations() {
        OctoQuad oq;

        oq = hardwareMap.get(OctoQuad.class, "octoquad");

        oq.resetLocalizerAndCalibrateIMU();
        oq.setLocalizerPortX(0);
        oq.setLocalizerPortY(1);
        oq.setSingleEncoderDirection(0,FORWARD);
        oq.setSingleEncoderDirection(1,FORWARD);
        oq.setLocalizerCountsPerMM_X(19.894F);
        oq.setLocalizerCountsPerMM_Y(19.894F);
        oq.setLocalizerImuHeadingScalar(67F);
        oq.setLocalizerTcpOffsetMM_X(166.6215F);
        oq.setLocalizerTcpOffsetMM_Y(100.1163F);
        return oq;
    }
}