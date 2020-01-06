package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.Range;

import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.FORWARD;

@TeleOp(name="Weird", group="Test")
@Disabled
public class Weird extends LinearOpMode {

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
        while (opModeIsActive()) {

             if (gamepad1.x) {
                robot.grabBoi.setPower(1);
            } else if (gamepad1.b) {
                robot.grabBoi.setPower(-1);
            } else{
                robot.grabBoi.setPower(0);
            }
        }

    }
}

