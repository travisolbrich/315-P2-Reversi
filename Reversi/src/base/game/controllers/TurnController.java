package base.game.controllers;

import base.models.Board;
import base.models.Entity;
import base.models.Player;
import base.models.game.Input;
import base.models.game.Turn;

public interface TurnController<P extends Player, E extends Entity, I extends Input<P>> {

	public abstract boolean processTurn(Turn<P, I> turn, Board<E> board);
	
	public abstract boolean undoTurn(Turn<P, I> turn, Board<E> board);
	
}
