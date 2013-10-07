package base.game;

import base.game.controllers.BoardController;
import base.game.controllers.ControllerSet;
import base.game.controllers.InputController;
import base.game.controllers.PlayerController;
import base.game.controllers.TurnController;
import base.game.messages.DefaultMessageHandler;
import base.game.messages.MessageHandler;
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

	private final ControllerSet<P, E, I, B> controllerSet;

	public BoardGame(ControllerSet<P, E, I, B> controllerSet) {
		this.controllerSet = controllerSet;
	};
	
	public Boolean playGame() {
		Boolean success = true;

		MessageHandler messageHandler = controllerSet.getMessageHandler();
		BoardController<B> boardController = controllerSet.getBoardController();
		
		//Write something to show the players initialization is occurring.
		messageHandler.writeMessage("Initialize", "Creating new board.");
		B gameBoard = boardController.generateNewBoard();
		
		boolean hasWinner = false;

		messageHandler.writeMessage("Start", "Beginning game.");
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
