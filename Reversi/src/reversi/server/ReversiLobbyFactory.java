package reversi.server;

import reversi.game.ReversiGame;
import reversi.models.ReversiPlayer;
import reversi.server.models.ReversiLobby;
import reversi.server.models.ReversiSettings;
import base.server.BoardGameFactory;
import base.server.RemoteClient;
import base.server.ServerLobbyFactory;

public class ReversiLobbyFactory
		implements
		ServerLobbyFactory<ReversiLobby, ReversiPlayer, ReversiSettings, ReversiGame> {

	@Override
	public ReversiLobby newLobby(
			RemoteClient<ReversiPlayer> client,
			BoardGameFactory<ReversiPlayer, ReversiSettings, ReversiGame> factory) {

		/*
		 *  TODO Creates a new lobby with the client as the lobby head.
		 *  
		 *  Forward the BoardGameFactory to the lobby so it can directly create and launch the game.
		 */
		
		return null;
	}

}
