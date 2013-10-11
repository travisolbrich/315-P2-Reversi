package reversi.models;

import java.util.Map;

import base.models.Board;
import base.models.BoardPiece;
import base.models.Position;

public class ReversiBoard extends Board<ReversiPiece>{

	//TODO: Implement board
	
	//TODO: Create function that shows the board in ASCII
	
	private static final String[] columnAlpha = {"a","b","c","d","e","f","g","h"};
	
	public String DrawBoard(ReversiBoard board)
	{
		Map<Position, BoardPiece<ReversiPiece>> boardPieces = board.getBoardElements();
		
		StringBuilder builder = new StringBuilder();

		for (int c = 0; c < 8; c++) {

			String currentColumn = columnAlpha[c];
			
			builder.append(c);

			for (int r = 0; r < 8; r++) {
				
				builder.append("|");

				Integer currentRow = r;

				Position position = new Position(currentColumn, currentRow);

				BoardPiece<ReversiPiece> boardPiece = boardPieces.get(position);
				
				String representation = this.DrawElement(boardPiece);
				
				builder.append(representation);
			}

		}
		return board;

	}
		
	public String DrawElement(BoardPiece<ReversiPiece> piece)
	{
		String result = "";
		
		ReversiPiece reversiPiece = piece.getElement();
		
		if(reversiPiece == null)
			result = "_";
		else
			
		
		return result;
	}
	
}

