package reversi.game;

import java.util.List;

import reversi.game.controller.ReversiBoardController;
import reversi.game.controller.ReversiControllerSet;
import reversi.game.controller.ReversiInputController;
import reversi.game.controller.ReversiPlayerController;
import reversi.game.controller.ReversiTurnController;
import reversi.models.ReversiBoard;
import reversi.models.ReversiEntity;
import reversi.models.ReversiPlayer;
import reversi.models.game.ReversiInput;
import base.game.BoardGame;
import base.game.controllers.BoardController;
import base.game.controllers.ControllerSet;
import base.game.controllers.InputController;
import base.game.controllers.PlayerController;
import base.game.controllers.TurnController;
import base.game.messages.DefaultMessageHandler;
import base.game.messages.MessageHandler;

public class ReversiGame extends
		BoardGame<ReversiPlayer, ReversiEntity, ReversiInput, ReversiBoard> {

	public ReversiGame(ControllerSet<ReversiPlayer, ReversiEntity, ReversiInput, ReversiBoard> controllerSet) {
		super(controllerSet);
	}

	/**
	 * Returns a new ReversiGame with no bots that is player vs player.
	 * 
	 * @deprecated Should not use, since it won't work with the Server.
	 * @param players
	 * @param botDifficulty
	 * @return
	 */
	public static ReversiGame pvpGame(List<ReversiPlayer> players) {
		return null;
	}

	/**
	 * @deprecated Should not use, since it won't work with the Server.
	 * @param players
	 * @param botDifficulty
	 * @return
	 */
	public static ReversiGame gameWithBots(List<ReversiPlayer> players,
			Integer difficulty) {

		// TODO: If needed, create a ReversiMessageController class, and add a
		// variable to each of these so that message controller can be accessed
		// per-step.

		ReversiControllerSet set = new ReversiControllerSet();
		
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
		
		ReversiGame game = new ReversiGame(set);	
		return game;
	}

}
