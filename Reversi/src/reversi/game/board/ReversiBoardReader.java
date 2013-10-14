package reversi.game.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import base.models.Position;

public class ReversiBoardReader {

	public static final String[] columnAlpha = { "a", "b", "c", "d", "e", "f",
			"g", "h" };
	public static final Integer rowsCount = 8;
	public static final Integer columnsCount = 8;
	
	private static Map<String, Integer> columnIntegers = new HashMap<String, Integer>();

	static {
		// Fill column Integers
		for (int i = 0; i < 8; i++) {
			String column = columnAlpha[i];
			columnIntegers.put(column, i);
		}
	}

	public static enum RelativePosition {
		North(0, 1), NorthEast(-1, 1), East(1, 0), SouthEast(1, 1), South(0, -1), SouthWest(
				1, -1), West(-1, 0), NorthWest(-1, -1);

		private final Integer columnOffset;
		private final Integer rowOffset;

		private RelativePosition(Integer columnOffset, Integer rowOffset) {
			this.columnOffset = columnOffset;
			this.rowOffset = rowOffset;
		}

		public Integer getColumnOffset() {
			return columnOffset;
		}

		public Integer getRowOffset() {
			return rowOffset;
		}
	}

	public static Position relativePosition(Position position,
			RelativePosition change) {
		Position relativePosition = null;
		Integer row = position.getRow();
		row = row + change.getRowOffset();

		String positionColumn = position.getColumn();
		Integer column = columnIntegers.get(positionColumn);
		column = column + change.getColumnOffset();

		if ((row >= 0 && row < 8) && (column >= 0 && column < 8)) {
			String columnId = columnAlpha[column];
			relativePosition = new Position(columnId, row);
		}

		return relativePosition;
	}

	public static void addRelativePositionToList(Position position, RelativePosition change, List<Position> positions) {
		Position relativePosition = relativePosition(position, change);
		
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
