package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;


@Autonomous(name="AutoPractice", group="Test")
@Disabled

public class AutoPractice extends LinearOpMode {

    //variables
    AutoHardwareMap robot = new AutoHardwareMap();
    private ElapsedTime runtime = new ElapsedTime();

    private String Order = null;

    private static final String TFOD_MODEL_ASSET = "RoverRuckus.tflite";

  /*  private static final String LABEL_GOLD_MINERAL = "Gold Mineral";
    private static final String LABEL_SILVER_MINERAL = "Silver Mineral";
    private static final String VUFORIA_KEY = "AceHAhf/////AAAAGXcP1HmPtEkhmi5YyP3W2S1gVnAvF2sEhNkTVsdCy4iDjm5aVrODZUpSZDIQZXVqOIqmjWvWcv1+56gq4NJ8h9P0m/MlKuqKbjcQNbSrxfQoBCJbD1G9gmkKFeaeKCrV/8ZQsipnso84dJHek4OfzMdvtKUU/QDrk+YCE7SWGMtZr7kFAWYss3vTpGv0WynOurUd+rly24nTP4qERK311b9MkK+uliO/slCL/vg6vANVX/NGSlXLRe4/nK0HitcsLrLjvcuRQJGeaYnzFB/ykuSZw3hFbHaSP45KH/fLivm0fql8ENaPyCLiNSDiqlSH553rXNiRenz3R9t8TW5YJjjAThy1U0F7GHtkGXKN/pfL";
    private VuforiaLocalizer vuforia;
    private TFObjectDetector tfod;

   */

    @Override

    public void runOpMode() {
        robot.init(hardwareMap);

        robot.motorBL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.motorBR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.motorBR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.motorBL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        waitForStart();
        movenorth();
        sleep(1000);
        pause();
        turnwest();
        sleep(1000);
        pause();
        turneast();
        sleep(1000);
        pause();
        strafeeast();
        sleep(1000);
        pause();
        strafewest();
        sleep(1000);
        pause();
        strafenortheast();
        sleep(1000);
        pause();
        strafesouthwest();
        sleep(1000);
        pause();
        strafenorthwest();
        sleep(1000);
        pause();
        strafesoutheast();
        sleep(1000);
        pause();
        movesouth();
        sleep(1000);
        pause();
    }

    public void pause() {
        robot.motorBL.setPower(0);
        robot.motorBR.setPower(0);
        robot.motorFL.setPower(0);
        robot.motorFR.setPower(0);
        sleep(200);
    }
    public void movenorth() {
        robot.motorBL.setPower(.5);
        robot.motorBR.setPower(.5);
        robot.motorFL.setPower(.5);
        robot.motorFR.setPower(.5);

    }
    public void movesouth() {
        robot.motorBL.setPower(-.5);
        robot.motorBR.setPower(-.5);
        robot.motorFL.setPower(-.5);
        robot.motorFR.setPower(-.5);

    }
    public void strafeeast() {
        robot.motorBL.setPower(-0.5);
        robot.motorBR.setPower(0.5);
        robot.motorFL.setPower(0.5);
        robot.motorFR.setPower(-0.5);

    }
    public void strafewest() {
        robot.motorBL.setPower(0.5);
        robot.motorBR.setPower(-0.5);
        robot.motorFL.setPower(-0.5);
        robot.motorFR.setPower(0.5);

    }
    public void turneast() {
        robot.motorBL.setPower(0.5);
        robot.motorBR.setPower(-0.5);
        robot.motorFL.setPower(0.5);
        robot.motorFR.setPower(-0.5);

    }
    public void turnwest() {
        robot.motorBL.setPower(-0.5);
        robot.motorBR.setPower(.5);
        robot.motorFL.setPower(-0.5);
        robot.motorFR.setPower(.5);

    }
    public void strafenorthwest() {
        robot.motorBL.setPower(0.5);
        robot.motorBR.setPower(0);
        robot.motorFL.setPower(0);
        robot.motorFR.setPower(0.5);

    }
    public void strafenortheast() {
        robot.motorBL.setPower(0);
        robot.motorBR.setPower(0.5);
        robot.motorFL.setPower(0.5);
        robot.motorFR.setPower(0);
    }
    public void strafesoutheast() {
        robot.motorBL.setPower(-0.5);
        robot.motorBR.setPower(0);
        robot.motorFL.setPower(0);
        robot.motorFR.setPower(-0.5);
    }
    public void strafesouthwest() {
        robot.motorBL.setPower(0);
        robot.motorBR.setPower(-0.5);
        robot.motorFL.setPower(-0.5);
        robot.motorFR.setPower(0);
    }





}


