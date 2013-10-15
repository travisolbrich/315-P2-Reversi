package reversi.server;

import java.io.IOException;
import java.io.PrintWriter;

import base.models.IOModel;
import reversi.models.game.ReversiInput;

/**
 * Class that wraps up the server responses.
 * @author dereekb
 *
 */
public class ReversiServerResponse 
{
	public enum ServerResponseType
	{
		 ServerResponseTypeWelcome("WELCOME"),
		 
		 ServerResponseTypeOk("OK"),
		 
		 ServerResponseTypeMove("%s"),
		 
		 ServerResponseTypeIllegal("ILLEGAL"),
		 
		 ServerResponseTypeComment(";%s");
		 
		 private final String format;
		 
		ServerResponseType(String format)
		 {
			 this.format = format;
		 }

		 public String getFormat() {
			return format;
		}
	}
	
	private final ServerResponseType type;
	private final IOModel client;
	private final String comments;

	public ReversiServerResponse(IOModel client, ServerResponseType type)
	{
		this.client = client;
		this.type = type;
		this.comments = null;
	}
	
	public ReversiServerResponse(IOModel client, ServerResponseType type, String comments)
	{
		this.client = client;
		this.type = type;
		this.comments = comments;
	}

	public void send() throws IOException
	{
		PrintWriter writer = this.client.getWriter();
		String message = String.format(this.type.format, this.comments);
		writer.println(message);
	}
	

	public static void sendWelcome(IOModel client) throws IOException
	{
		ReversiServerResponse response = new ReversiServerResponse(client, ServerResponseType.ServerResponseTypeWelcome);
		response.send();
	}
	
	public static void sendOk(IOModel client) throws IOException
	{
		ReversiServerResponse response = new ReversiServerResponse(client, ServerResponseType.ServerResponseTypeOk);
		response.send();
	}
	
	public static void sendMove(IOModel client, ReversiInput input) throws IOException
	{
		String move = input.toString();
		ReversiServerResponse response = new ReversiServerResponse(client, ServerResponseType.ServerResponseTypeMove, move);
		response.send();
	}

	public static void sendIllegal(IOModel client) throws IOException
	{
		ReversiServerResponse response = new ReversiServerResponse(client, ServerResponseType.ServerResponseTypeIllegal);
		response.send();
	}
	
	public static void sendComment(IOModel client, String comment) throws IOException
	{
		ReversiServerResponse response = new ReversiServerResponse(client, ServerResponseType.ServerResponseTypeComment, comment);
		response.send();
	}
}
