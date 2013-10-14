package reversi.server.display;

import java.util.Map;

import reversi.models.ReversiBoard;
import reversi.models.ReversiEntity;
import reversi.models.ReversiPlayer;
import base.models.BoardPiece;
import base.models.Position;

public class ReversiAsciiDisplayController {

	public static final String whiteReversiPiece = "O";
	public static final String blackReversiPiece = "@";
	public static final String boardPipe = "|";
	public static final String boardEmptySpace = "_";
	
	
	private static final String[] columnAlpha = { "a", "b", "c", "d", "e", "f",
			"g", "h" };

	public static String drawBoard(ReversiBoard board) {
		Map<Position, BoardPiece<ReversiEntity>> boardPieces = board
				.getBoardElements();

		StringBuilder builder = new StringBuilder();

		for (int c = 0; c < 8; c++) {

			String currentColumn = columnAlpha[c];

			builder.append(c);

			for (int r = 0; r < 8; r++) {

				builder.append(boardPipe);

				Integer currentRow = r;

				Position position = new Position(currentColumn, currentRow);

				BoardPiece<ReversiEntity> boardPiece = boardPieces
						.get(position);

				String representation = drawElement(boardPiece);

				builder.append(representation);
			}

		}

		String output = builder.toString();
		return output;
	}

	public static String drawElement(BoardPiece<ReversiEntity> piece) {
		String result = "";

		ReversiEntity reversiPiece = piece.getEntity();

		if (reversiPiece == null) {
			result = boardEmptySpace;
		} else {
			ReversiPlayer player = reversiPiece.getOwner();
			result = player.getAsciiDisplayPiece();
		}

		return result;
	}

}
