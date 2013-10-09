package reversi.server.models;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import reversi.game.ReversiGame;
import reversi.server.ReversiGameFactory;
import reversi.server.ReversiServerResponse;
import reversi.server.commands.ReversiCommand;
import reversi.server.commands.ReversiCommandReader;
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
public class ReversiLobby extends GameLobby<ReversiRemoteClient> implements ReversiCommandReader{

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
		Scanner scanner = host.getInputScanner();
		writer.println("Welcome to your new lobby.");

		//Keep alive while clients are still connected.
		while(getClients().size() > 0 && beginGame){

			String input = scanner.nextLine();
			ReversiCommand command = this.readCommand(input);
			
			if(command != null)
			{
				/*
				 * TODO: Update to process commands.
				 */
				ReversiServerResponse.sendOk(host);
				
				//Temp
				beginGame = true;				
				
			} else {
				ReversiServerResponse.sendIllegal(host);
			}
		}
	
		//TODO: this.settings.setPlayers(players);
	}

	@Override
	public ReversiCommand readCommand(String input) {
		// TODO Read the host's input and return the command for that input.
		return null;
	}

	@Override
	public void runGame() throws IOException{

		//TODO: Run the new game here!
		//ReversiGame game = this.gameFactory.createNewGame(this.settings);
		//game.playGame();
		
		
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
