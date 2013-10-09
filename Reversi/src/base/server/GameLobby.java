package base.server;

import java.io.IOException;


/**
 * Basic game lobby that waits for several players.
 * 
 * Once the lobby is full, and all settings are set, the game begins.
 * 
 * The lobby will run in it's own thread.
 * 
 * @author dereekb
 * 
 */
public abstract class GameLobby implements Runnable{

	private Thread thread;
	protected boolean isRunning = false;
	private final ServerLobbyManager<?, ?, ?> parent;

	private static final String defaultLobbyName = "Lobby";

	public String lobbyName;

	public GameLobby(ServerLobbyManager<?, ?, ?> parent){
		this.lobbyName = defaultLobbyName;
		this.parent = parent;
	}

	public GameLobby(ServerLobbyManager<?, ?, ?> parent, String lobbyName){
		this.lobbyName = lobbyName;
		this.parent = parent;
	}

	@Override
	public void run(){
		while(this.isRunning){
			try{
				this.runLobby();
				this.runGame();
			}
			catch(IOException e){

			}
		}

		//Remove the lobby from the parent's set.
		this.parent.removeLobby(this);
	}

	public abstract void runLobby() throws IOException;

	public abstract void runGame() throws IOException;

	public Thread getThread(){

		if(this.thread == null){
			this.thread = new Thread(this);

			//Don't want a game to hold up the server if the server's thread exits.
			this.thread.setDaemon(true);
		}

		return this.thread;
	}

	public void startLobbyThread(){
		this.thread.start();
	}
}
