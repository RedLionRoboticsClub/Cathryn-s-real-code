package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.Range;

import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.FORWARD;

@TeleOp(name="TeleOpTank", group="Test")

public class TeleOpTank extends LinearOpMode {

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



        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()){

            //---------------------
            //------GAMEPAD 1------
            //---------------------

            //-------WHEELS--------
            double yLValue = gamepad1.left_stick_y;
            double yRValue = gamepad1.right_stick_y;
            double xLValue = gamepad1.left_stick_x;
            double xRValue = gamepad1.right_stick_x;

            double motorPower;

            double radL = Math.sqrt(Math.pow(xLValue,2)+Math.pow(yLValue,2));

            double radR = Math.sqrt(Math.pow(xRValue,2)+Math.pow(yRValue,2));


            if (gamepad1.left_bumper) {
                motorPower = .5;
            } else if (gamepad1.right_bumper) {
                motorPower = .25;
            } else
                motorPower = 1;

            //Movement
            yLValue = Range.clip(yLValue, -1, 1);
            yRValue = Range.clip(yRValue, -1, 1);
            xLValue = Range.clip(xLValue, -1, 1);
            xRValue = Range.clip(xRValue, -1, 1);

                if (yLValue > 0 && radL > .1) {
                robot.motorFL.setPower(motorPower);
                robot.motorBL.setPower(motorPower);
            }   if (yLValue < 0 && radL > .1) {
                robot.motorFL.setPower(-motorPower);
                robot.motorBL.setPower(-motorPower);
            }   if (yRValue > 0 && radR > .1){
                robot.motorFR.setPower(motorPower);
                robot.motorBR.setPower(motorPower);
            }   if (yRValue < 0 && radR > .1){
                robot.motorFR.setPower(-motorPower);
                robot.motorBR.setPower(-motorPower);
            }   if (gamepad1.right_trigger > 0){

                robot.motorFL.setPower(-motorPower);
                robot.motorBR.setPower(-motorPower);
                robot.motorBL.setPower(motorPower);
                robot.motorFR.setPower(motorPower);

            }   if (gamepad1.left_trigger > 0){
                robot.motorFL.setPower(motorPower);
                robot.motorBR.setPower(motorPower);
                robot.motorBL.setPower(-motorPower);
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


            if (gamepad2.a) {
                robot.slide.setPower(1);
            } if (gamepad2.y) {
                robot.slide.setPower(-.95);
            } else {
                robot.slide.setPower(0);
            } if (gamepad2.left_trigger > .1) {
                robot.grabBoi.setDirection(DcMotorSimple.Direction.REVERSE);
                robot.grabBoi.setPower(1);
            } else if (gamepad2.right_trigger > .1) {
                robot.grabBoi.setDirection(DcMotorSimple.Direction.FORWARD);
                robot.grabBoi.setPower(1);

            } else{
                robot.grabBoi.setPower(0);
            }
        }

    }
}
