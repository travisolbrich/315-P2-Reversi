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

	private final static Integer defaultPort = 1400;
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		ReversiServer server = new ReversiServer(defaultPort);		
		server.startServer();		
	}

}
