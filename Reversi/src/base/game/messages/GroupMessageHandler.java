package base.game.messages;

import java.io.IOException;
import java.util.List;

import base.models.IOModel;

/**
 * Message handler for sending messages the group.
 * 
 * @author dereekb
 */
public class GroupMessageHandler implements MessageHandler {

	private static final String defaultFormat = "%s: %s";

	protected final boolean outputToSystem;
	protected final List<? extends IOModel> listeners;
	protected final String messageFormat;

	public GroupMessageHandler(List<? extends IOModel> listeners) {
		this.outputToSystem = true;
		this.listeners = listeners;
		this.messageFormat = defaultFormat;
	}

	public GroupMessageHandler(List<? extends IOModel> listeners, String format) {
		this.outputToSystem = true;
		this.listeners = listeners;
		this.messageFormat = format;
	}

	public GroupMessageHandler(List<? extends IOModel> listeners, String format, boolean outputToSystem) {
		this.outputToSystem = outputToSystem;
		this.listeners = listeners;
		this.messageFormat = format;
	}

	@Override
	public void writeMessage(String message) throws IOException {
		this.writeMessage("System", message);
	}

	@Override
	public void writeMessage(String sender, String message) throws IOException {

		String formattedMessage = this.formatMessage(sender, message);

		for (IOModel model : this.listeners) {
			model.getWriter().println(formattedMessage);
		}

		if (outputToSystem) {
			System.out.println(formattedMessage);
		}
	}

	@Override
	public void writeUnformattedMessage(String message) throws IOException {

		for (IOModel model : this.listeners) {
			model.getWriter().println(message);
		}

		if (outputToSystem) {
			System.out.println(message);
		}
	}

	public String formatMessage(String sender, String message) {
		return String.format(this.messageFormat, sender, message);
	}
}
