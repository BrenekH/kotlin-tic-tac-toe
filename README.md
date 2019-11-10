# Kotlin Tic-Tac-Toe
A Tic-Tac-Toe Engine written in Kotlin for developers to create Tic-Tac-Toe bots.

## Developing a Bot

Every bot is a subclass of `KotlinTicTacToe.engine.IBot` and must override the `periodic(gameMap: GameMap, myToken: String): Int` function.

The periodic function must return an Int between 0 and 8 that isn't already used in the gameMap.

The game board indices work as follows:

 0 | 1 | 2
 
=====

 3 | 4 | 5

=====

 6 | 7 | 8


