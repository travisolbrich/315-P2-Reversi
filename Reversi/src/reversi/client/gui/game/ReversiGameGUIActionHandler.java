package reversi.client.gui.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;

import reversi.client.connection.ReveriClientConnection;

public class ReversiGameGUIActionHandler implements ActionListener{

	private ReveriClientConnection client;
	
	public ReversiGameGUIActionHandler() {}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		try {
			System.out.println("Sending command to remote server: " + command);
			PrintWriter writer = client.getWriter();
			writer.println(command);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public ReveriClientConnection getClient() {
		return client;
	}

	public void setClient(ReveriClientConnection client) {
		this.client = client;
	}
	
}
