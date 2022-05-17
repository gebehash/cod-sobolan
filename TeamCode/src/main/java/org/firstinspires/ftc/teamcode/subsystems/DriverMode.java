package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Robot;

import java.lang.*;

@TeleOp(group = "driver")
public class DriverMode extends LinearOpMode {
    private Robot robot = null;

    //    private final double STICK_TRESHOLD = 0.1;
//    private double inputForward, inputSteer, outputLeft, outputRight, speed = 1;
    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData(">", "Initializing...");
        telemetry.update();

        robot = new Robot(hardwareMap);

        while (robot.isInitialize() && opModeIsActive()) {
            idle();
        }

        telemetry.addData(">", "Initialized");
        telemetry.update();

        waitForStart();
        if (isStopRequested()) return;

        while (opModeIsActive()) {
            //telemetry.update();

            boolean moveType = false;

            if (!moveType) {

                if (gamepad1.left_stick_y > 0.1 || gamepad1.left_stick_y < -0.1) {
                    robot.motoare.putereStanga(2 * gamepad1.left_stick_y);
                    telemetry.addData("left stick: ", gamepad1.left_stick_y);
                } else robot.motoare.putereStanga(0);

                if (gamepad1.right_stick_y > 0.1 || gamepad1.right_stick_y < -0.1) {
                    robot.motoare.putereDreapta(2 * gamepad1.right_stick_y);
                    telemetry.addData("right stick: ", gamepad1.right_stick_y);
                } else robot.motoare.putereDreapta(0);

            } else {
                if (gamepad1.right_trigger > 0.1) {
                    robot.motoare.putereStanga(2 * gamepad1.right_trigger);
                    robot.motoare.putereDreapta(2 * gamepad1.right_trigger);
                    telemetry.addData("forward: ", gamepad1.right_trigger);
                }

                if (gamepad1.left_trigger > 0.1) {
                    robot.motoare.putereStanga(-2 * gamepad1.left_trigger);
                    robot.motoare.putereDreapta(-2 * gamepad1.left_trigger);
                    telemetry.addData("reverse: ",gamepad1.left_trigger);
                }
            }

            if (gamepad1.dpad_right && !moveType) {
                moveType = true;
                telemetry.addData("moveType", moveType);
            }

            if (gamepad1.dpad_right && moveType) {
                moveType = false;
                telemetry.addData("moveType", moveType);
            }
            telemetry.update();
        }
    }
}//da