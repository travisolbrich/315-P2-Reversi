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
public class ReversiLobby extends GameLobby<ReversiRemoteClient>{

	private ReversiRemoteClient host;
	private final ReversiGameFactory gameFactory = new ReversiGameFactory();
	private final ReversiSettings settings = new ReversiSettings();

	private boolean inProgress;

	public ReversiLobby(ReversiRemoteClient host, ServerLobbyManager<?, ?, ?> manager){
		super(manager);
		this.setHost(host);
		this.getClients().add(host);
	}

	public ReversiLobby(ReversiRemoteClient host, ServerLobbyManager<?, ?, ?> manager, String lobbyName){
		super(manager, lobbyName);
		this.setHost(host);
		this.getClients().add(host);
	}

	@Override
	public void runLobby() throws IOException{

		boolean beginGame = false;
		
		PrintWriter writer = host.getWriter();
		writer.println("Welcome to your new lobby.");

		//Keep alive while clients are still connected.
		while(getClients().size() > 0 && beginGame){

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

		//TODO: Run the new game here!
		//ReversiGame game = this.gameFactory.createNewGame(this.settings);
		//game.playGame();
		this.isRunning = false;
	}
	
	@Override
	public void closeLobby() throws IOException{
		super.closeLobby();	//Call this to automatically close client sockets.
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
