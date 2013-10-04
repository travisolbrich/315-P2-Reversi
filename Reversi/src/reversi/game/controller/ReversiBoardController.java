package reversi.game.controller;

import java.util.Map;

import reversi.models.ReversiBoard;
import reversi.models.ReversiPiece;
import base.game.controllers.BoardController;
import base.models.BoardPiece;
import base.models.Position;

public class ReversiBoardController implements BoardController<ReversiBoard> {

	private final Integer columns;
	private final Integer rows;

	public ReversiBoardController() {
		this.columns = 8;
		this.rows = 8;
	}

	public ReversiBoardController(Integer columns, Integer rows) {
		this.columns = columns;
		this.rows = rows;
	}

	@Override
	public ReversiBoard generateNewBoard() {

		ReversiBoard board = new ReversiBoard();
		Map<Position, BoardPiece<ReversiPiece>> boardPieces = board
				.getBoardElements();

		/*
		 * TODO Generate a new board with the given columns/rows.
		 * 
		 * Will create a new, empty element for each row/column and insert them
		 * into the board.
		 * 
		 * Just have two for-loops, generate positions, and create new
		 * BoardPieces.
		 */

		return board;
	}

}
