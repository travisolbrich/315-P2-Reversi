package base.server;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import base.models.Player;

public abstract class ServerLobbyManager<L extends GameLobby<?>, P extends Player, C extends RemoteClient<P>> {

	private final Set<L> lobbies = new HashSet<L>();

	public L newLobby(C client) throws IOException{
		L newLobby = this.createNewLobby(client);
		this.lobbies.add(newLobby);
		return newLobby;
	}

	/**
	 * The lobby will be removed from the lobbies set, and then called to stop at the end of the
	 * next game.
	 * 
	 * Note: Lobbies all run in Daemon threads, so they will not prevent the server from shutting
	 * down.
	 * 
	 * @param gameLobby
	 */
	public void removeLobby(GameLobby<?> gameLobby){

		boolean removed = lobbies.remove(gameLobby);

		if(removed == false){
			//Not one of our lobbies?
		}else{
			gameLobby.isRunning = false;
		}
	}

	protected abstract L createNewLobby(C client) throws IOException;

	public Set<L> getLobbies(){
		return lobbies;
	}
}
