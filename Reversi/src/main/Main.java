/**
 * 
 */
package main;

import java.io.IOException;

import reversi.server.ReversiServer;

/**
 * @author travis
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		ReversiServer server = new ReversiServer(1400);
		
		server.startServer();
		
	}

}
