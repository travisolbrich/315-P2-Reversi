package reversi.game.controller.input;

import reversi.models.ReversiPlayer;
import reversi.models.game.ReversiInput;
import base.game.controllers.input.HumanInputController;

/**
 * Input controller used for local games run through the Console.
 * @author dereekb
 *
 */
public class ReversiHumanInputController implements HumanInputController<ReversiPlayer, ReversiInput> {

	@Override
	public ReversiInput inputForHuman(ReversiPlayer human) {

		ReversiInput input = null;
		
		/*
		 *  TODO This is the input controller to use for local games.
		 *  
		 *  This input controller will recieve input from System.in 
		 *  and transform that into reversi input.
		 *  
		 *  For handling a GUI, 
		 *  this class can be extended (Or another can just implement HumanInputController)
		 *  to update the GUI and wait for a player to click.
		 */
			
		return input;
	}

}
