package reversi.game.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import reversi.models.ReversiBoard;
import reversi.models.ReversiPlayer;
import reversi.server.display.ReversiAsciiDisplayController;

public class ReversiDisplayController {

	public List<ReversiPlayer> getListeningPlayers(List<ReversiPlayer> players)
	{
		List<ReversiPlayer> observers = new ArrayList<ReversiPlayer>();
		
		for(ReversiPlayer player : players)
		{
			if(player.isHuman()){
				observers.add(player);
			}
		}
		
		return observers;
	}
	
	public void drawBoard(ReversiBoard board, List<ReversiPlayer> observers) throws IOException {
		String boardDisplay = ReversiAsciiDisplayController.drawBoard(board);
		
		for(ReversiPlayer observer : observers)
		{
				PrintWriter writer = observer.getWriter();
				writer.println(boardDisplay);
		}
	}

}
