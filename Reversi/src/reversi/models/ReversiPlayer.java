package reversi.models;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import base.models.Player;

public class ReversiPlayer extends Player {

	private final List<ReversiPiece> gamePieces = new ArrayList<ReversiPiece>();

	public ReversiPlayer(String name) {
		super(name);
	}
	
	public ReversiPlayer(String name, InputStream inputStream, OutputStream outputStream) {
		super(name, inputStream, outputStream);
	}

	public List<ReversiPiece> getGamePieces() {
		return gamePieces;
	}

}
