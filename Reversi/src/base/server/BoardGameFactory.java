package base.server;

import base.game.BoardGame;
import base.models.Board;
import base.models.Entity;
import base.models.Player;
import base.models.game.Input;

/**
 * Factory for creating new board games with a given set of settings.
 * 
 * @author dereekb
 * 
 */
public interface BoardGameFactory<P extends Player, S extends GameSettings<P>, G extends BoardGame<?, ?, ?, ?>> {

	public G createNewGame(S settings);
	
}
