package base.game.controllers;

import base.models.Board;

/**
 * Class responsible for resetting a game board.
 * @author dereekb
 *
 */
@Deprecated
public interface BoardController<B extends Board<?>>{

	public B generateNewBoard();
	
}
