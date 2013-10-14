package reversi.server.controllers.exceptions;

/**
 * Used to exit the lobby loop.
 * @author dereekb
 *
 */
public class ExitException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ExitException() {
		super();
	}
}