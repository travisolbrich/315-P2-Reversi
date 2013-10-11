package reversi.game.controller;

import reversi.models.ReversiBoard;
import reversi.models.ReversiEntity;
import reversi.models.ReversiPlayer;
import base.game.controllers.PlayerController;

public class ReversiPlayerController extends
		PlayerController<ReversiPlayer, ReversiEntity, ReversiBoard> {

	@Override
	public void updateScore(ReversiBoard board) {
		/*
		 * TODO Update the score.
		 * 
		 * Since this is a player controller, it has access to all the players
		 * who have a list of tokens they own.
		 * 
		 * Update the score using those token counts.
		 * 
		 * Score will be a local variable, or linked to the players.
		 */
	}

}
