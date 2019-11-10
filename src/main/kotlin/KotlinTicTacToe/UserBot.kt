package KotlinTicTacToe

import KotlinTicTacToe.engine.GameMap
import KotlinTicTacToe.engine.IBot

class UserBot: IBot() {
	override fun periodic(gameMap: GameMap, myToken: String): Int {
		return 0
	}
}
