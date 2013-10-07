package reversi.server;

import reversi.game.ReversiGame;
import reversi.models.ReversiPlayer;
import reversi.server.models.ReversiSettings;
import base.server.BoardGameFactory;

public class ReversiGameFactory implements BoardGameFactory<ReversiPlayer, ReversiSettings, ReversiGame> {

	@Override
	public ReversiGame createNewGame(ReversiSettings settings) {
		
		ReversiGame newGame = null;
		
		/*
		 * TODO Create a new ReversiGame with the given settings.
		 */
		
		return newGame;
	}

}
