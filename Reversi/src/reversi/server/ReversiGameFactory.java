package reversi.server;

import reversi.game.ReversiGame;
import reversi.game.controller.ReversiControllerSet;
import reversi.models.ReversiBoard;
import reversi.models.ReversiPiece;
import reversi.models.ReversiPlayer;
import reversi.models.game.ReversiInput;
import reversi.server.models.ReversiSettings;
import base.game.controllers.ControllerSet;
import base.server.BoardGameFactory;

public class ReversiGameFactory implements
		BoardGameFactory<ReversiPlayer, ReversiSettings, ReversiGame> {

	@Override
	public ReversiGame createNewGame(ReversiSettings settings) {

		ReversiControllerSet controllerSet = ReversiControllerSet
				.controllerSetWithSettings(settings);
		
		ReversiGame newGame = new ReversiGame(controllerSet);
		return newGame;
	}

}
