package base.game;

import base.game.controllers.BoardController;
import base.game.controllers.InputController;
import base.game.controllers.PlayerController;
import base.game.controllers.TurnController;
import base.models.Board;
import base.models.Entity;
import base.models.Player;
import base.models.game.Input;

/**
 * Runs a Board Game.
 * 
 * @author dereekb
 */
public class BoardGame<P extends Player, E extends Entity, I extends Input<P>, B extends Board<E>> {

	private final BoardController<B> boardController;
	private final InputController<P, I> inputController;
	private final PlayerController<P, E, B> playerController;
	private final TurnController<P, E, I> turnController;

	public BoardGame(BoardController<B> boardController,
			InputController<P, I> inputController,
			PlayerController<P, E, B> playerController,
			TurnController<P, E, I> turnController) {

		this.boardController = boardController;
		this.inputController = inputController;
		this.playerController = playerController;
		this.turnController = turnController;
	};

	public Boolean playGame() {
		Boolean success = true;

		B gameBoard = boardController.generateNewBoard();

		boolean hasWinner = false;

		while (hasWinner == false) {
			/*
			 * TODO: Run game loop.
			 * 
			 * This loop is responsible for only running the game.
			 * 
			 * Once the game ends, the loop exits.
			 * 
			 * If the players want to play another round, then a different class
			 * higher up the stack can handle that.
			 */
		}

		return success;
	}
}
