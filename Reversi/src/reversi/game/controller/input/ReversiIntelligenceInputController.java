package reversi.game.controller.input;

import java.util.Set;

import base.game.controllers.input.IntelligenceInputController;
import base.models.Position;
import reversi.game.board.ReversiMoveFinder;
import reversi.models.ReversiBoard;
import reversi.models.ReversiPlayer;
import reversi.models.game.ReversiInput;

/**
 * Artificial Intelligence used in the game.
 * 
 * @author dereekb
 * 
 */
public class ReversiIntelligenceInputController implements
		IntelligenceInputController<ReversiPlayer, ReversiInput, ReversiBoard> {

	private final Integer difficulty;

	public ReversiIntelligenceInputController(Integer difficulty) {
		this.difficulty = difficulty;
	}

	@Override
	public ReversiInput inputForIntelligence(ReversiPlayer intelligence, ReversiBoard board) {

		ReversiInput input = null;

		/*
		 * TODO This is where to implement the AI's intelligence.
		 * 
		 * For now, it just takes a random available move.
		 */
		
		ReversiMoveFinder finder = new ReversiMoveFinder(board, intelligence);
		Set<Position> moves = finder.findMoves();
		
		if(moves.size() > 0)
		{
			Position move = moves.iterator().next();
			input = new ReversiInput(intelligence, move);
		}

		return input;
	}

	@Override
	public Integer getDifficultyForPlayer(ReversiPlayer intelligence) {
		return this.difficulty;
	}
}
