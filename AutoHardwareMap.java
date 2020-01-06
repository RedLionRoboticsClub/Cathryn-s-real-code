package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class AutoHardwareMap {

    //Define Motors/Servos
    public DcMotor motorFL   = null;
    public DcMotor motorFR   = null;
    public DcMotor motorBL   = null;
    public DcMotor motorBR   = null;
    public CRServo slide     = null;

    public CRServo grabBoi   = null;

    // Local OpMode members

    HardwareMap hwMap  = null;
    private ElapsedTime period  = new ElapsedTime();

    // Constructor
    public AutoHardwareMap() {
    }

    //Initialize standard Hardware interfaces
    public void init(HardwareMap ahwMap) {
        // save reference to HW Map
        hwMap = ahwMap;

        // Define and Initialize Motors/Servos
        motorFL = hwMap.get(DcMotor.class, "motorFL");
        motorFR = hwMap.get(DcMotor.class, "motorFR");
        motorBL = hwMap.get(DcMotor.class, "motorBL");
        motorBR = hwMap.get(DcMotor.class, "motorBR");
        slide   = hwMap.get(CRServo.class, "slide");

        // Set all motors to zero power

        motorFL.setPower(0);
        motorFR.setPower(0);
        motorBL.setPower(0);
        motorBR.setPower(0);

        // May want to use RUN_USING_ENCODERS if encoders are installed.

        motorFL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorFR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorBL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorBR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        motorFL.setDirection(DcMotor.Direction.REVERSE);
        motorBL.setDirection(DcMotor.Direction.REVERSE);
        motorFR.setDirection(DcMotor.Direction.FORWARD);
        motorBR.setDirection(DcMotor.Direction.FORWARD);

        // Define and initialize ALL installed servos

        grabBoi = hwMap.get(CRServo.class, "grabBoi");

        grabBoi.setDirection(DcMotorSimple.Direction.FORWARD);

    }
}
