package base.game.messages;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import base.models.IOModel;

/**
 * Default message handler for sending messages to a group of players.
 * 
 * @author dereekb
 * 
 */
public class DefaultMessageHandler implements MessageHandler {

	private static final String defaultFormat = "%s - %s";

	protected final String messageFormat;
	protected final PrintWriter writer;

	public DefaultMessageHandler() {
		this(System.out);
	}

	public DefaultMessageHandler(OutputStream stream) {
		this(stream, defaultFormat);
	}

	public DefaultMessageHandler(OutputStream stream, String format) {
		writer = new PrintWriter(stream);
		this.messageFormat = format;
	}

	@Override
	public void writeMessage(String message) {
		this.writer.println(message);
	}

	@Override
	public void writeMessage(String type, String message) {
		String formattedMessage = this.formatMessage(type, message);
		this.writer.println(formattedMessage);
	}

	public void writeUnformattedMessage(String message) throws IOException {
		this.writer.println(message);
	}
	
	public String formatMessage(String type, String message) {
		return String.format(this.messageFormat, type, message);
	}
}
