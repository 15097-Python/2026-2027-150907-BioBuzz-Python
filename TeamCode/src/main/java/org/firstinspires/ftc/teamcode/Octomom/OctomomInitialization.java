//Crosby
package org.firstinspires.ftc.teamcode.Octomom;

import com.qualcomm.robotcore.hardware.HardwareMap;

public class OctomomInitialization {
    public static OctoQuadFWv3 OctomomInitializations(HardwareMap hardwareMap) {
        OctoQuadFWv3 oq;

        oq = hardwareMap.get(OctoQuadFWv3.class, "OctoQuadFWv3");

        oq.resetLocalizerAndCalibrateIMU();
        oq.setLocalizerPortX(0);
        oq.setLocalizerPortY(1);
        oq.setSingleEncoderDirection(0,OctoQuadFWv3.EncoderDirection.FORWARD);
        oq.setSingleEncoderDirection(1,OctoQuadFWv3.EncoderDirection.FORWARD);
        oq.setLocalizerCountsPerMM_X(19.894F);
        oq.setLocalizerCountsPerMM_Y(19.894F);
        oq.setLocalizerImuHeadingScalar(67F);
        oq.setLocalizerTcpOffsetMM_X(166.6215F);
        oq.setLocalizerTcpOffsetMM_Y(100.1163F);
        return oq;
    }
}