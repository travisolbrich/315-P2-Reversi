package base.game.controllers;

import java.util.List;

import reversi.models.ReversiEntity;
import reversi.models.ReversiPlayer;
import base.models.Board;
import base.models.Entity;
import base.models.Player;
import base.models.game.Input;
import base.models.game.Turn;

public interface TurnController<P extends Player, E extends Entity, I extends Input<P>> {

	public abstract boolean processTurn(Turn<P, I> turn, Board<E> board);

	public abstract boolean undoTurn(List<ReversiPlayer> players, Board<ReversiEntity> board);
	
	public abstract boolean redoTurn(List<ReversiPlayer> players, Board<ReversiEntity> board);
	
}
