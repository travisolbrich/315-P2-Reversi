package base.game.controllers;

import java.util.ArrayList;
import java.util.List;

import base.models.Board;
import base.models.Entity;
import base.models.Player;

public abstract class PlayerController<P extends Player, E extends Entity, B extends Board<E>> {

	private final List<P> players;

	public PlayerController() {
		this.players = new ArrayList<P>();
	};

	public PlayerController(List<P> players) {
		this.players = players;
	};

	public abstract void updateScore(B board);

	public abstract void drawBoard(B board);
	
	public abstract void drawFinalScore(B board);

	public List<P> getPlayers() {
		return players;
	}
}
