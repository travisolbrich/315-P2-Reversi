package reversi.game.board;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
			ReversiEntity currentPiece = piece.getEntity();
			
			if(currentPiece != null)
			{
				ReversiPlayer player = currentPiece.getOwner();
				player.getGamePieces().remove(player);
			}
			
			ReversiEntity newPiece = new ReversiEntity(player, position);
			this.player.getGamePieces().add(newPiece);
			piece.setEntity(newPiece);
		}
		
		return changes;
	}

	public Set<Position> findChangesForPosition(Position play) {
		Set<Position> changes = new HashSet<Position>();

		List<Position> edgePositions = ReversiBoardReader
				.positionsSurroundingPosition(play);

		for (Position edgePosition : edgePositions) {

			List<Position> placeChanges = new ArrayList<Position>();
			Integer[] difference = play.difference(edgePosition);
			Position currentPosition = play;

			boolean foundChanges = false;
			while (true) {

				currentPosition = currentPosition.positionWithDifference(difference);

				if (currentPosition.isWithinBounds()) {
					ReversiEntity entity = this.board
							.getEntityAtPosition(edgePosition);

					if (entity == null) // Empty
					{
						foundChanges = true;
					} else {
						ReversiPlayer owner = entity.getOwner();

						if (owner != this.player) // Opponent
						{
							placeChanges.add(edgePosition);
						}
					}
				} else {
					break;
				}
			}

			if (foundChanges == true && placeChanges.size() > 0) {
				changes.add(edgePosition);
			}
		}

		return changes;
	}

}
