package reversi.client;

import base.server.GameServerDelegate;
import reversi.client.gui.ReversiClientGUI;
import reversi.client.gui.ReversiClientGUIDelegate;
import reversi.server.ReversiServer;

public class ReversiClient implements ReversiClientGUIDelegate, GameServerDelegate{

	private final ReversiClientGUI gui;
	private ReversiServer server;
	private boolean serverRunning = false;
	
	public ReversiClient() {
		gui = new ReversiClientGUI(this);
	}
	
	/**
	 * Starting point for the client.
	 */
	public void display() {
		gui.setVisible(true);
	}

	@Override
	public boolean startServer(Integer port) {
		
		this.server = new ReversiServer(this, port);
		server.start();
		
		return true;	//Return true/false depending on if the port is available.
	}

	@Override
	public void serverStarted() {
		serverRunning = true;
	}

	@Override
	public void serverClosed() {
		serverRunning = false;
	}

	@Override
	public boolean playLocal() {
		// TODO Auto-generated method stub
		
		
		
		
		return false;
	}

	@Override
	public boolean playRemote(String address, String port) {
		// TODO Auto-generated method stub
		return false;
	}

}
