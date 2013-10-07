package base.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Base game server that waits for a client to connect.
 * 
 * Opens a port and waits until a command to create a GameLobby is sent.
 * 
 * @author dereekb
 * 
 */
public abstract class GameServer{

	private final Integer serverPort;
	
	public GameServer(Integer serverPort) {
		this.serverPort = serverPort;
	}
	
	public void startServer() throws IOException
	{
        ServerSocket serverSocket = null;
        
        try {
            serverSocket = new ServerSocket(this.serverPort);
            boolean online = true;
            
            while(online)
            {
            	Socket connectedClient = serverSocket.accept();
            	this.clientConnected(connectedClient);
            }    		
        } catch (IOException e) {
            System.err.println("Could not listen on port: 4444.");
            System.exit(1);
        } finally {
        	serverSocket.close();
        }
	}
	
	public abstract void clientConnected(Socket socket);
}
