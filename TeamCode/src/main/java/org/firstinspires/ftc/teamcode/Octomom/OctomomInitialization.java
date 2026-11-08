//Crosby
package org.firstinspires.ftc.teamcode.Octomom;
import static com.qualcomm.hardware.digitalchickenlabs.OctoQuad.EncoderDirection.FORWARD;

import com.qualcomm.hardware.digitalchickenlabs.OctoQuad;

public class OctomomInitialization {
    public static void  OctomomInitializations(OctoQuadFWv3 oq) {


        oq.setLocalizerPortX(0);
        oq.setLocalizerPortY(1);
        oq.setSingleEncoderDirection(0, OctoQuadFWv3.EncoderDirection.FORWARD);
        oq.setSingleEncoderDirection(1, OctoQuadFWv3.EncoderDirection.FORWARD);
        oq.setLocalizerCountsPerMM_X(19.894F);
        oq.setLocalizerCountsPerMM_Y(19.894F);
        oq.setLocalizerImuHeadingScalar(1.0087F);
        oq.setLocalizerTcpOffsetMM_X(166.6215F);
        oq.setLocalizerTcpOffsetMM_Y(100.1163F);
        oq.resetLocalizerAndCalibrateIMU();
    }
}