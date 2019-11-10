package KotlinTicTacToe.engine

import KotlinTicTacToe.UserBot

class Engine(val userBot: IBot, val userFirst: Boolean, val timeBetweenLoops: Int = 0) {
	var gameMap: GameMap = GameMap(mutableListOf(" ", " ", " ", " ", " ", " ", " ", " ", " "))
	
	val engineBot: IBot = RandomBot()

	fun run() {
		loop()
	}

	private fun loop() {
		gameLoop@while (true) {
			if (userFirst) {
				//* Take user bot move
				val userMove: Int = this.userBot.periodic(gameMap, "X")
				checkMove(userMove)
				updateGameMap(userMove, "X")
				if (this.gameFinished())
					break@gameLoop
				
				//* Take engine bot move
				val engineMove: Int = this.engineBot.periodic(gameMap, "O")
				checkMove(engineMove)
				updateGameMap(engineMove, "O")
				if (this.gameFinished())
					break@gameLoop
			} else {
				//* Take engine bot move
				val engineMove: Int = this.engineBot.periodic(gameMap, "X")
				checkMove(engineMove)
				updateGameMap(engineMove, "X")
				if (this.gameFinished())
					break@gameLoop
				
				//* Take user bot move
				val userMove: Int = this.userBot.periodic(gameMap, "O")
				checkMove(userMove)
				updateGameMap(userMove, "O")
				if (this.gameFinished())
					break@gameLoop
			}
			display()
			Thread.sleep((timeBetweenLoops * 1000).toLong())
		}
		display()
		displayWinner()
	}

	private fun gameFinished(): Boolean = (this.gameMap.isMapFull() || this.gameMap.xsWin() || this.gameMap.osWin())

	private fun updateGameMap(movePosition: Int, token: String) {
		this.gameMap.board.set(movePosition, token)
		this.gameMap = GameMap(this.gameMap.board)
	}

	private fun checkMove(position: Int) {
		if (this.gameMap.isOccupied(position))
			throw PositionOccupiedException("The position ${position} is already occupied.")
	}

	private fun display() {
		println("")
		println(this.gameMap.displayString)
	}

	private fun displayWinner() {
		if (this.gameMap.xsWin())
			println("X's win!")
		else if (this.gameMap.osWin())
			println("O's win!")
		else if (this.gameMap.isMapFull())
			println("No one won.")
		else
			println("No end conditions were met, somehow.")
	}
}

class PositionOccupiedException(message: String): Exception(message)
