package reversi.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import base.server.GameServer;

public class ReversiServer extends GameServer{

	private final ReversiGameFactory gameFactory = new ReversiGameFactory();
	private final ReversiLobbyFactory lobbyFactory = new ReversiLobbyFactory();
	
	public ReversiServer(Integer serverPort) {
		super(serverPort);
	}
	
	@Override
	public void clientConnected(Socket socket) throws IOException {

		/*
		 * TODO: When a client connects, this is where it is handled. 
		 * 
		 * If we want to implement PvP, 
		 * give the user the ability to join a lobby that currently exists.
		 */
		System.out.println("Client connected on port " + socket.getRemoteSocketAddress() + ":" + socket.getPort() + ". ");
	}

}
