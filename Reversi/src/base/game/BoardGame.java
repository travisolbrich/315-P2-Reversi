package base.game;

import java.util.List;

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
import base.models.game.Turn;

/**
 * Runs a Board Game.
 * 
 * @author dereekb
 */
public class BoardGame<P extends Player, E extends Entity, I extends Input<P>, B extends Board<E>> {

	protected final ControllerSet<P, E, I, B> controllerSet;

	public BoardGame(ControllerSet<P, E, I, B> controllerSet) {
		this.controllerSet = controllerSet;
	};
	
	public Boolean playGame() {
		Boolean success = true;

		MessageHandler messageHandler = controllerSet.getMessageHandler();
		BoardController<B> boardController = controllerSet.getBoardController();
		InputController<P, I, B> inputController = controllerSet.getInputController();
		PlayerController<P, E, B> playerController = controllerSet.getPlayerController();
		TurnController<P, E, I> turnController = controllerSet.getTurnController();
		
		//Write something to show the players initialization is occurring.
		messageHandler.writeMessage("Initialize", "Creating new board.");
		B board = boardController.generateNewBoard();
		List<P> players = playerController.getPlayers();
		
		boolean hasWinner = false;
		Integer currentTurn = 0;

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
			
			playerController.updateScore(board);
			playerController.drawBoard(board);
			
			List<I> input = inputController.getInputForPlayers(players, board);
			Turn<P, I> turn = new Turn<P, I>((currentTurn+=1));
			turn.addInput(input);
			
			turnController.processTurn(turn, board);
		}
		
		playerController.drawFinalScore(board);

		return success;
	}
}
