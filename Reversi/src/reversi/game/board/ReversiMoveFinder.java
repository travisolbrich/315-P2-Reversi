package reversi.game.board;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import reversi.models.ReversiBoard;
import reversi.models.ReversiEntity;
import reversi.models.ReversiPlayer;
import base.models.Position;

/**
 * Finds moves on the board.
 * 
 * 
 * @author dereekb
 * 
 *         Available Positions algorithm derived from algorithm in reversi game
 *         at: http://mnemstudio.org/game-reversi-intro.htm
 */
public class ReversiMoveFinder {

	public static final Integer rowsCount = 8;
	public static final Integer columnsCount = 8;

	private final ReversiBoard board;
	private final ReversiPlayer player;

	public ReversiMoveFinder(ReversiBoard board, ReversiPlayer player) {
		this.board = board;
		this.player = player;
	}

	public Set<Position> findMoves() {
		Set<Position> possibleMoves = new HashSet<Position>();

		for (int c = 0; c < ReversiBoardReader.rowsCount; c++) {
			String currentColumn = Position.columnAlpha[c];

			for (int r = 0; r < ReversiBoardReader.columnsCount; r++) {
				Integer currentRow = r;

				Position currentPosition = new Position(currentColumn,
						currentRow);

				ReversiEntity entity = this.board
						.getEntityAtPosition(currentPosition);

				if (entity != null) {
					ReversiPlayer owner = entity.getOwner();

					if (owner == this.player) {

						List<Position> availableMoves = this
								.findMovesAtPosition(currentPosition);
						possibleMoves.addAll(availableMoves);
					}
				}
			}
		}

		return possibleMoves;
	}

	public List<Position> findMovesAtPosition(Position position) {
		List<Position> possibleMoves = new ArrayList<Position>();
		boolean foundMove = false;
		
		Integer opponentPieces = 0;
		List<Position> opponentPositions = new ArrayList<Position>();
		List<Position> edgePositions = ReversiBoardReader
				.positionsSurroundingPosition(position);

		for (Position edgePosition : edgePositions) {
			
			ReversiEntity entity = this.board.getEntityAtPosition(edgePosition);

			if (entity == null) // Empty
			{
				foundMove = true;
			} else {
				ReversiPlayer owner = entity.getOwner();

				if (owner != this.player) // Opponent
				{
					opponentPieces += 1;
					opponentPositions.add(edgePosition);
				}
			}

			if (foundMove == true && opponentPieces > 0) {
				boolean emptySpace = (entity == null);
				
				if (emptySpace) {	//An empty space makes this move valid
					possibleMoves.add(edgePosition);
				}
			}
		}
		
		return possibleMoves;
	}
}
