package reversi.game.board;

import java.util.ArrayList;
import java.util.List;

import base.models.Position;
import base.models.Position.RelativePosition;

public class ReversiBoardReader {

	public static final Integer rowsCount = 8;
	public static final Integer columnsCount = 8;

	public static void addRelativePositionToList(Position position, RelativePosition change, List<Position> positions) {
		Position relativePosition = Position.relativePosition(position, change);
		
		if(relativePosition != null)
		{
			positions.add(relativePosition);
		}
	}
	
	public static List<Position> positionsSurroundingPosition(Position position)
	{
		List<Position> positions = new ArrayList<Position>();

		addRelativePositionToList(position, RelativePosition.North, positions);
		addRelativePositionToList(position, RelativePosition.NorthEast, positions);
		addRelativePositionToList(position, RelativePosition.East, positions);
		addRelativePositionToList(position, RelativePosition.SouthEast, positions);
		addRelativePositionToList(position, RelativePosition.South, positions);
		addRelativePositionToList(position, RelativePosition.SouthWest, positions);
		addRelativePositionToList(position, RelativePosition.West, positions);
		addRelativePositionToList(position, RelativePosition.NorthWest, positions);
		
		return positions;
	}
}
