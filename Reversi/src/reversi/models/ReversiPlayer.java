package reversi.models;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import base.models.Player;

public class ReversiPlayer extends Player {

	/**
	 * ASCII to represent this player's piece.
	 */
	private String pieceAscii;
	private final List<ReversiEntity> gamePieces = new ArrayList<ReversiEntity>();

	public ReversiPlayer(String name) {
		super(name);
	}
	
	public ReversiPlayer(String name, InputStream inputStream, OutputStream outputStream) {
		super(name, inputStream, outputStream);
	}

	public List<ReversiEntity> getGamePieces() {
		return gamePieces;
	}

	public String getAsciiDisplayPiece() {
		return pieceAscii;
	}

	public void setPieceAscii(String pieceAscii) {
		this.pieceAscii = pieceAscii;
	}

}
