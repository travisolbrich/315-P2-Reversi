package reversi.models.game;

import reversi.models.ReversiPlayer;
import reversi.server.commands.ReversiCommand;
import base.models.Position;
import base.models.game.Input;

public class ReversiInput extends Input<ReversiPlayer> {

	private final Position position;
	private final ReversiCommand command;

	public ReversiInput(ReversiPlayer player, Position position) {
		super(player);
		this.position = position;
		this.command = null;
	}

	public ReversiInput(ReversiPlayer player, ReversiCommand command) {
		super(player);
		this.position = null;
		this.command = command;
	}

	public Position getPosition() {
		return position;
	}

	public ReversiCommand getCommand() {
		return command;
	}

	public boolean isCommand(){
		return (command != null); 
	}
	
	@Override
	public String toString()
	{
		String string = String.format("%s", position.toString());
		return string;
	}
}
