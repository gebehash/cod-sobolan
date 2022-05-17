package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.subsystems.Sasiu;

public class Robot {
    private boolean initialize;
    public Sasiu motoare;

    public Robot(HardwareMap hardwareMap) {
        initialize = true;
        motoare = new Sasiu(hardwareMap);
        initialize = false;
    }

    public boolean isInitialize() {
        return initialize;
    }
}
//da