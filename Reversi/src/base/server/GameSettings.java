package base.server;

import java.util.ArrayList;
import java.util.List;

import base.models.Player;

/**
 * Model containing settings for a game. 
 * 
 * Includes the remote clients who will be playing.
 * 
 * @author dereekb
 * 
 */
@Deprecated
public abstract class GameSettings<P extends Player> {

	private List<P> players = new ArrayList<P>();

	public GameSettings(){};
		
	public List<P> getPlayers() {
		return players;
	}

	public void setPlayers(List<P> players) {
		this.players = players;
	}
	
}
