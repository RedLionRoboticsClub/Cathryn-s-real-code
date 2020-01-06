package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;


@Autonomous(name="AAAAAAAAAAAAA also Cathryn", group="AAAAAAAAAAAAA Cathryn")


public class Cathrynsnameisspeltweirddotcom extends LinearOpMode {

    //variables
    AutoHardwareMap robot = new AutoHardwareMap();

    @Override

    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);

        waitForStart();
        MoveForward(.6, 300);
        moveBackward(.6, 1000);

    }

    public void MoveForward(double power, int milliseconds) throws InterruptedException {

        robot.motorFR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.motorFL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.motorBR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.motorBL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        for milliseconds
                robot.motorFR.set


    }
}

