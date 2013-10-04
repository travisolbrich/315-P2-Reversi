package base.models;

public class BoardPiece<E extends Entity> {

	private final Position position;
	private E element;

	public BoardPiece(Position position) {
		this.position = position;
	}

	public E getElement() {
		return element;
	}

	public void setElement(E element) {
		this.element = element;
	}

	public Position getPosition() {
		return position;
	}

}
