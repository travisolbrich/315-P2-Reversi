/**
 * 
 */
package main;

import java.io.IOException;

import reversi.client.ReversiClient;
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
		ReversiClient client = new ReversiClient();
		client.display();
	}

}
