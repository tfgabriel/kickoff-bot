package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcore.hardware.DcMotorSimple
import com.qualcomm.robotcore.hardware.HardwareMap
import org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion
import org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap
import org.firstinspires.ftc.teamcode.inits.drivetrain


object inits{
    lateinit var hardwaremap: HardwareMap
    lateinit var lom: LinearOpMode
    lateinit var drivetrain: Drivetrain

    fun initop(lomreal: LinearOpMode){
        lom = lomreal
        hardwaremap = lom.hardwareMap
        drivetrain = Drivetrain()
        drivetrain.init()
    }
}

@TeleOp
class teleops: LinearOpMode() {

    override fun runOpMode() {



        var runningcommand: Command? = null
        var one: Boolean = false
        var two: Boolean = false
        var three: Boolean = false
        var four: Boolean = false
        var five: Boolean = false
        var six: Boolean = false
        inits.initop(this)
        waitForStart()

        while (!isStopRequested) {
            val forward = -gamepad1.left_stick_y.toDouble() //miscare fata spate
            val strafe = gamepad1.left_stick_x.toDouble() * 1.1 //miscare stanga dreapta (strafe)
            val rotation = gamepad1.right_stick_x.toDouble() //miscare de rotatie

            val LFpower = forward + strafe + rotation
            val LBpower = forward - strafe + rotation
            val RFpower = forward - strafe - rotation
            val RBpower = forward + strafe - rotation

            drivetrain.leftfront.power = LFpower
            drivetrain.leftback.power = LBpower
            drivetrain.rightfront.power = RFpower
            drivetrain.rightback.power = RBpower
            
            if(gamepad1.a && !one){
                runningcommand = commands.goUp()
            }
            one = gamepad1.a


            if(gamepad1.b && !two){
                runningcommand = commands.goDown()
            }
            two = gamepad1.b


            if(gamepad1.x && !three){
                runningcommand = commands.grab()
            }
            three = gamepad2.x


            if(gamepad1.y && !four){
                runningcommand = commands.drop()
            }
            four = gamepad1.y

            if(gamepad1.dpad_up && !five){
                runningcommand = commands.slidesup()
            }
            five = gamepad1.dpad_up

            if(gamepad1.dpad_down && !six){
                runningcommand = commands.slidesdown()
            }
            six = gamepad1.dpad_up
            
            if (runningcommand != null) {
                if (runningcommand.run()) {
                    runningcommand = null
                }
            }
        }
    }
}

@TeleOp
class tp: LinearOpMode(){
    override fun runOpMode() {
        waitForStart()
        while (!isStopRequested){
            telemetry.addLine("BRRRRRRRRRRRRRRR")
            telemetry.update()
        }
    }

}

