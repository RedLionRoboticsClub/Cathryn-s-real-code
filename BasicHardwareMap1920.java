package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class BasicHardwareMap1920 {

    //Define Motors/Servos
    public DcMotor motorFL     = null;
    public DcMotor motorFR     = null;
    public DcMotor motorBL     = null;
    public DcMotor motorBR     = null;
    public CRServo slide       = null;
    //public DcMotor motorLS      = null;

    public CRServo clawBoi     = null;
    public CRServo grabBoi     = null;

    //public final static double box_home = 0.9;
    public final static double linearS_home = 1.35;

    // Local OpMode members
    HardwareMap hwMap  = null;
    private ElapsedTime period  = new ElapsedTime();

    // Constructor
    public BasicHardwareMap1920() {
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
        slide = hwMap.get(CRServo.class, "slide");
      //  motorLS = hwMap.get(DcMotor.class, "motorLS");

        // Set all motors to zero power

        motorFL.setPower(0);
        motorFR.setPower(0);
        motorBL.setPower(0);
        motorBR.setPower(0);
        slide.setPower(0);

        // Set all motors to run without encoders.
        // May want to use RUN_USING_ENCODERS if encoders are installed.

        motorFL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorFR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorBL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorBR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        motorFR.setDirection(DcMotor.Direction.REVERSE);
        motorBR.setDirection(DcMotor.Direction.REVERSE);

        // Define and initialize ALL installed servos

        clawBoi = hwMap.get(CRServo.class, "clawBoi");
        grabBoi = hwMap.get(CRServo.class, "grabBoi");
        grabBoi.setDirection(DcMotorSimple.Direction.FORWARD);
        clawBoi.setDirection(DcMotorSimple.Direction.FORWARD);
    }
}
