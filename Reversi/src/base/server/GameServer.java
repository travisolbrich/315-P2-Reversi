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
public abstract class GameServer implements Runnable {

	private Thread thread;
	private final Integer serverPort;
	private final GameServerDelegate delegate;
	
	public GameServer(GameServerDelegate delegate, Integer serverPort) {
		this.serverPort = serverPort;
		this.delegate = delegate;
	}

	public void start() {
		Thread serverThread = this.getThread();
		serverThread.start();
	}

	public Thread getThread() {

		//Lazy Loading
		if (this.thread == null) {
			this.thread = new Thread(this);
			this.thread.setDaemon(true);
		}

		return this.thread;
	}
	
	public void run() {
		ServerSocket serverSocket = null;

		try {
			serverSocket = new ServerSocket(this.serverPort);			
			boolean online = true;

			this.printStartupMessage();
			delegate.serverStarted();

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
				try {
					serverSocket.close();
				} catch (IOException e) {
				}
			}
			
			this.printShutdownMessage();
			delegate.serverClosed();
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
