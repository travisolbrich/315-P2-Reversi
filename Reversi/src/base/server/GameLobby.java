package base.server;

import java.io.IOException;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

import reversi.server.controllers.exceptions.ExitException;

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
public abstract class GameLobby<C extends RemoteClient<?>> implements Runnable {


	private Thread thread;
	private final ServerLobbyManager<?, ?, ?> parent;
	
	protected boolean isRunning = false;
	private boolean gameInProgress = false;

	protected final Set<C> clients = new HashSet<C>();

	private static final String defaultLobbyName = "Lobby";

	public String lobbyName;

	public GameLobby(ServerLobbyManager<?, ?, ?> parent) {
		this.lobbyName = defaultLobbyName;
		this.parent = parent;
	}

	public GameLobby(ServerLobbyManager<?, ?, ?> parent, String lobbyName) {
		this.lobbyName = lobbyName;
		this.parent = parent;
	}

	@Override
	public void run() {
		this.isRunning = true;

		try {
			while (this.isRunning) {
				this.runLobby();
				this.runGame();
			}

			this.closeLobby();
		} catch (ExitException exit){
			
			//TODO: Tell all the players goodbye, etc.
			
		} catch (IOException e){
			
		} finally {
			if(this.parent != null){
				this.parent.removeLobby(this);
			}
		}
	}

	public abstract void runLobby() throws IOException;

	public abstract void runGame() throws IOException;

	public void startLobbyThread() {
		Thread lobbyThread = this.getThread();
		lobbyThread.start();
	}

	/**
	 * Automatically close client sockets.
	 * @throws IOException
	 */
	public void closeLobby() throws IOException {
		for(C client : this.clients)
		{
			Socket clientSocket = client.getSocket();
			clientSocket.close();
		}
	}

	public Thread getThread() {

		//Lazy Loading
		if (this.thread == null) {
			this.thread = new Thread(this);
			this.thread.setDaemon(true);
		}

		return this.thread;
	}

	public Set<C> getClients() {
		return clients;
	}

	public boolean isGameInProgress() {
		return gameInProgress;
	}

	public void setGameInProgress(boolean gameInProgress) {
		this.gameInProgress = gameInProgress;
	}
}
