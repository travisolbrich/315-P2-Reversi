package reversi.server;

import java.io.IOException;

import reversi.models.ReversiPlayer;
import reversi.server.models.ReversiLobby;
import reversi.server.models.ReversiRemoteClient;
import base.server.ServerLobbyManager;


public class ReversiLobbyManager extends ServerLobbyManager<ReversiLobby, ReversiPlayer, ReversiRemoteClient>{

	@Override
	protected ReversiLobby createNewLobby(ReversiRemoteClient client) throws IOException{
		ReversiLobby lobby = new ReversiLobby(client, this);
		return lobby;
	}

}
