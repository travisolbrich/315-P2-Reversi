package reversi.models;

import base.models.Entity;
import base.models.Position;

public class ReversiPiece extends Entity {

	private final ReversiPlayer owner;

	public ReversiPiece(ReversiPlayer owner) {
		this.owner = owner;
	}

	public ReversiPiece(ReversiPlayer owner, Position position) {
		super(position);
		this.owner = owner;
	}

	public ReversiPlayer getOwner() {
		return owner;
	}

}
