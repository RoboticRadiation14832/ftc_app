package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="TankDrive")
public class TankDrive extends OpMode
{
    private DcMotor leftMotor;
    private DcMotor rightMotor;
    private DcMotor Elbow;
    private DcMotor Arm;
    private CRServo scoop;

        @Override
        public void init()
        {
            leftMotor = hardwareMap.dcMotor.get("left");
            rightMotor = hardwareMap.dcMotor.get("right");
            Elbow = hardwareMap.dcMotor.get("Elbow");
            Arm = hardwareMap.dcMotor.get("Arm");
            scoop = hardwareMap.crservo.get("ArmServo");
        }
        @Override
        public void loop ()
        {
            // Invert the left motor because the joystick 'forward' is negative and we want to go forward
            leftMotor.setPower(-gamepad1.right_stick_y);
            // Don't invert the right motor because it is on the other side of the robot
            rightMotor.setPower(gamepad1.left_stick_y);
            if(gamepad2.left_trigger > 0.5)
            {
                Elbow.setPower(-.5);
            }
            else if (gamepad2.right_trigger > 0.5)
            {
                Elbow.setPower(.5);
            }else{
                Elbow.setPower(0);
            }
            if(gamepad2.left_bumper)
            {
                Arm.setPower(-2);
            }
            else if (gamepad2.right_bumper)
            {
                Arm.setPower(2);
            }else{
                Arm.setPower(0);
            }
            if (gamepad2.a)
            {
                scoop.setPower(1);
            }
            if (gamepad2.y)
            {
                scoop.setPower(-1);

            }else if (gamepad1.a)
            {

                 scoop.setPower(0);
            }
            telemetry.addData("Elbow Encoder", Elbow.getCurrentPosition());
        }

}
