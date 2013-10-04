package reversi.game.controller.input;

import base.game.controllers.input.IntelligenceInputController;
import reversi.models.ReversiPlayer;
import reversi.models.game.ReversiInput;

/**
 * Artificial Intelligence used in the game.
 * 
 * @author dereekb
 * 
 */
public class ReversiIntelligenceInputController implements
		IntelligenceInputController<ReversiPlayer, ReversiInput> {

	private final Integer difficulty;

	public ReversiIntelligenceInputController(Integer difficulty) {
		this.difficulty = difficulty;
	}

	@Override
	public ReversiInput inputForIntelligence(ReversiPlayer intelligence) {

		/*
		 * TODO This is where to implement the AI's intelligence.
		 */

		return null;
	}

	@Override
	public Integer getDifficultyForPlayer(ReversiPlayer intelligence) {
		return this.difficulty;
	}
}
