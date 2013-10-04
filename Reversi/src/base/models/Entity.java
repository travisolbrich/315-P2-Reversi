package base.models;

/**
 * Basic game entity that sits on the board.
 * 
 * @author dereekb
 * 
 * @param <E>
 * @param <P>
 */
public abstract class Entity {

	private Position position;

	public Entity() {
	};

	public Entity(Position position) {
		this.position = position;
	};

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

}
