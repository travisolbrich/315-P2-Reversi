package reversi.game.controller;

import java.util.List;

import reversi.game.controller.input.ReversiHumanInputController;
import reversi.game.controller.input.ReversiIntelligenceInputController;
import reversi.models.ReversiPlayer;
import reversi.models.game.ReversiInput;
import base.game.controllers.InputController;
import base.game.controllers.input.HumanInputController;
import base.game.controllers.input.IntelligenceInputController;

public class ReversiInputController extends
		InputController<ReversiPlayer, ReversiInput> {

	private ReversiPlayer previousPlayer = null;

	public ReversiInputController(
			HumanInputController<ReversiPlayer, ReversiInput> humanController,
			IntelligenceInputController<ReversiPlayer, ReversiInput> intelligenceController) {
		super(humanController, intelligenceController);
	}


	@Override
	protected List<ReversiPlayer> filterPlayersForNextTurn(
			List<ReversiPlayer> players) {
		
		// TODO Auto-generated method stub
		/*
		 * Reversi has a single player per turn, so this controller will track
		 * the player who played last, then filter out all players except that
		 * one.
		 */

		return null;
	}
	
	
	//Defaults
	public static ReversiInputController defaultServerController(
			Integer difficulty) {

		ReversiHumanInputController humanInput = new ReversiHumanInputController();
		ReversiIntelligenceInputController intelInput = new ReversiIntelligenceInputController(
				difficulty);

		ReversiInputController inputController = new ReversiInputController(
				humanInput, intelInput);
		return inputController;
	}

}
