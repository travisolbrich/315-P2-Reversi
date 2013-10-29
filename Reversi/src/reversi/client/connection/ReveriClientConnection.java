package reversi.client.connection;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import base.models.IOModel;

public class ReveriClientConnection implements IOModel {

	public static class ReversiClientConnectionUninitialized extends RuntimeException {

		private static final long serialVersionUID = 1L;
		
	}
	
	private Socket connectionSocket;
	
	public ReveriClientConnection() {}

	public void connect(String ip, Integer port) throws UnknownHostException, IOException {
		try {
			this.connectionSocket = new Socket(ip, port);
		} catch (UnknownHostException e) {
			this.connectionSocket = null;
			throw e;
		} catch (IOException e) {
			this.connectionSocket = null;
			throw e;
		}
	}
	
	public void disconnect() throws UnknownHostException, IOException {
		if(this.connectionSocket != null) {
			this.connectionSocket.close();
		}
	}

	public InputStream getInputStream() throws IOException {
		return this.connectionSocket.getInputStream();
	}

	public OutputStream getOutputStream() throws IOException {
		return this.connectionSocket.getOutputStream();
	}

	public PrintWriter getWriter() throws IOException{
		OutputStream output = this.getOutputStream();
		PrintWriter writer = new PrintWriter(output, true);
		return writer;
	}

	public Scanner getInputScanner() throws IOException{
		InputStream input = this.getInputStream();
		Scanner scanner = new Scanner(input);
		return scanner;
	}
	
}
