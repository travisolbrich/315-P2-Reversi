package base.models;

public class BoardPiece<E extends Entity> {

	private final Position position;
	private E entity;

	public BoardPiece(Position position) {
		this.position = position;
	}

	public E getEntity() {
		return entity;
	}

	public void setEntity(E entity) {
		this.entity = entity;
	}

	public Position getPosition() {
		return position;
	}

}
