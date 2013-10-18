package base.game.messages;

import java.io.IOException;

public interface MessageHandler {

	public void writeMessage(String message) throws IOException;
	public void writeMessage(String type, String message) throws IOException;
	public void writeUnformattedMessage(String message) throws IOException;

}
