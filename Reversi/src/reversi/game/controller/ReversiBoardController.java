package reversi.game.controller;

import java.util.Map;

import reversi.models.ReversiBoard;
import reversi.models.ReversiEntity;
import base.game.controllers.BoardController;
import base.models.BoardPiece;
import base.models.Position;

public class ReversiBoardController implements BoardController<ReversiBoard> {

	private static final String[] columnAlpha = { "a", "b", "c", "d", "e", "f",
			"g", "h" };

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
		Map<Position, BoardPiece<ReversiEntity>> boardPieces = board
				.getBoardElements();

		for (int c = 0; c < columns; c++) {
			String currentColumn = columnAlpha[c];

			for (int r = 0; r < rows; r++) {
				Integer currentRow = r;
				Position position = new Position(currentColumn, currentRow);
				BoardPiece<ReversiEntity> boardPiece = new BoardPiece<ReversiEntity>(
						position);
				boardPieces.put(position, boardPiece);
			}
		}

		return board;
	}

}
