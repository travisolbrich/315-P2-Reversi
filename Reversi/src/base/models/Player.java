package base.models;

/**
 * Base player class that contains information about a given player.
 * @author dereekb
 *
 * @param <E> Elements that the player can control.
 */
public abstract class Player {

	private final String name;
	private Boolean inGame;
	private Boolean controlledByAi;

	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Boolean isInGame() {
		return inGame;
	}

	public void setInGame(Boolean inGame) {
		this.inGame = inGame;
	}

	public Boolean isHuman() {
		return controlledByAi;
	}

	public void setControlledByAi(Boolean controlledByAi) {
		this.controlledByAi = controlledByAi;
	}

}
