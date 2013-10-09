package reversi.server.commands;

/**
 * Interface used to read/interpret commands.
 * @author dereekb
 *
 */
public interface ReversiCommandReader {

	public ReversiCommand readCommand(String input);
	
}
