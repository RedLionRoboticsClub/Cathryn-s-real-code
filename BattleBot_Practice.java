package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="BattleBot_Practice", group = "Test")
@Disabled
public class BattleBot_Practice extends LinearOpMode {

    BasicHardwareMap1920 robot = new BasicHardwareMap1920();


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

            float yValue = gamepad1.left_stick_y;
            float xValue = gamepad1.right_stick_y;

            xValue = Range.clip(xValue, -1, 1);
            yValue = Range.clip(yValue, -1, 1);

            //This is the flipper
            if (gamepad1.a) {
                robot.motorFL.setPower(-.5);
                sleep(90);
                robot.motorFL.setPower(0.5);
                sleep(90);
                robot.motorFL.setPower(0);
            }

            //This is movement
            robot.motorBL.setPower(-yValue);
            robot.motorBR.setPower(-xValue);

        }
    }
}




