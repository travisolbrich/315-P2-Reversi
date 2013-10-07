package base.game.messages;

public interface MessageHandler {

	public void writeMessage(String message);
	public void writeMessage(String type, String message);
	
}
