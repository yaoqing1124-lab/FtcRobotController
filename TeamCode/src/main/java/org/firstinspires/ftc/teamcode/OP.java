package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class OP extends OpMode {
    DcMotor lf, lb, rf, rb;
    DcMotor shooterR, shooterL;
    DcMotor intake;
    double shooterPower, intakePower;
    @Override
    public void init() {
        lf = hardwareMap.get(DcMotor.class,"lf");
        lb = hardwareMap.get(DcMotor.class,"lb");
        rf = hardwareMap.get(DcMotor.class,"rf");
        rb = hardwareMap.get(DcMotor.class,"rb");
        lf.setDirection(DcMotor.Direction.REVERSE);
        lb.setDirection(DcMotor.Direction.REVERSE);
        rf.setDirection(DcMotor.Direction.FORWARD);
        rb.setDirection(DcMotor.Direction.FORWARD);
        shooterR = hardwareMap.get(DcMotor.class,"shooterR");
        shooterL = hardwareMap.get(DcMotor.class,"shooterL");
        shooterR.setDirection(DcMotorSimple.Direction.FORWARD);
        shooterL.setDirection(DcMotorSimple.Direction.REVERSE);
        intake = hardwareMap.get(DcMotor.class,"intake");
    }

    @Override
    public void loop() {
        shooterPower = 0;
        intakePower = 0;
        lf.setPower(gamepad1.left_stick_x + gamepad1.left_stick_y + gamepad1.right_stick_x);
        lb.setPower(gamepad1.left_stick_x - gamepad1.left_stick_y + gamepad1.right_stick_x);
        rf.setPower(gamepad1.left_stick_x - gamepad1.left_stick_y - gamepad1.right_stick_x);
        rb.setPower(gamepad1.left_stick_x + gamepad1.left_stick_y - gamepad1.right_stick_x);
        if(gamepad1.right_bumper){
            shooterPower = -1;
        }
        if(gamepad1.left_bumper){
            shooterPower = 1;
        }
        if(gamepad1.left_trigger > 0.5){
            intakePower = 1;
        }
        if(gamepad1.right_trigger > 0.5){
            intakePower = -1;
        }
        shooterR.setPower(shooterPower);
        shooterL.setPower(shooterPower);
        intake.setPower(intakePower);
    }
}
