package base.game.controllers;

import java.util.List;

import base.models.Board;
import base.models.Entity;
import base.models.Player;
import base.models.game.Input;
import base.models.game.Turn;

@Deprecated
public interface TurnController<P extends Player, E extends Entity, I extends Input<P>> {

	public abstract boolean processTurn(Turn<P, I> turn, Board<E> board);

	public abstract boolean undoTurn(List<P> players, Board<E> board);
	
	public abstract boolean redoTurn(List<P> players, Board<E> board);

	public abstract boolean playerCanMakePlay(P player, Board<E> board);
}
