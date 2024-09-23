package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.hardware.DcMotorSimple
import org.firstinspires.ftc.teamcode.inits.hardwaremap

class Drivetrain{
    //saracu sasiu are si motoarele de brat si gheara pe el cer iertare maria
    val leftfront = hardwaremap.dcMotor.get("LF")
    val leftback = hardwaremap.dcMotor.get("LB")
    val rightfront = hardwaremap.dcMotor.get("RF")
    val rightback = hardwaremap.dcMotor.get("RB")

    val arm = hardwaremap.dcMotor.get("ARM")
    val leftroller = hardwaremap.servo.get("CLAW")
    val slides = hardwaremap.dcMotor.get("SLIDES")

    fun init(){
        rightfront.direction = DcMotorSimple.Direction.REVERSE
        rightback.direction = DcMotorSimple.Direction.REVERSE

    }

}