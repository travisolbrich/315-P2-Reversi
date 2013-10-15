package base.models;

import java.util.HashMap;
import java.util.Map;

public final class Position {
	
	public static final String[] columnAlpha = { "a", "b", "c", "d", "e", "f",
			"g", "h" };

	public static final Integer differenceColumn = 0;
	public static final Integer differenceRow = 1;
	
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

	private final String column;
	private final Integer row;

	public Position(Integer column, Integer row) {
		this.column = columnAlpha[column];
		this.row = row;
	}

	public Position(String column, Integer row) {
		this.column = column;
		this.row = row;
	}

	public String getColumn() {
		return column;
	}
	
	public Integer getColumnInteger() {
		Integer column = columnIntegers.get(this.column);
		return column;
	}

	public Integer getRow() {
		return row;
	}

	public boolean isWithinBounds() 
	{
		Integer column = this.getColumnInteger();
		Integer row = this.row;
		boolean inBounds = ((row > 0 && row <= 8) && (column >= 0 && column < 8));
		return inBounds;
	}
	
	public Integer[] difference(Position position) {
		Integer[] difference = { 0, 0 };

		Integer dcolumn = (this.getColumnInteger() - position.getColumnInteger());
		Integer drow = this.getRow() - position.getRow();

		difference[differenceColumn] = dcolumn;
		difference[differenceRow] = drow;
		return difference;
	}

	public Position positionWithDifference(Integer[] difference) {
		Integer column = this.getColumnInteger() + difference[differenceColumn];
		Integer row = this.getRow() + difference[differenceRow];
		
		Position position = new Position(column, row);
		return position;
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
		Integer row = position.getRow();
		row = row + change.getRowOffset();

		String positionColumn = position.getColumn();
		Integer column = columnIntegers.get(positionColumn);
		column = column + change.getColumnOffset();
		
		Position relativePosition = new Position(column, row);
		return relativePosition;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((column == null) ? 0 : column.hashCode());
		result = prime * result + ((row == null) ? 0 : row.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (column == null) {
			if (other.column != null)
				return false;
		} else if (!column.equals(other.column))
			return false;
		if (row == null) {
			if (other.row != null)
				return false;
		} else if (!row.equals(other.row))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String string = String.format("%s%d", this.column, this.row);
		return string;
	}
}
