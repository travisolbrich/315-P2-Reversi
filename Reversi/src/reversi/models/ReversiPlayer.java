package reversi.models;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import base.models.Player;

public class ReversiPlayer extends Player {

	/**
	 * ASCII to represent this player's piece.
	 */
	private String pieceAscii = null;

	public ReversiPlayer(String name) {
		super(name);
	}

	public ReversiPlayer(String name, String pieceAscii) {
		super(name);
		this.pieceAscii = pieceAscii;
	}

	public ReversiPlayer(String name, Socket socket) throws IOException {
		super(name, socket.getInputStream(), socket.getOutputStream());
	}
	
	public ReversiPlayer(String name, String pieceAscii, Socket socket) throws IOException {
		super(name, socket.getInputStream(), socket.getOutputStream());
		this.pieceAscii = pieceAscii;
	}
	
	public ReversiPlayer(String name, InputStream inputStream, OutputStream outputStream) {
		super(name, inputStream, outputStream);
	}

	public String getAsciiDisplayPiece() {
		return pieceAscii;
	}

	public void setAsciiPiece(String pieceAscii) {
		this.pieceAscii = pieceAscii;
	}

	public String toString()
	{
		return this.getName();
	}
}
