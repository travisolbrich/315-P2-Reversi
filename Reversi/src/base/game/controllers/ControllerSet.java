package base.game.controllers;

import base.game.messages.MessageHandler;
import base.models.Board;
import base.models.Entity;
import base.models.Player;
import base.models.game.Input;

/**
 * Class for holding several Controllers. Used for initializing a BoardGame.
 * @author dereekb
 *
 * @param <P>
 * @param <E>
 * @param <I>
 * @param <B>
 */
public class ControllerSet<P extends Player, E extends Entity, I extends Input<P>, B extends Board<E>> {
	
	private BoardController<B> boardController;

	private InputController<P, I, B> inputController;

	private PlayerController<P, E, B> playerController;

	private TurnController<P, E, I> turnController;

	private MessageHandler messageHandler;

	public ControllerSet(){};
	
	public ControllerSet(BoardController<B> boardController, 
			InputController<P, I, B> inputController, 
			PlayerController<P, E, B> playerController,
			TurnController<P, E, I> turnController,
			MessageHandler messageHandler){
		
		this.boardController = boardController;
		this.inputController = inputController;
		this.playerController = playerController;
		this.turnController = turnController;
		this.messageHandler = messageHandler;
	};
	
	public BoardController<B> getBoardController() {
		return boardController;
	}

	public void setBoardController(BoardController<B> boardController) {
		this.boardController = boardController;
	}

	public InputController<P, I, B> getInputController() {
		return inputController;
	}

	public void setInputController(InputController<P, I, B> inputController) {
		this.inputController = inputController;
	}

	public PlayerController<P, E, B> getPlayerController() {
		return playerController;
	}

	public void setPlayerController(PlayerController<P, E, B> playerController) {
		this.playerController = playerController;
	}

	public TurnController<P, E, I> getTurnController() {
		return turnController;
	}

	public void setTurnController(TurnController<P, E, I> turnController) {
		this.turnController = turnController;
	}

	public MessageHandler getMessageHandler() {
		return messageHandler;
	}

	public void setMessageHandler(MessageHandler messageHandler) {
		this.messageHandler = messageHandler;
	}

}
