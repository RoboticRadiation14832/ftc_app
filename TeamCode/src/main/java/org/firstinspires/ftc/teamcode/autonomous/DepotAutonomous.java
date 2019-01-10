package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name= "Depot Autonomous")
public class DepotAutonomous extends LinearOpMode {

    public static final int ENCODERS_PER_INCH = 153;
    public static final double RADIUS_INCH = 6.5;
    private DcMotor left, right;

    @Override
    public void runOpMode() throws InterruptedException {
        left = hardwareMap.dcMotor.get("left");
        right = hardwareMap.dcMotor.get("right");
        right.setDirection(DcMotorSimple.Direction.REVERSE);
        left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        waitForStart();

        driveForward(24);
        turn(90);
        driveForward(24);
        turn(90);
        driveForward(24);
        turn(90);
        driveForward(24);
        turn(90);

    }

    public void driveForward(int inches)
    {
        left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        left.setTargetPosition(left.getCurrentPosition() + ENCODERS_PER_INCH * inches);
        right.setTargetPosition(right.getCurrentPosition() + ENCODERS_PER_INCH * inches);

        left.setPower(1);
        right.setPower(1);
        while (left.isBusy()|| right.isBusy() && opModeIsActive());
        left.setPower(0);
        right.setPower(0);

    }

    public void turn(int degrees)
    {
        left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        left.setTargetPosition(left.getCurrentPosition() + ENCODERS_PER_INCH
                                * (int)(Math.PI / 180 * RADIUS_INCH * degrees) );
        right.setTargetPosition(right.getCurrentPosition() - ENCODERS_PER_INCH
                                * (int)(Math.PI / 180 * RADIUS_INCH * degrees));

        left.setPower(1);
        right.setPower(1);
        while (left.isBusy()|| right.isBusy() && opModeIsActive());
        left.setPower(0);
        right.setPower(0);
    }
}
