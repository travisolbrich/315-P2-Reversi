package reversi.game.board;

import java.util.HashSet;
import java.util.Set;

import reversi.models.ReversiEntity;
import reversi.models.ReversiPlayer;
import base.models.Board;
import base.models.BoardPiece;
import base.models.Position;

/**
 * Alters the board with a given move.
 * 
 * @author dereekb
 * 
 */
public class ReversiMoveMaker {

	public static final Integer rowsCount = 8;
	public static final Integer columnsCount = 8;

	private final Board<ReversiEntity> board;
	private final ReversiPlayer player;

	public ReversiMoveMaker(Board<ReversiEntity> board, ReversiPlayer player) {
		this.board = board;
		this.player = player;
	}

	public Set<Position> playAtPosition(Position play) {
		Set<Position> changes = this.findChangesForPosition(play);
		
		for (Position position : changes)
		{
			BoardPiece<ReversiEntity> piece = this.board.getBoardPiece(position);
			ReversiEntity newPiece = new ReversiEntity(player, position);
			piece.setEntity(newPiece);
		}
		
		return changes;
	}

	public Set<Position> findChangesForPosition(Position play) {
		Set<Position> changes = new HashSet<Position>();
		ReversiMoveFinder finder = new ReversiMoveFinder(this.board, this.player);

		changes.add(play);
		
		for(int horizontal = -1; horizontal <=1; horizontal++)
		{
			for(int vertical = -1; vertical <=1; vertical++)
			{
				changes.addAll(finder.piecesBlockedIn(play, horizontal, vertical));
			}
		}		

		return changes;
	}

}
