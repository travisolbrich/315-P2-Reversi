package reversi.server;

import reversi.game.ReversiGame;
import reversi.game.controller.ReversiControllerSet;
import reversi.server.models.ReversiSettings;

public class ReversiGameFactory {

	public ReversiGame createNewGame(ReversiSettings settings) {

		ReversiControllerSet controllerSet = ReversiControllerSet
				.controllerSetWithSettings(settings);
		
		ReversiGame newGame = new ReversiGame(controllerSet);
		return newGame;
	}

}
