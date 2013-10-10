package base.models;

import java.util.HashMap;
import java.util.Map;

public class Board<E extends Entity> {

	private final Map<Position, BoardPiece<E>> boardElements;

	public Board() {
		this.boardElements = new HashMap<Position, BoardPiece<E>>();
	}

	public Board(Map<Position, BoardPiece<E>> boardElements) {
		this.boardElements = boardElements;
	}

	public Map<Position, BoardPiece<E>> getBoardElements() {
		return boardElements;
	}

	public BoardPiece<E> getBoardPiece(Position position) {
		BoardPiece<E> boardPiece = boardElements.get(position);
		return boardPiece;
	}
	
	public E getEntityAtPosition(Position position) {
		BoardPiece<E> boardPiece = boardElements.get(position);
		E entity = boardPiece.getEntity();
		return entity;
	}
}
