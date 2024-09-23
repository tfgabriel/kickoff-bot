package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.hardware.DcMotorSimple
import org.firstinspires.ftc.teamcode.electronics.open
import org.firstinspires.ftc.teamcode.inits.hardwaremap


interface Command {
    fun run(): Boolean
}

class InstantCommand(val lambdaCommand: LambdaCommand): Command {
    override fun run(): Boolean {
        lambdaCommand.run()
        return true
    }

    fun interface LambdaCommand{
        fun run()
    }
}

class SequentialCommand(vararg commands: Command): Command {
    var commandList = commands.asList()

    override fun run(): Boolean {
        if(commandList.isEmpty()) return true
        if(commandList.first().run()) {
            commandList = commandList.drop(1)
            run()
        }
        return false
    }

}

class RunUntilCommand(val runnableCommand: Command, val untilCommand: Command) : Command {
    override fun run(): Boolean {
        runnableCommand.run()
        return untilCommand.run()
    }
}

class WaitUntilCommand(val booleanFunction: BooleanFunction) : Command {
    override fun run(): Boolean {
        return booleanFunction.run()
    }

    fun interface BooleanFunction {
        fun run(): Boolean
    }
}

class SleepCommand(val deltaTime: Double): Command {
    var startTime: Double = -1.0

    override fun run(): Boolean {
        //start waiting from the first run
        if(startTime == -1.0){
            startTime = System.nanoTime() / 1e9
        }
        return startTime + deltaTime <= System.nanoTime() / 1e9
    }
}
