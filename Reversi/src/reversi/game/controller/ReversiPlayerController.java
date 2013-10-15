package reversi.game.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import reversi.models.ReversiBoard;
import reversi.models.ReversiEntity;
import reversi.models.ReversiPlayer;
import reversi.server.display.ReversiAsciiDisplayController;
import base.game.controllers.PlayerController;

public class ReversiPlayerController extends
		PlayerController<ReversiPlayer, ReversiEntity, ReversiBoard> {

	public ReversiPlayerController(List<ReversiPlayer> players) {
		super(players);
	};

	@Override
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

		List<ReversiPlayer> players = this.getPlayers();
		
		for(ReversiPlayer player : players)
		{
			
		}
	}
	
	public ReversiPlayer determineWinner(ReversiBoard board)
	{
		List<ReversiPlayer> players = this.getPlayers();
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

	@Override
	public void drawBoard(ReversiBoard board) throws IOException {
		String boardDisplay = ReversiAsciiDisplayController.drawBoard(board);
		
		List<ReversiPlayer> players = this.getPlayers();
		
		for(ReversiPlayer player : players)
		{
			if(player.isHuman()){
				PrintWriter writer = player.getWriter();
				writer.println(boardDisplay);
			}
		}
	}

}
