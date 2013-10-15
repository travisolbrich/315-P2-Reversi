package base.game;

import java.io.IOException;

import base.game.controllers.ControllerSet;
import base.models.Board;
import base.models.Entity;
import base.models.Player;
import base.models.game.Input;

/**
 * Runs a Board Game.
 * 
 * @author dereekb
 */
@Deprecated
public abstract class BoardGame<P extends Player, E extends Entity, I extends Input<P>, B extends Board<E>> {

	protected final ControllerSet<P, E, I, B> controllerSet;

	public BoardGame(ControllerSet<P, E, I, B> controllerSet) {
		this.controllerSet = controllerSet;
	};
	
	public abstract Boolean playGame() throws IOException;
}
