package reversi.models.game;

import reversi.models.ReversiPlayer;
import base.models.Position;
import base.models.game.Input;

public class ReversiInput extends Input<ReversiPlayer> {

	public final Position position;

	public ReversiInput(ReversiPlayer player, Position position) {
		super(player);
		this.position = position;
	}

	public Position getPosition() {
		return position;
	}

	@Override
	public String toString()
	{
		String string = String.format("%s", position.toString());
		return string;
	}
}
