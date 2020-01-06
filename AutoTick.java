package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;


@Autonomous(name="AutoTick", group="Test")

@Disabled
public class AutoTick extends LinearOpMode {

    //variables
    AutoHardwareMap robot = new AutoHardwareMap();

    @Override

    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);

        waitForStart();
        moveMotors(0.5,1000);
        stopMotors();

    }

   /* void moveMotors (double powerBL, double powerBR, double powerFL, double powerFR, int posBL, int posBR, int posFL, int posFR, int time)
    {
        robot.motorBL.setDirection(DcMotor.Direction.FORWARD);
        robot.motorBR.setDirection(DcMotor.Direction.REVERSE);
        robot.motorFL.setDirection(DcMotor.Direction.FORWARD);
        robot.motorFR.setDirection(DcMotor.Direction.REVERSE);

        robot.motorBL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.motorBR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.motorFR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.motorFL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.motorBL.setTargetPosition(posBL);
        robot.motorBR.setTargetPosition(posBR);
        robot.motorFR.setTargetPosition(posFR);
        robot.motorFL.setTargetPosition(posFL);


        sleep(time);
        }
        */


    public void moveMotors(double power, int tick) throws InterruptedException {

        robot.motorBL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.motorBR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.motorFL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.motorFR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        sleep(20);

        robot.motorBR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.motorBL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.motorFR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.motorFL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        robot.motorBL.setTargetPosition(tick);
        robot.motorBR.setTargetPosition(tick);
        robot.motorFL.setTargetPosition(tick);
        robot.motorFR.setTargetPosition(tick);

        robot.motorBL.setPower(power);
        robot.motorBR.setPower(power);
        robot.motorBL.setPower(power);
        robot.motorBR.setPower(power);



        while (opModeIsActive() &&
                    (robot.motorBR.isBusy() && robot.motorBL.isBusy())) {

                telemetry.addData("Path1", "Running to %7d :%7d", tick, tick);
                telemetry.addData("Path2", "Running at %7d :%7d",
                        robot.motorBR.getCurrentPosition(),
                        robot.motorBL.getCurrentPosition());
                telemetry.update();
            }

/*
        robot.motorBR.setPower(0);
        robot.motorBL.setPower(0);
        robot.motorFR.setPower(0);
        robot.motorFL.setPower(0);

        robot.motorBR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.motorBL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.motorFR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.motorFL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
*/
    }

    public void stopMotors() throws InterruptedException {
        robot.motorBR.setPower(0);
        robot.motorBL.setPower(0);
        robot.motorFR.setPower(0);
        robot.motorFL.setPower(0);
    }


}