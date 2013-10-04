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
		TurnController<ReversiPlayer, ReversiPiece, ReversiInput> {	
	
	@Override
	public void processTurn(Turn<ReversiPlayer, ReversiInput> turn,
			Board<ReversiPiece> board) {
		
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

}
