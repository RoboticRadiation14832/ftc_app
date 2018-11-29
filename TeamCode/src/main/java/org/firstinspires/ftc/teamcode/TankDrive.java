package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="TankDrive")
public class TankDrive extends OpMode
{
    private DcMotor leftMotor;
    private DcMotor rightMotor;
    private DcMotor Elbow;
    private DcMotor Arm;

        @Override
        public void init()
        {
            leftMotor = hardwareMap.dcMotor.get("left");
            rightMotor = hardwareMap.dcMotor.get("right");
            Elbow = hardwareMap.dcMotor.get("Elbow");
            Arm = hardwareMap.dcMotor.get("Arm");
        }
        @Override
        public void loop ()
        {
            // Invert the left motor because the joystick 'forward' is negative and we want to go forward
            leftMotor.setPower(-gamepad1.right_stick_y);
            // Don't invert the right motor because it is on the other side of the robot
            rightMotor.setPower(gamepad1.left_stick_y);
            if(gamepad1.left_trigger > 0)
            {
                Elbow.setPower(-gamepad1.left_trigger);
            }
            if (gamepad1.right_trigger > 0)
            {
                Elbow.setPower(gamepad1.right_trigger);
            }
            if(gamepad1.left_bumper)
            {
                Arm.setPower(-0.5);
            }
            if (gamepad1.right_bumper)
            {
                Arm.setPower(0.5);
            }
        }

}
