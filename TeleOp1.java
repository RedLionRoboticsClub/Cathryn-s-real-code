package org.firstinspires.ftc.teamcode;
import android.widget.ToggleButton;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="TeleOp1", group="Test")

public class TeleOp1 extends LinearOpMode {

    //Connect Hardware Maps
    BasicHardwareMap1920 robot = new BasicHardwareMap1920();

    //final double box_speed = 0.01;
    //double box_position = robot.box_home;

    //Run LinearOpMode
    @Override
    public void runOpMode() {

        //Initiate Hardware Map
        robot.init(hardwareMap);


        //Add Telemetry to confirm Robot Start. Recommended to name her here
        double motorPower = 1;
        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            //---------------------
            //------GAMEPAD 1------
            //---------------------

            //-------WHEELS--------
            double yLValue = gamepad1.left_stick_y;
            double yRValue = gamepad1.right_stick_y;
            double xLValue = gamepad1.left_stick_x;
            double xRValue = gamepad1.right_stick_x;

            double rad = Math.sqrt(Math.pow(xRValue,2)+Math.pow(yRValue,2));

            double angle;

            double angletrue = Math.atan (Math.abs(yRValue) / Math.abs(xRValue));




            if (yRValue < 0){
                angle = (Math.atan(yRValue / xRValue) + Math.PI);
            }
            else {
               angle = Math.atan(yRValue / xRValue);
            }

            boolean changed = false;

            if(gamepad1.x && !changed){
                if(motorPower == 1 && !changed){
                        motorPower = .5;
                        changed = true;
                }
                else if (motorPower == .5 && !changed){
                        motorPower = 1;
                        changed = true;

                }
                else {
                    changed = true;
                }
            }
            else {
                changed = true;
            }

            telemetry.addData ("motorPower =", motorPower);

            telemetry.addData ("Changed =", changed);

            //Movement
                yLValue = Range.clip(yLValue, -1, 1);
                yRValue = Range.clip(yRValue, -1, 1);
                xLValue = Range.clip(xLValue, -1, 1);
                xRValue = Range.clip(xRValue, -1, 1);

             if (gamepad1.left_stick_x >= .1) {
                robot.motorFL.setPower(-motorPower);
                robot.motorBL.setPower(-motorPower);
                robot.motorBR.setPower(motorPower);
                robot.motorFR.setPower(motorPower);
            }else if (gamepad1.left_stick_x <= -.1) {
                 robot.motorFL.setPower(motorPower);
                 robot.motorBL.setPower(motorPower);
                 robot.motorBR.setPower(-motorPower);
                 robot.motorFR.setPower(-motorPower);
             } if (rad >= .1 && angletrue <= Math.PI / 4 && xRValue > 0) {
                 robot.motorFL.setPower(-motorPower);
                 robot.motorBL.setPower(motorPower);
                 robot.motorBR.setPower(-motorPower);
                 robot.motorFR.setPower(motorPower);
            }else if (rad >= .1 && angletrue > Math.PI / 4 && yRValue > 0) {
                 robot.motorFL.setPower(motorPower);
                 robot.motorBL.setPower(motorPower);
                 robot.motorBR.setPower(motorPower);
                 robot.motorFR.setPower(motorPower);
             } if (rad >= .1 && angletrue <= Math.PI / 4 && xRValue < 0) {
                 robot.motorFL.setPower(motorPower);
                 robot.motorBL.setPower(-motorPower);
                 robot.motorBR.setPower(motorPower);
                 robot.motorFR.setPower(-motorPower);
             }else if (rad >= .1 && angletrue > Math.PI / 4 && yRValue < 0) {
                 robot.motorFL.setPower(-motorPower);
                 robot.motorBL.setPower(-motorPower);
                 robot.motorBR.setPower(-motorPower);
                 robot.motorFR.setPower(-motorPower);
             } else {
                 robot.motorFL.setPower(0);
                 robot.motorBL.setPower(0);
                 robot.motorBR.setPower(0);
                 robot.motorFR.setPower(0);
             }

            //---------------------
            //------GAMEPAD 2------
            //---------------------

             if (gamepad1.a) {
                robot.slide.setPower(.7);
            } if (gamepad1.y) {
                robot.slide.setPower (-.7);
            } else {
                robot.slide.setPower(0);
            } if (gamepad1.right_trigger > .1) {
                robot.grabBoi.setPower(1);
            } else if (gamepad1.left_trigger > .1) {
                robot.grabBoi.setPower(-1);
            } else{
                 robot.grabBoi.setPower(0);
            }
             telemetry.update();
        }

    }
}
