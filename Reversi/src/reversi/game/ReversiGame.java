package reversi.game;

import java.util.List;

import reversi.game.controller.ReversiBoardController;
import reversi.game.controller.ReversiInputController;
import reversi.game.controller.ReversiPlayerController;
import reversi.game.controller.ReversiTurnController;
import reversi.models.ReversiBoard;
import reversi.models.ReversiPiece;
import reversi.models.ReversiPlayer;
import reversi.models.game.ReversiInput;
import base.game.BoardGame;
import base.game.controllers.BoardController;
import base.game.controllers.InputController;
import base.game.controllers.PlayerController;
import base.game.controllers.TurnController;

public class ReversiGame extends
		BoardGame<ReversiPlayer, ReversiPiece, ReversiInput, ReversiBoard> {

	public ReversiGame(
			BoardController<ReversiBoard> boardController,
			InputController<ReversiPlayer, ReversiInput> inputController,
			PlayerController<ReversiPlayer, ReversiPiece, ReversiBoard> playerController,
			TurnController<ReversiPlayer, ReversiPiece, ReversiInput> turnController) {
		super(boardController, inputController, playerController,
				turnController);

	}
	
	
	//Defaults

	/**
	 * Returns a new ReversiGame with no bots that is player vs player.
	 * 
	 * @param players
	 * @param botDifficulty
	 * @return
	 */
	public static ReversiGame pvpGame(List<ReversiPlayer> players) {
		return null;
	}

	/**
	 * 
	 * @param players
	 * @param botDifficulty
	 * @return
	 */
	public static ReversiGame gameWithBots(List<ReversiPlayer> players,
			Integer difficulty) {
		BoardController<ReversiBoard> boardController = new ReversiBoardController();

		ReversiInputController inputController = ReversiInputController
				.defaultConsoleController(difficulty);

		ReversiPlayerController playerController = new ReversiPlayerController();
		ReversiTurnController turnController = new ReversiTurnController();
		
		ReversiGame game = new ReversiGame(boardController, inputController,
				playerController, turnController);
		return game;
	}

}
