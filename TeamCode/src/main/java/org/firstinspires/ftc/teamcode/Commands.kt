package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.hardware.DcMotorSimple
import com.qualcomm.robotcore.hardware.HardwareMap
import org.firstinspires.ftc.teamcode.inits.drivetrain


object commands {
    fun goDown(): Command{
        return SequentialCommand(
            InstantCommand  { drivetrain.arm.power = -0.9 },
            SleepCommand(0.5),
            InstantCommand { drivetrain.arm.power = 0.05 }
        )
    }

    fun goUp(): Command{
        return SequentialCommand(
            InstantCommand  { drivetrain.arm.power = 0.9 },
            SleepCommand(0.8),
            InstantCommand { drivetrain.arm.power = 0.05 }
        )
    }

    fun grab(): Command{
        return SequentialCommand(
            InstantCommand  { drivetrain.leftroller.position = 0.0 },
        )
    }

    fun drop(): Command{
        return SequentialCommand(
            InstantCommand  { drivetrain.leftroller.position = 0.5 },
        )
    }
    fun slidesup(): Command{
        return SequentialCommand(
            InstantCommand  { drivetrain.slides.power = 0.3},
            SleepCommand(0.2),
            InstantCommand { drivetrain.slides.power = 0.0},
        )
    }

    fun slidesdown(): Command{
        return SequentialCommand(
            InstantCommand  { drivetrain.slides.power = 0.3},
            SleepCommand(0.2),
            InstantCommand { drivetrain.slides.power = 0.0},
        )
    }
}