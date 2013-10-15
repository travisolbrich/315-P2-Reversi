package base.server;

import base.game.BoardGame;
import base.models.Player;

/**
 * Factory for creating new board games with a given set of settings.
 * 
 * @author dereekb
 * 
 */
@Deprecated
public interface BoardGameFactory<P extends Player, S extends GameSettings<P>, G extends BoardGame<?, ?, ?, ?>> {

	public G createNewGame(S settings);
	
}
