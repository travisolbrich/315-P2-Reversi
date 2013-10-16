package base.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Base game server that waits for a client to connect.
 * 
 * Opens a port and waits until a command to create a GameLobby is sent.
 * 
 * @author dereekb
 * 
 */
public abstract class GameServer {

	private final Integer serverPort;
	public GameServer(Integer serverPort) {
		this.serverPort = serverPort;
	}

	public void startServer() throws IOException {
		ServerSocket serverSocket = null;

		try {
			serverSocket = new ServerSocket(this.serverPort);			
			boolean online = true;

			this.printStartupMessage();

			while (online) {
				Socket socket = serverSocket.accept();
				this.handleSocketConnection(socket);
			}

		} catch (IOException e) {
			String message = String.format("Could not listen on port '%d'.", this.serverPort);
			System.out.println(message);
			System.exit(1);
		} finally {
			if (serverSocket != null) {
				serverSocket.close();
			}
			
			this.printShutdownMessage();
		}
	}

	protected void printStartupMessage() throws UnknownHostException {
		String message = String.format("Server started on port '%d'. Local IP is '%s'.",
				this.serverPort, InetAddress.getLocalHost().getHostAddress());
		
		System.out.println(message);
	}

	protected void printShutdownMessage() {
		String message = String.format("Server shutting down...",
				this.serverPort);
		System.out.println(message);
	}

	protected void handleSocketConnection(Socket socket) throws IOException
	{
		String message = String.format("Client connected from '%s'.", socket.getInetAddress().getHostAddress());
		System.out.println(message);
		
		this.clientConnected(socket);
	}
	
	public abstract void clientConnected(Socket socket) throws IOException;
}
