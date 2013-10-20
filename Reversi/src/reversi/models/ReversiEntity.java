package reversi.models;

import base.models.Entity;
import base.models.Position;

public class ReversiEntity extends Entity {

	private final ReversiPlayer owner;

	public ReversiEntity(ReversiPlayer owner) {
		this.owner = owner;
	}

	public ReversiEntity(ReversiPlayer owner, Position position) {
		super(position);
		this.owner = owner;
	}

	public ReversiPlayer getOwner() {
		return owner;
	}

	@Override
	public Entity clone() {
		ReversiEntity entity = new ReversiEntity(this.owner, this.getPosition());
		return entity;
	}
	
}
