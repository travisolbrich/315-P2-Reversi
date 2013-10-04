package base.models.game;

import base.models.Player;

/**
 * Base class for keeping track of a player's input.
 * 
 * @author dereekb
 * 
 */
public abstract class Input<P extends Player> {

	private final P player;

	public Input(P player) {
		this.player = player;
	}

	public P getPlayer() {
		return player;
	}

}
