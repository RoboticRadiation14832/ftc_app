package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous (name= "autonomous")
public class Auntonomus extends LinearOpMode{

    public static final int ENCODERS_PER_INCH = 1100;

    @Override
    public void runOpMode() throws InterruptedException {
        DcMotor left = hardwareMap.dcMotor.get("left");
        DcMotor right = hardwareMap.dcMotor.get("right");
        right.setDirection(DcMotorSimple.Direction.REVERSE);
        left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        waitForStart();

        left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        left.setTargetPosition(ENCODERS_PER_INCH * 8);
        right.setTargetPosition(ENCODERS_PER_INCH * 8);

        left.setPower(1);
        right.setPower(1);
        while (left.isBusy()|| right.isBusy() && opModeIsActive());
        left.setPower(0);
        right.setPower(0);

    }
}
