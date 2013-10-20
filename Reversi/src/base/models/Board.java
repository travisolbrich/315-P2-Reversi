package base.models;

import java.util.HashMap;
import java.util.Map;

public class Board<E extends Entity> {

	protected final Map<Position, BoardPiece<E>> boardElements;

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
	
	public Board<E> cloneBoard() {
		Map<Position, BoardPiece<E>> piecesClone = this.cloneBoardPieces();
		Board<E> newBoard = new Board<E>(piecesClone);
		return newBoard;
	}
	
	public Map<Position, BoardPiece<E>> cloneBoardPieces() {
		Map<Position, BoardPiece<E>> piecesClone = new HashMap<Position, BoardPiece<E>>();
		
		for(BoardPiece<E> piece : this.boardElements.values())
		{
			BoardPiece<E> clone = piece.clonePiece();
			Position position = clone.getPosition();
			piecesClone.put(position, clone);
		}
		
		return piecesClone;
	}
}
