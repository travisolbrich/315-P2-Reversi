package reversi.game.controller.input.ai;

import reversi.models.ReversiBoard;
import reversi.models.ReversiPlayer;
import reversi.models.game.ReversiInput;
import base.game.controllers.input.IntelligenceInputController;

public abstract class ReversiAi implements IntelligenceInputController<ReversiPlayer, ReversiInput, ReversiBoard> {

	protected final Integer difficulty;

	public ReversiAi(Integer difficulty) {
		this.difficulty = difficulty;
	}

	@Override
	public abstract ReversiInput inputForIntelligence(ReversiPlayer intelligence, ReversiBoard board);

	@Override
	public Integer getDifficultyForAiPlayer(ReversiPlayer intelligence) {
		return this.difficulty;
	}
}
