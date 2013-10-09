package reversi.server;

import java.io.IOException;
import java.net.Socket;
import reversi.server.models.ReversiLobby;
import reversi.server.models.ReversiRemoteClient;
import base.server.GameServer;


public class ReversiServer extends GameServer{

	private final ReversiLobbyManager lobbyManager = new ReversiLobbyManager();

	public ReversiServer(Integer serverPort){
		super(serverPort);
	}

	@Override
	public void clientConnected(Socket socket) throws IOException{

		/*
		 * If we want to implement PvP "just because", 
		 * check the client's connection info/request to see if they want to join a lobby with a name.
		 */

		ReversiRemoteClient client = new ReversiRemoteClient(socket);
		ReversiLobby lobby = lobbyManager.createNewLobby(client);
		lobby.startLobbyThread();
	}

}
