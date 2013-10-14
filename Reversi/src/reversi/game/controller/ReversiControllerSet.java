package reversi.game.controller;

import base.game.controllers.ControllerSet;
import base.game.messages.DefaultMessageHandler;
import reversi.models.ReversiBoard;
import reversi.models.ReversiEntity;
import reversi.models.ReversiPlayer;
import reversi.models.game.ReversiInput;
import reversi.server.models.ReversiSettings;

public class ReversiControllerSet extends ControllerSet<ReversiPlayer, ReversiEntity, ReversiInput, ReversiBoard>
{
	public ReversiControllerSet(){
		super();
	}
	
	public static ReversiControllerSet controllerSetWithSettings(ReversiSettings settings)
	{
		ReversiControllerSet set = new ReversiControllerSet();
		Integer difficulty = settings.getDifficulty();
		
		ReversiBoardController boardController = new ReversiBoardController();
		set.setBoardController(boardController);
		
		ReversiInputController inputController = ReversiInputController
				.defaultServerController(difficulty);
		set.setInputController(inputController);

		ReversiPlayerController playerController = new ReversiPlayerController();
		set.setPlayerController(playerController);
		
		ReversiTurnController turnController = new ReversiTurnController();
		set.setTurnController(turnController);

		DefaultMessageHandler messageHandler = new DefaultMessageHandler();
		set.setMessageHandler(messageHandler);		
		
		return set;
	}
	
}
