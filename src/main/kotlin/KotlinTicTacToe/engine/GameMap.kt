package KotlinTicTacToe.engine

class GameMap(val board: MutableList<String>) {
	/*
	 * Board positions
	 *  0 | 1 | 2
	 * ===========
	 *  3 | 4 | 5
	 * ===========
	 *  6 | 7 | 8
	 */
	val displayString: String = """ ${this.board[0]} | ${this.board[1]} | ${this.board[2]}
===========
 ${this.board[3]} | ${this.board[4]} | ${this.board[5]}
===========
 ${this.board[6]} | ${this.board[7]} | ${this.board[8]} """

	fun isOccupied(position: Int): Boolean = this.board[position] != " "

	fun isMapFull(): Boolean {
		var foundEmptyPos: Boolean = false
		for (x in 0..8) {
			if (!this.isOccupied(x)) {
				foundEmptyPos = true
				break
			}
		}
		return !foundEmptyPos
	}

	fun xsWin(): Boolean = this.checkTokenInWinPos("X")

	fun osWin(): Boolean = this.checkTokenInWinPos("O")

	private fun checkTokenInWinPos(token: String): Boolean {
		if (this.board[0] == token && this.board[1] == token && this.board[2] == token)
			return true
		else if (this.board[3] == token && this.board[4] == token && this.board[5] == token)
			return true
		else if (this.board[6] == token && this.board[7] == token && this.board[8] == token)
			return true
		else if (this.board[0] == token && this.board[4] == token && this.board[8] == token)
			return true
		else if (this.board[2] == token && this.board[4] == token && this.board[6] == token)
			return true
		else if (this.board[0] == token && this.board[3] == token && this.board[6] == token)
			return true
		else if (this.board[1] == token && this.board[4] == token && this.board[7] == token)
			return true
		else if (this.board[2] == token && this.board[5] == token && this.board[8] == token)
			return true
		else
			return false
	}
}
