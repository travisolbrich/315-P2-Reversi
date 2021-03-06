package reversi.game.controller;

import java.util.Map;

import reversi.models.ReversiBoard;
import reversi.models.ReversiEntity;
import base.models.BoardPiece;
import base.models.Position;

public class ReversiBoardController {

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

	public ReversiBoard generateNewBoard() {

		ReversiBoard board = new ReversiBoard();
		Map<Position, BoardPiece<ReversiEntity>> boardPieces = board
				.getBoardElements();

		for (int c = 0; c < columns; c++) {
			for (int r = 1; r <= rows; r++) {
				Position position = new Position(c, r);
				BoardPiece<ReversiEntity> boardPiece = new BoardPiece<ReversiEntity>(
						position);
				boardPieces.put(position, boardPiece);
			}
		}

		return board;
	}

}
