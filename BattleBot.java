package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="BattleBot", group="Test")
@Disabled
public class BattleBot extends LinearOpMode {

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
        telemetry.addData("Say", "Hello, Endeavor Signing On");
        telemetry.addData("Say", "Deploy da boi");
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            //---------------------
            //------GAMEPAD 1------
            //---------------------


            //-------WHEELS--------
            float yValue = gamepad1.left_stick_y;
            float xValue = gamepad1.right_stick_y;

            xValue = Range.clip(xValue, -1, 1);
            yValue = Range.clip(yValue, -1, 1);

           if (gamepad1.b) {
                robot.motorFL.setPower(-1);
                sleep(90);
                robot.motorFL.setPower(-.5);
                sleep(10);
                robot.motorFL.setPower(.5);
                sleep(100);
                robot.motorFL.setPower(.2);
                sleep(100);
                robot.motorFL.setPower(0);
           }
            //Movement
            if (gamepad1.left_trigger > 0) {
                robot.motorBL.setPower(-yValue/4);
                robot.motorBR.setPower(-xValue/4);

            } else if (gamepad1.right_trigger > 0) {
                robot.motorBL.setPower(-yValue/2);
                robot.motorBR.setPower(-xValue/2);

            } else {
                robot.motorBL.setPower(-yValue);
                robot.motorBR.setPower(-xValue);
            }
        }
    }
}
