package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;


@Autonomous(name="AutoStoneBlue", group="Test")


public class AutoStoneBlue extends LinearOpMode {

    //variables
    AutoHardwareMap robot = new AutoHardwareMap();

    @Override

    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);

        waitForStart();
        moveForward(.2, 300);
        strafeRight(.16,190);
        turnRight(.17,800);
        strafeLeft(.26,1590);
        ungrab();
        moveForward(.2,300);
        grab();
        hold();
        sleep(400);
        raisearm(120);
        moveBackward(.2,200);
        strafeRight(.2,1175);
        turnLeft(.17,1610);
        moveForward(.25,1060);
        lowerarm(120);
        ungrab();
        moveForward(.1,70);
        grab();
        sleep(100);
        hold();
        sleep(300);
        raisearm(450);
        moveForward(.18,950);
       // strafeRight(.2,295);
        // strafeLeft(.2,295);
        lowerarm(110);
        ungrab();
        raisearm(510);
        // strafeRight(.2,295);
        // strafeLeft(.2,295);
        strafeRight(.2,300);
        lowerarm(350);
        moveBackward(.3,1100);
        strafeRight(.2,300);
    }

    public void moveForward(double power, int tick) throws InterruptedException {

        //Set encoder values to 0

        robot.motorBR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.motorFR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.motorBL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.motorFL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.motorBR.setTargetPosition(tick);
        robot.motorFR.setTargetPosition(tick);
        robot.motorBL.setTargetPosition(tick);
        robot.motorFL.setTargetPosition(tick);

        //Set the mode to RUN_TO_POSITION, this allows the robot to set a target position and stop when it reaches it

        robot.motorBR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.motorFR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.motorBL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.motorFL.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        //Set target position

        robot.motorBR.setTargetPosition(tick);
        robot.motorFR.setTargetPosition(tick);
        robot.motorBL.setTargetPosition(tick);
        robot.motorFL.setTargetPosition(tick);

        //Gives the motors power

        robot.motorBR.setPower(power);
        robot.motorFR.setPower(power);
        robot.motorBL.setPower(power);
        robot.motorFL.setPower(power);

        //Busywait, it also stops the motors when the encoders reach the target position by using motorBR as a sample for all of the motors

        while (opModeIsActive() && robot.motorBR.isBusy()) {

            if (robot.motorBR.getCurrentPosition() >= tick){

                stopMotors();

                //the telemetry will notify that the target has been reached

                telemetry.addData("Target Reached","");

                telemetry.update();

            }else {

                //the telemetry will display the current position of the motors

                telemetry.addData("CurrentPos", "%7d, %7d, %7d, %7d", robot.motorBR.getCurrentPosition(), robot.motorBL.getCurrentPosition(), robot.motorFR.getCurrentPosition(), robot.motorFL.getCurrentPosition());

                telemetry.update();

                sleep(1);

            }
        }
    }

    public void moveBackward(double power, int tick) throws InterruptedException {


        robot.motorBR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.motorFR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.motorBL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.motorFL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.motorBR.setTargetPosition(-tick);
        robot.motorFR.setTargetPosition(-tick);
        robot.motorBL.setTargetPosition(-tick);
        robot.motorFL.setTargetPosition(-tick);

        robot.motorBR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.motorFR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.motorBL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.motorFL.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        robot.motorBR.setTargetPosition(-tick);
        robot.motorFR.setTargetPosition(-tick);
        robot.motorBL.setTargetPosition(-tick);
        robot.motorFL.setTargetPosition(-tick);

        robot.motorBR.setPower(power);
        robot.motorFR.setPower(power);
        robot.motorBL.setPower(power);
        robot.motorFL.setPower(power);

        while (opModeIsActive() && robot.motorBR.isBusy()) {

            if (robot.motorBR.getCurrentPosition() >= tick){

                stopMotors();

                telemetry.addData("Target Reached","");

                telemetry.update();

            }else {

                telemetry.addData("CurrentPos", "%7d, %7d, %7d, %7d", robot.motorBR.getCurrentPosition(), robot.motorBL.getCurrentPosition(), robot.motorFR.getCurrentPosition(), robot.motorFL.getCurrentPosition());

                telemetry.update();

                sleep(1);

            }
        }
    }

    public void strafeLeft(double power, int tick) throws InterruptedException {


        robot.motorBR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.motorFR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.motorBL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.motorFL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.motorBR.setTargetPosition(-tick);
        robot.motorFR.setTargetPosition(tick);
        robot.motorBL.setTargetPosition(tick);
        robot.motorFL.setTargetPosition(-tick);

        robot.motorBR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.motorFR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.motorBL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.motorFL.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        robot.motorBR.setTargetPosition(-tick);
        robot.motorFR.setTargetPosition(tick);
        robot.motorBL.setTargetPosition(tick);
        robot.motorFL.setTargetPosition(-tick);

        robot.motorBR.setPower(power);
        robot.motorFR.setPower(power);
        robot.motorBL.setPower(power);
        robot.motorFL.setPower(power);

        while (opModeIsActive() && robot.motorBR.isBusy()) {

            if (robot.motorBR.getCurrentPosition() >= tick){

                stopMotors();

                telemetry.addData("Target Reached","");

                telemetry.update();

            }else {

                telemetry.addData("CurrentPos", "%7d, %7d, %7d, %7d", robot.motorBR.getCurrentPosition(), robot.motorBL.getCurrentPosition(), robot.motorFR.getCurrentPosition(), robot.motorFL.getCurrentPosition());

                telemetry.update();

                sleep(1);

            }
        }
    }

    public void strafeRight(double power, int tick) throws InterruptedException {


        robot.motorBR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.motorFR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.motorBL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.motorFL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.motorBR.setTargetPosition(tick);
        robot.motorFR.setTargetPosition(-tick);
        robot.motorBL.setTargetPosition(-tick);
        robot.motorFL.setTargetPosition(tick);

        robot.motorBR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.motorFR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.motorBL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.motorFL.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        robot.motorBR.setTargetPosition(tick);
        robot.motorFR.setTargetPosition(-tick);
        robot.motorBL.setTargetPosition(-tick);
        robot.motorFL.setTargetPosition(tick);

        robot.motorBR.setPower(power);
        robot.motorFR.setPower(power);
        robot.motorBL.setPower(power);
        robot.motorFL.setPower(power);

        while (opModeIsActive() && robot.motorBR.isBusy()) {

            if (robot.motorBR.getCurrentPosition() >= tick){

                stopMotors();

                telemetry.addData("Target Reached","");

                telemetry.update();

            }else {

                telemetry.addData("CurrentPos", "%7d, %7d, %7d, %7d", robot.motorBR.getCurrentPosition(), robot.motorBL.getCurrentPosition(), robot.motorFR.getCurrentPosition(), robot.motorFL.getCurrentPosition());

                telemetry.update();

                sleep(1);

            }
        }
    }

    public void turnRight(double power, int tick) throws InterruptedException {


        robot.motorBR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.motorFR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.motorBL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.motorFL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.motorBR.setTargetPosition(-tick);
        robot.motorFR.setTargetPosition(-tick);
        robot.motorBL.setTargetPosition(tick);
        robot.motorFL.setTargetPosition(tick);

        robot.motorBR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.motorFR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.motorBL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.motorFL.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        robot.motorBR.setTargetPosition(-tick);
        robot.motorFR.setTargetPosition(-tick);
        robot.motorBL.setTargetPosition(tick);
        robot.motorFL.setTargetPosition(tick);

        robot.motorBR.setPower(power);
        robot.motorFR.setPower(power);
        robot.motorBL.setPower(power);
        robot.motorFL.setPower(power);

        while (opModeIsActive() && robot.motorBR.isBusy()) {

            if (robot.motorBR.getCurrentPosition() >= tick){

                stopMotors();

                telemetry.addData("Target Reached","");

                telemetry.update();

            }else {

                telemetry.addData("CurrentPos", "%7d, %7d, %7d, %7d", robot.motorBR.getCurrentPosition(), robot.motorBL.getCurrentPosition(), robot.motorFR.getCurrentPosition(), robot.motorFL.getCurrentPosition());

                telemetry.update();

                sleep(1);

            }
        }
    }

    public void turnLeft(double power, int tick) throws InterruptedException { //800 = quarter turn


        robot.motorBR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.motorFR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.motorBL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.motorFL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.motorBR.setTargetPosition(tick);
        robot.motorFR.setTargetPosition(tick);
        robot.motorBL.setTargetPosition(-tick);
        robot.motorFL.setTargetPosition(-tick);

        robot.motorBR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.motorFR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.motorBL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.motorFL.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        robot.motorBR.setTargetPosition(tick);
        robot.motorFR.setTargetPosition(tick);
        robot.motorBL.setTargetPosition(-tick);
        robot.motorFL.setTargetPosition(-tick);

        robot.motorBR.setPower(power);
        robot.motorFR.setPower(power);
        robot.motorBL.setPower(power);
        robot.motorFL.setPower(power);

        while (opModeIsActive() && robot.motorBR.isBusy()) {

            if (robot.motorBR.getCurrentPosition() >= tick){

                stopMotors();

                telemetry.addData("Target Reached","");

                telemetry.update();

            }else {

                telemetry.addData("CurrentPos", "%7d, %7d, %7d, %7d", robot.motorBR.getCurrentPosition(), robot.motorBL.getCurrentPosition(), robot.motorFR.getCurrentPosition(), robot.motorFL.getCurrentPosition());

                telemetry.update();

                sleep(1);

            }
        }
    }

    public void stopMotors() throws InterruptedException {
        robot.motorBR.setPower(0);
        robot.motorBL.setPower(0);
        robot.motorFR.setPower(0);
        robot.motorFL.setPower(0);
    }

    public void grab(){
        robot.grabBoi.setPower(1);
        sleep(800);
        robot.grabBoi.setPower(0);
    }

    public void ungrab(){
        robot.grabBoi.setPower(-1);
        sleep(800);
        robot.grabBoi.setPower(0);
    }

    public void hold(){
        robot.grabBoi.setPower(.05);
    }


    //300 gets over the foundation
    public void raisearm(int time){
        robot.slide.setPower(1);
        sleep(time);
        robot.slide.setPower(0);
    }
    //Should be equal to amount raised
    public void lowerarm(int time){
        robot.slide.setPower(-1);
        sleep(time);
        robot.slide.setPower(0);
    }
}


