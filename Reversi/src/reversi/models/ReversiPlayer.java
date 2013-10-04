package reversi.models;

import java.util.ArrayList;
import java.util.List;

import base.models.Player;

public class ReversiPlayer extends Player {

	private final List<ReversiPiece> gamePieces = new ArrayList<ReversiPiece>();

	public ReversiPlayer(String name) {
		super(name);
	}

	public List<ReversiPiece> getGamePieces() {
		return gamePieces;
	}

}
