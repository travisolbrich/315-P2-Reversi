package reversi.models;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

import base.models.Player;

public class ReversiPlayer extends Player {

	/**
	 * ASCII to represent this player's piece.
	 */
	private String pieceAscii;
	private final Set<ReversiEntity> gamePieces = new HashSet<ReversiEntity>();

	public ReversiPlayer(String name) {
		super(name);
	}
	
	public ReversiPlayer(String name, Socket socket) throws IOException {
		super(name, socket.getInputStream(), socket.getOutputStream());
	}
	
	public ReversiPlayer(String name, InputStream inputStream, OutputStream outputStream) {
		super(name, inputStream, outputStream);
	}

	public Set<ReversiEntity> getGamePieces() {
		return gamePieces;
	}

	public String getAsciiDisplayPiece() {
		return pieceAscii;
	}

	public void setPieceAscii(String pieceAscii) {
		this.pieceAscii = pieceAscii;
	}

}
