package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Sasiu {
    private DcMotor motorL, motorR;

    public Sasiu(HardwareMap hardwareMap) {
        motorR = hardwareMap.dcMotor.get("motorR");
        motorL = hardwareMap.dcMotor.get("motorL");

        motorL.setDirection(DcMotorSimple.Direction.FORWARD);
        motorL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        motorR.setDirection(DcMotorSimple.Direction.REVERSE);
        motorR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void putereStanga(double speed) {motorL.setPower(speed);}
    public void putereDreapta(double speed) {motorR.setPower(speed);}

    public void setMotorPowers(double speedStanga, double speedDreapta){
        motorL.setPower(speedStanga);
        motorR.setPower(speedDreapta);

    }

    public void stop(){
        motorL.setPower(0);
        motorR.setPower(0);
    }

//da

}
