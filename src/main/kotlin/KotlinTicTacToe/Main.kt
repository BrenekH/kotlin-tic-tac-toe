package KotlinTicTacToe

import KotlinTicTacToe.engine.Engine
import KotlinTicTacToe.engine.RandomBot

fun main(args: Array<String>) {
    Engine(RandomBot(), true).run()
}
