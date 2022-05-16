package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.subsystems.Motoare;

public class Robot {
    private boolean initialize;
    public Motoare motoare;

    public Robot(HardwareMap hardwareMap) {
        initialize = true;
        motoare = new Motoare(hardwareMap);
        initialize = false;
    }

    public boolean isInitialize() {
        return initialize;
    }
}
