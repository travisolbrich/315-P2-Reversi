package base.server;

import base.models.Player;

/**
 * Keeps track of a connected client.
 * @author dereekb
 *
 */
public class RemoteClient<P extends Player> {

	/**
	 * Avatar for this client.
	 */
	private P player;

	public RemoteClient(){};

	public P getPlayer() {
		return player;
	}

	public void setPlayer(P player) {
		this.player = player;
	}

}
