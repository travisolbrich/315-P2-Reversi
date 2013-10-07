package reversi.server.controllers;

import reversi.models.ReversiPlayer;
import reversi.models.game.ReversiInput;
import base.game.controllers.input.HumanInputController;

/**
 * Input controller to use on the server for hosted games.
 * 
 * Will read from the player's input stream, and create a ReversiInput value from that.
 * 
 * @author dereekb
 *
 */
public class ReversiServerHumanInputController implements HumanInputController<ReversiPlayer, ReversiInput> {

	@Override
	public ReversiInput inputForHuman(ReversiPlayer human) {

		ReversiInput input = null;

		/*
		 *  TODO This is the input controller to use for remote games.
		 *  
		 *  This input controller will recieve input from the player's inputStream
		 *  and transform that into reversi input.
		 *  
		 *  http://docs.oracle.com/javase/tutorial/networking/sockets/readingWriting.html
		 */
		
		return input;
	}

}
