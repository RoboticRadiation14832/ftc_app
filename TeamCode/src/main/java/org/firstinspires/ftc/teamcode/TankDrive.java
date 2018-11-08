package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="TeleOp")
public class TankDrive extends OpMode
{
    public DcMotor leftMotor;
    public DcMotor rightMotor;

        @Override
        public void init()
        {
            leftMotor = hardwareMap.dcMotor.get("left");
            rightMotor = hardwareMap.dcMotor.get("right");
        }
        @Override
        public void loop ()
        {
            // Invert the left motor because the joystick 'forward' is negative and we want to go forward
            leftMotor.setPower(-gamepad1.left_stick_y);
            // Don't invert the right motor because it is on the other side of the robot
            rightMotor.setPower(gamepad1.left_stick_y);

        }

}
