package reversi.game.controller;

import java.util.ArrayList;
import java.util.List;

import reversi.models.ReversiBoard;
import reversi.models.ReversiPlayer;

public class ReversiPlayerController {

	private final List<ReversiPlayer> players;

	public ReversiPlayerController() {
		this.players = new ArrayList<ReversiPlayer>();
	};

	public ReversiPlayerController(List<ReversiPlayer> players) {
		this.players = players;
	};

	public void updateScore(ReversiBoard board) {
		/*
		 * TODO Update the score.
		 * 
		 * Since this is a player controller, it has access to all the players
		 * who have a list of tokens they own.
		 * 
		 * Update the score using those token counts.
		 * 
		 * Score will be a local variable, or linked to the players.
		 */

		/*
		List<ReversiPlayer> players = this.getPlayers();
		
		for(ReversiPlayer player : players)
		{
		}
		*/
	}
	
	public ReversiPlayer determineWinner(ReversiBoard board)
	{
		List<ReversiPlayer> players = this.getAllPlayers();
		ReversiPlayer winner = null;
		Integer winnerPiecesCount = 0;
		
		for(ReversiPlayer player : players)
		{
			Integer piecesCount = player.getGamePieces().size();
			if(piecesCount > winnerPiecesCount)
			{
				winner = player;
				winnerPiecesCount = piecesCount;
			}
		}
		
		return winner;
	}

	public List<ReversiPlayer> getAllPlayers() {
		return players;
	}

	public List<ReversiPlayer> getPlaying() {
		
		List<ReversiPlayer> players = new ArrayList<ReversiPlayer>();

		for(ReversiPlayer player : this.players)
		{
			if(player.isPlaying())
			{
				players.add(player);
			}
		}
		
		return players;
	}

	public List<ReversiPlayer> getObservers() {
		
		List<ReversiPlayer> observers = new ArrayList<ReversiPlayer>();

		for(ReversiPlayer player : this.players)
		{
			if(player.isObserver())
			{
				observers.add(player);
			}
		}
		
		return observers;
	}
}
