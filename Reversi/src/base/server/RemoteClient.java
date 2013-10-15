package base.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

import base.models.IOModel;
import base.models.Player;


/**
 * Keeps track of a connected client.
 * 
 * @author dereekb
 * 
 */
public class RemoteClient<P extends Player> implements IOModel{

	private P player;
	private String asciiPiece;
	private boolean isObserver = false;
	private final Socket socket;

	public RemoteClient(Socket socket){
		this.socket = socket;
	}

	public P getPlayer(){
		return player;
	}

	public void setPlayer(P player){
		this.player = player;
	}

	public Socket getSocket(){
		return socket;
	}

	public PrintWriter getWriter() throws IOException{
		OutputStream output = this.socket.getOutputStream();
		PrintWriter writer = new PrintWriter(output, true);
		return writer;
	}

	public Scanner getInputScanner() throws IOException{
		InputStream input = this.socket.getInputStream();
		Scanner scanner = new Scanner(input);
		return scanner;
	}

	public String getAddress(){
		InetAddress address = this.socket.getInetAddress();
		return address.getHostAddress();
	}

	public String getAsciiPiece() {
		return asciiPiece;
	}

	public void setAsciiPiece(String asciiPiece) {
		this.asciiPiece = asciiPiece;
	}

	public boolean isObserver() {
		return isObserver;
	}

	public void setObserver(boolean isObserver) {
		this.isObserver = isObserver;
	}
}
