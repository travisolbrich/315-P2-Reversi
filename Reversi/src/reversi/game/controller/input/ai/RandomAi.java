package reversi.game.controller.input.ai;

import java.util.Set;

import reversi.game.board.ReversiMoveFinder;
import reversi.models.ReversiBoard;
import reversi.models.ReversiPlayer;
import reversi.models.game.ReversiInput;
import base.models.Position;

public class RandomAi extends ReversiAi {

	public RandomAi(Integer difficulty) {
		super(difficulty);
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

}
