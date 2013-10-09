package reversi.server.models;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import reversi.game.ReversiGame;
import reversi.server.ReversiGameFactory;
import base.server.GameLobby;
import base.server.ServerLobbyManager;


/**
 * Lobby for Reversi.
 * 
 * Will wait until two players connect, or the first player decides to play against a single player.
 * 
 * @author dereekb
 * 
 */
public class ReversiLobby extends GameLobby{

	private ReversiRemoteClient host;
	private final Set<ReversiRemoteClient> clients = new HashSet<ReversiRemoteClient>();
	private final ReversiGameFactory gameFactory = new ReversiGameFactory();
	private final ReversiSettings settings = new ReversiSettings();

	private boolean inProgress;

	public ReversiLobby(ReversiRemoteClient host, ServerLobbyManager<?, ?, ?> manager){
		super(manager);
		this.setHost(host);
		this.clients.add(host);
	}

	public ReversiLobby(ReversiRemoteClient host, ServerLobbyManager<?, ?, ?> manager, String lobbyName){
		super(manager, lobbyName);
		this.setHost(host);
		this.clients.add(host);
	}

	@Override
	public void runLobby() throws IOException{

		PrintWriter writer = host.getWriter();
		writer.println("Welcome to your new lobby.");

		//Keep alive while clients are still connected.
		while(clients.size() > 0){

			/*
			 * TODO: Run Lobby loop. 
			 * 
			 * This loop is the contained loop that the host sends commands to/from the server.
			 * 
			 * When the host starts the game, create and run a new game.
			 */

			break; //TEMP
		}
	}

	@Override
	public void runGame() throws IOException{

		//Run the new game here!
		ReversiGame game = this.gameFactory.createNewGame(this.settings);
		game.playGame();

	}

	public boolean isInProgress(){
		return inProgress;
	}

	public void setInProgress(boolean inProgress){
		this.inProgress = inProgress;
	}

	public ReversiRemoteClient getHost(){
		return host;
	}

	public void setHost(ReversiRemoteClient host){
		this.host = host;
	}

}
