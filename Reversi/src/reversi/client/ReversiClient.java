package reversi.client;

import java.io.IOException;
import java.net.UnknownHostException;

import base.server.GameServerDelegate;
import reversi.client.connection.ReveriClientConnection;
import reversi.client.gui.ReversiClientGUI;
import reversi.client.gui.ReversiClientGUIDelegate;
import reversi.server.ReversiServer;

public class ReversiClient implements ReversiClientGUIDelegate, GameServerDelegate {

	private final ReversiClientGUI gui;
	private ReversiServer server;
	private ReveriClientConnection client;
	private boolean serverRunning = false;

	public ReversiClient() {
		this.gui = new ReversiClientGUI(this);
		this.client = new ReveriClientConnection();
	}

	/**
	 * Starting point for the client.
	 */
	public void display() {
		gui.setVisible(true);
	}

	@Override
	public void startServer(Integer port) {

		this.server = new ReversiServer(this, port);
		this.server.start();

		//return true; // Return true/false depending on if the port is available.
	}

	@Override
	public void serverStarted() {
		serverRunning = true;
		this.gui.enableStartServerButton(false);
		this.gui.displayMessage("The server has started.");
	}

	@Override
	public void serverClosed() {
		serverRunning = false;
		this.gui.enableStartServerButton(true);
		this.gui.displayMessage("The server shut down.");
	}

	@Override
	public boolean playLocal() {

		boolean success = false;

		if (this.serverRunning) {

			String address = "localhost";
			Integer port = this.server.getServerPort();

			this.playRemote(address, port.toString());

			this.gui.displayMessage("Successfully connected to the remote server.");

		} else {
			this.gui.displayMessage("The local server has not started.");
			success = false;
		}

		return success;
	}

	@Override
	public boolean playRemote(String address, String port) {

		boolean success = false;
		Integer portInteger = null;
		
		try{
			portInteger = new Integer(port);
			
			if(portInteger < 0 && portInteger > 65535) {
				this.gui.displayMessage("The port specified was invalid. It must be between 0 and 65535.");
				success = false;
			} else {
				success = true;
			}
			
			if(success) {
				this.client.connect(address, portInteger);
				this.gui.setClientConnection(this.client);
				this.gui.showGameGUI(true);
			}
			
		} catch(NumberFormatException e) {
			this.gui.displayMessage("The specified port was invalid.");
		} catch(UnknownHostException e) {
			this.gui.displayMessage("The specified host was not found.");
		} catch(IOException e) {
			this.gui.displayMessage("An unspecified error occured while trying to open a connection.");
		}
		
		return false;
	}
}
