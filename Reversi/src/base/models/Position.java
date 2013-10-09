package base.models;

public final class Position {

	private final String column;
	private final Integer row;
	
	public Position(String column, Integer row)
	{
		this.column = column;
		this.row = row;
	}	

	public String getColumn() {
		return column;
	}
	
	public Integer getRow() {
		return row;
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
	public String toString()
	{
		String string = String.format("%s%d", this.column, this.row);
		return string;
	}
}
