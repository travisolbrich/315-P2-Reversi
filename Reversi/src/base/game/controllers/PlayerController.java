package base.game.controllers;

import java.io.IOException;
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

	public abstract void drawBoard(B board) throws IOException;
	
	public abstract void drawFinalScore(B board);
	
	public List<P> getPlayingPlayers() {
		List<P> playing = new ArrayList<P>();
		
		for(P player : this.players)
		{
			if(player.isInGame()){
				playing.add(player);
			}
		}
		
		return playing;
	}

	public List<P> getPlayers() {
		return players;
	}
}
