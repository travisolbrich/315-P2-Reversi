package reversi.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import reversi.server.models.ReversiLobby;
import reversi.server.models.ReversiRemoteClient;
import base.server.GameServer;
import base.server.GameServerDelegate;


public class ReversiServer extends GameServer{

	private final ReversiLobbyManager lobbyManager = new ReversiLobbyManager();

	public ReversiServer(GameServerDelegate delegate, Integer serverPort){
		super(delegate, serverPort);
	}

	@Override
	public void clientConnected(Socket socket) throws IOException{

		/*
		 * If we want to implement PvP "just because", 
		 * check the client's connection info/request to see if they want to join a lobby with a name.
		 */

		ReversiRemoteClient client = new ReversiRemoteClient(socket);
		//showConnectionMessage(client);
		
		ReversiLobby lobby = lobbyManager.createNewLobby(client);
		lobby.startLobbyThread();
	}

	private final static String connectionMessage = "Hello!";
	
	public void showConnectionMessage(ReversiRemoteClient client) throws IOException
	{
		PrintWriter writer = client.getWriter();
		writer.println(connectionMessage);
	}
	
}
