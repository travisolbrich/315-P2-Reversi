package reversi.game.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import reversi.game.controller.input.ReversiHumanInputController;
import reversi.game.controller.input.ReversiIntelligenceInputController;
import reversi.models.ReversiBoard;
import reversi.models.ReversiPlayer;
import reversi.models.game.ReversiInput;
import base.game.controllers.InputController;
import base.game.controllers.input.HumanInputController;
import base.game.controllers.input.IntelligenceInputController;

public class ReversiInputController extends
		InputController<ReversiPlayer, ReversiInput, ReversiBoard> {

	private ReversiPlayer previousPlayer = null;

	public ReversiInputController(
			HumanInputController<ReversiPlayer, ReversiInput> humanController,
			IntelligenceInputController<ReversiPlayer, ReversiInput, ReversiBoard> intelligenceController) {
		super(humanController, intelligenceController);
	}

	@Override
	protected List<ReversiPlayer> filterPlayersForNextTurn(List<ReversiPlayer> players) {
		
		ReversiPlayer currentPlayer = null;
		
		if(previousPlayer == null){
			currentPlayer = players.get(0);
		} else {
			for(ReversiPlayer player : players)
			{
				if(this.previousPlayer != player)
				{
					currentPlayer = player;
					break;
				}
			}
		}
		
		previousPlayer = currentPlayer;
		List<ReversiPlayer> playing = new ArrayList<ReversiPlayer>(1);
		playing.add(currentPlayer);
		return playing;
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
