package reversi.game.controller;

import java.util.List;
import java.util.Set;

import base.models.Board;
import base.models.BoardPiece;
import base.models.Position;
import base.models.game.Turn;
import reversi.game.board.ReversiMoveFinder;
import reversi.game.board.ReversiMoveMaker;
import reversi.models.*;
import reversi.models.game.*;

/**
 * Turn controller for the Reversi game.
 * 
 * @author dereekb
 * 
 */
public class ReversiTurnController {

	private Board<ReversiEntity> previousTurn = null;
	private Board<ReversiEntity> currentTurn = null;
	private Board<ReversiEntity> nextTurn = null;

	public boolean processTurn(Turn<ReversiPlayer, ReversiInput> turn,
			Board<ReversiEntity> board) {

		boolean success = true;
		List<ReversiInput> playersInput = turn.getTurnInput();

		this.currentTurn = board.cloneBoard();

		/*
		 * TODO: Track modifications. The best way is probably to extend
		 * Position with player info.
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

			if (play.isWithinBounds()) {
				ReversiPlayer player = input.getPlayer();

				ReversiMoveFinder finder = new ReversiMoveFinder(board, player);
				Set<Position> moves = finder.findMoves();
				
				if (moves.contains(play)) {
					ReversiMoveMaker maker = new ReversiMoveMaker(board, player);
					maker.playAtPosition(play);
					success = true;
				} else {
					success = false;
				}
			} else {
				success = false;
				break;
			}
		}

		if (success) {
			this.previousTurn = this.currentTurn;
		}

		return success;
	}

	public boolean undoTurn(List<ReversiPlayer> players,
			Board<ReversiEntity> board) {

		boolean success = false;

		if (this.previousTurn != null) {
			this.currentTurn = board.cloneBoard();
			loadFromCopy(players, board, this.previousTurn);
			this.nextTurn = this.currentTurn;
			this.currentTurn = this.previousTurn;
			success = true;
		}

		return success;
	}

	public boolean redoTurn(List<ReversiPlayer> players,
			Board<ReversiEntity> board) {
	
		boolean success = false;
	
		/*
		 * TODO: Do the same as undo, except backwards.
		 */

		return success;
	}

	public void loadFromCopy(List<ReversiPlayer> players,
			Board<ReversiEntity> currentBoard, Board<ReversiEntity> copy) {
				
		for (int c = 0; c < 8; c++) {
			for (int r = 1; r <= 8; r++) {
				Position position = new Position(c, r);
				BoardPiece<ReversiEntity> currentPiece = currentBoard.getBoardPiece(position);
				BoardPiece<ReversiEntity> clonePiece = copy.getBoardPiece(position);
				
				currentPiece.setEntity(null);
				ReversiEntity cloneEntity = clonePiece.getEntity();
				currentPiece.setEntity(cloneEntity);
			}
		}
	}
	
	public boolean playerCanMakePlay(ReversiPlayer player, Board<ReversiEntity> board) 
	{
		ReversiMoveFinder finder = new ReversiMoveFinder(board, player);
		Set<Position> moves = finder.findMoves();
		return (moves.size() > 0);
	}
}
