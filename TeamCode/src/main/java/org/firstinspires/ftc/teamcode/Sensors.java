package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@TeleOp(name="sensor")
public class Sensors extends OpMode {

    DcMotor left;
    DcMotor right;


    @Override
    public void init()
    {
        left=hardwareMap.dcMotor.get("left");
        right=hardwareMap.dcMotor.get("right");
    }

    @Override
    public void loop()
    {
        Telemetry.Item leftEncoderTicks = telemetry.addData("left encoder ticks", left.getCurrentPosition());
        Telemetry.Item rightEndcoderTicks = telemetry.addData("right encoder ticks", right.getCurrentPosition());

    }
}
