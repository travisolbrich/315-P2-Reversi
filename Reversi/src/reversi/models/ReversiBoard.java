package reversi.models;


import java.util.List;

import reversi.server.display.ReversiAsciiDisplayController;
import base.models.Board;
import base.models.BoardPiece;
import base.models.Position;

public class ReversiBoard extends Board<ReversiEntity> {

	public String getASCIIView()
	{
		return ReversiAsciiDisplayController.drawBoard(this);
	}

	public void setInitialPieces(List<ReversiPlayer> players) {
		
		final String whitePieceDisplay = ReversiAsciiDisplayController.whiteReversiPiece;
		
		ReversiPlayer human = players.get(0);
		ReversiPlayer ai = players.get(1);
		
		//Set four positions at the center of the board.
		ReversiPlayer whitePlayer = (human.getAsciiDisplayPiece().equals(whitePieceDisplay)) ? human : ai;
		ReversiPlayer blackPlayer = (human == whitePlayer) ? ai : human;

		this.createElementAtPositionForPlayer(new Position("d",4), whitePlayer);
		this.createElementAtPositionForPlayer(new Position("e",5), whitePlayer);
		this.createElementAtPositionForPlayer(new Position("d",5), blackPlayer);
		this.createElementAtPositionForPlayer(new Position("e",4), blackPlayer);
	}
	
	private void createElementAtPositionForPlayer(Position position, ReversiPlayer player)
	{
		ReversiEntity newPiece = new ReversiEntity(player, position);
		player.getGamePieces().add(newPiece);
		BoardPiece<ReversiEntity> boardPiece = this.getBoardPiece(position);
		boardPiece.setEntity(newPiece);
	}

}
