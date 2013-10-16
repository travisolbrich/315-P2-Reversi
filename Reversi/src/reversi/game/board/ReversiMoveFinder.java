package reversi.game.board;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import reversi.models.ReversiEntity;
import reversi.models.ReversiPlayer;
import base.models.Board;
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

	private final Board<ReversiEntity> board;
	private final ReversiPlayer player;

	public ReversiMoveFinder(Board<ReversiEntity> board, ReversiPlayer player) {
		this.board = board;
		this.player = player;
	}

	public Set<Position> findMoves() {
		Set<Position> possibleMoves = new HashSet<Position>();

		for (int c = 0; c < ReversiBoardReader.rowsCount; c += 1) {
			String currentColumn = Position.columnAlpha[c];

			for (int r = 1; r <= ReversiBoardReader.columnsCount; r += 1) {
				Integer currentRow = r;

				Position currentPosition = new Position(currentColumn,
						currentRow);

				if(touchesOpponent(currentPosition) && this.board.getEntityAtPosition(currentPosition) == null) {
					System.out.println(currentPosition.getColumn() + currentPosition.getRow() + " touches opponent. I am " + this.player.getAsciiDisplayPiece() +".");
				}
			}
		}

		return possibleMoves;
	}

	public List<Position> findMovesAtPosition(Position position) {
		List<Position> possibleMoves = new ArrayList<Position>();
		

		return possibleMoves;
	}
	
	/**
	 * Determine if a blank position touches a piece held by the opponent.
	 * 
	 * @param position
	 * @return true if at least one surrounding piece is owned by the opponent
	 */
	public boolean touchesOpponent(Position position)
	{
		for(int column = position.getColumnInteger() - 1; column < position.getColumnInteger() + 1; column++) {
			for(int row = position.getRow() - 1; row < position.getRow() + 1; row++) {
				
				// Derek is weird and made row start from 1 but column from 0
				if(row > 0 && row <= 8 && column >= 0 && column < 8) { 
					ReversiEntity entity = this.board.getEntityAtPosition(new Position(column, row));
					if (entity == null) continue;
					if (entity.getOwner() != this.player) return true;
				}
			}
		}
		
		return false;
	}
}
