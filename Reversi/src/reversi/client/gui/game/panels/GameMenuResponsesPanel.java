package reversi.client.gui.game.panels;

import java.io.IOException;
import java.util.Scanner;

import javax.swing.JTextArea;

import reversi.client.connection.ReversiClientConnection;

/**
 * Panel that listens to the remote server's responses and displays them.
 * 
 * @author dereekb
 * 
 */
public class GameMenuResponsesPanel extends JTextArea implements Runnable {

	private static final long serialVersionUID = 1L;
	
	private Thread thread;
	private final ReversiClientConnection connection;
	private final static String newline = "\n";

	public GameMenuResponsesPanel(ReversiClientConnection connection) {
		super(20, 20);
        this.setEditable(false);
		this.connection = connection;
		this.setText(" - - - - - - - - ");
	}

	public void appendMessage(String response) {
		//String text = this.getText();
		this.append(response + newline);
	}

	public void start() {
		Thread serverThread = this.getThread();
		serverThread.start();
	}

	public void stop() {
		Thread thread = this.getThread();
		thread.interrupt();
	}

	@Override
	public void run() {

		try {
			Scanner scanner = connection.getInputScanner();

			while (Thread.currentThread().isInterrupted() == false) {
				String response = scanner.nextLine();				
				this.appendMessage(response);
			}
			
		} catch (IOException e) {
			this.setText("Error.");
		}
		
		
	}

	public Thread getThread() {

		// Lazy Loading
		if (this.thread == null) {
			this.thread = new Thread(this);
			this.thread.setDaemon(true);
		}

		return this.thread;
	}

}
