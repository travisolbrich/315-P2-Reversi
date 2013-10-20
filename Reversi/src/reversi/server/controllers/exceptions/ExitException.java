package reversi.server.controllers.exceptions;

import base.models.IOModel;

/**
 * Used to exit the lobby loop.
 * @author dereekb
 *
 */
public class ExitException extends RuntimeException {
	
	private final IOModel client;
	
	private static final long serialVersionUID = 1L;

	public ExitException(IOModel client) {
		super();
		this.client = client;
	}

	public IOModel getClient() {
		return client;
	}
}