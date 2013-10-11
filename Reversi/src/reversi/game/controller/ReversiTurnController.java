package reversi.game.controller;

import java.util.List;

import base.game.controllers.TurnController;
import base.models.Board;
import base.models.Position;
import base.models.game.Turn;
import reversi.models.*;
import reversi.models.game.*;

/**
 * Turn controller for the Reversi game.
 * @author dereekb
 *
 */
public class ReversiTurnController implements
		TurnController<ReversiPlayer, ReversiEntity, ReversiInput> {	

	@Override
	public void processTurn(Turn<ReversiPlayer, ReversiInput> turn,
			Board<ReversiEntity> board) {
		
		List<ReversiInput> playersInput = turn.getTurnInput();
		
		for(ReversiInput input : playersInput)
		{
			Position placementPosition = input.getPosition();
			
			/*
			 *  TODO Processes the user's turn. 
			 *  
			 *  There "should" be only one turn here that the ReversiInputController returns, 
			 *  but use a for-loop anyways.
			 *  
			 *  This is where the Reversi game-logic is implemented;
			 *  Just create ReversiPieces where they belong, given the placementPosition.
			 */
			
		}
		
	}
	
	@Override
	public void undoTurn(Turn<ReversiPlayer, ReversiInput> turn,
			Board<ReversiEntity> board) {
		
		/*
		 * TODO: Undo commands! 
		 * The easiest way is probably for this TurnController to keep track of previous turns before state, 
		 * then when undo is called revert to that state.
		 */	
	}

}
