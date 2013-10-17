package reversi.game.board;

import java.util.HashSet;
import java.util.Set;

import reversi.models.ReversiEntity;
import reversi.models.ReversiPlayer;
import base.models.Board;
import base.models.Position;

/**
 * Finds moves on the board.
 * 
 * 
 * @author travisolbrich
 * 
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
				Position currentPosition = new Position(currentColumn, currentRow);
				
				if(touchesOpponent(currentPosition) && this.board.getEntityAtPosition(currentPosition) == null) 
				{		
					if(blocksInEnemy(currentPosition)) {				
						possibleMoves.add(currentPosition);
					}
				}
			}
		}

		return possibleMoves;
	}

	// Determine if a given position will block in one or more enemy pieces
	public boolean blocksInEnemy(Position position) {
		
		for(int horizontal = -1; horizontal <=1; horizontal++)
		{
			for(int vertical = -1; vertical <=1; vertical++)
			{
				if(piecesBlockedIn(position, horizontal, vertical).size() > 0) return true;
			}
		}
		
		return false;
	}
	
	public Position traverse(Position position, int horizontal, int vertical)
	{
		// Ensure that we can move in the new direction
		int newColumn = position.getColumnInteger() + horizontal;
		int newRow = position.getRow() + vertical;
		
		if(newRow > 0 && newRow <= 8 && newColumn >= 0 && newColumn < 8) { 
			return new Position(newColumn, newRow);
		}
		
		return null;
	}
	
	/**
	 * Determine which pieces will be blocked in in a given vector
	 * 
	 * @param startingPosition The starting position
	 * @param horizontal Amount of positions to jump each cycle
	 * @param vertical Amount of positions to jump each cycle
	 * @return 
	 */
	public Set<Position> piecesBlockedIn(Position startingPosition, int horizontal, int vertical)
	{
		Set<Position> pieces = new HashSet<Position>();
		
		Position position = startingPosition;
		
		while(traverse(position, horizontal, vertical) != null) {
			position = traverse(position, horizontal, vertical);
			ReversiEntity entity = this.board.getEntityAtPosition(position);
			
			// If the entity is null, then no pieces are blocked
			if(entity == null) return new HashSet<Position>();
			
			// If the entity is player's, return pieces captured
			if(entity.getOwner() == this.player) return pieces;
			
			pieces.add(position);		
		}		
		
		return new HashSet<Position>();
	}
	
	/**
	 * Determine if a blank position touches a piece held by the opponent.
	 * 
	 * @param position
	 * @return true if at least one surrounding piece is owned by the opponent
	 */
	public boolean touchesOpponent(Position position)
	{
		for(int column = position.getColumnInteger() - 1; column <= position.getColumnInteger() + 1; column++) {
			for(int row = position.getRow() - 1; row <= position.getRow() + 1; row++) {
				
				// Derek is weird and made row start from 1 but column from 0
				if(row > 0 && row <= 8 && column >= 0 && column < 8) { 
					Position check = new Position(column, row);
					//System.out.println("touch check at " + check.toString());
					
					ReversiEntity entity = this.board.getEntityAtPosition(check);
					if (entity == null) continue;
					if (entity.getOwner() != this.player) return true;
				}
			}
		}
		
		return false;
	}
}
