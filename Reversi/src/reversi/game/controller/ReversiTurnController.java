package reversi.game.controller;

import java.util.List;

import base.game.controllers.TurnController;
import base.models.Board;
import base.models.Position;
import base.models.game.Turn;
import reversi.game.board.ReversiMoveMaker;
import reversi.models.*;
import reversi.models.game.*;

/**
 * Turn controller for the Reversi game.
 * 
 * @author dereekb
 * 
 */
public class ReversiTurnController implements
		TurnController<ReversiPlayer, ReversiEntity, ReversiInput> {

	@Override
	public boolean processTurn(Turn<ReversiPlayer, ReversiInput> turn,
			Board<ReversiEntity> board) {

		boolean success = true;
		List<ReversiInput> playersInput = turn.getTurnInput();
		
		/*
		 * TODO: Track modifications. 
		 * The best way is probably to extend Position with player info.
		 */
		
		for (ReversiInput input : playersInput) {
			/*
			 * TODO Processes the user's turn.
			 * 
			 * There "should" be only one turn here that the
			 * ReversiInputController returns, but use a for-loop anyways.
			 * 
			 * This is where the Reversi game-logic is implemented; Just create
			 * ReversiPieces where they belong, given the placementPosition.
			 */

			Position play = input.getPosition();

			if(play.isWithinBounds())
			{
	
				ReversiPlayer player = input.getPlayer();
	
				ReversiMoveMaker maker = new ReversiMoveMaker(board, player);
				maker.playAtPosition(play);
			} else {
				success = false;
				// TODO: Undo changes. Although I guess this won't matter since there is only 1 player.
				break; 
			}
		}

		return success;
	}

	@Override
	public boolean undoTurn(Turn<ReversiPlayer, ReversiInput> turn,
			Board<ReversiEntity> board) {

		boolean success = false;

		/*
		 * TODO: Undo commands! The easiest way is probably for this
		 * TurnController to keep track of previous turns before state, then
		 * when undo is called revert to that state.
		 */

		return success;
	}

}
