package base.game.controllers;

import base.models.Board;
import base.models.Entity;
import base.models.Player;
import base.models.game.Input;
import base.models.game.Turn;

public interface TurnController<P extends Player, E extends Entity, I extends Input<P>> {

	public abstract void processTurn(Turn<P, I> turn, Board<E> board);
	
}
