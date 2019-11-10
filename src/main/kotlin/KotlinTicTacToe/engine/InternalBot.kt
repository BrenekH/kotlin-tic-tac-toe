package KotlinTicTacToe.engine

class RandomBot: IBot() {
	override fun periodic(gameMap: GameMap, myToken: String): Int {
		var notFound = true;
		while (notFound) {
			var randomPos: Int = (0..8).random()
			if (!gameMap.isOccupied(randomPos))
				return randomPos
		}
		return 0
	}
}

abstract class IBot {
	abstract fun periodic(gameMap: GameMap, myToken: String): Int
}
