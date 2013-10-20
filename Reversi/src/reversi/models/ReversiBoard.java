package reversi.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import reversi.server.display.ReversiAsciiDisplayController;
import base.models.Board;
import base.models.BoardPiece;
import base.models.Position;

public class ReversiBoard extends Board<ReversiEntity> {

	public ReversiBoard() {
		super();
	}
	
	public ReversiBoard(Map<Position, BoardPiece<ReversiEntity>> pieces) {
		super(pieces);
	}

	public String getASCIIView()
	{
		return ReversiAsciiDisplayController.drawBoard(this);
	}

	public void setInitialPieces(List<ReversiPlayer> players) {
		
		final String whitePieceDisplay = ReversiAsciiDisplayController.whiteReversiPiece;
		
		ReversiPlayer human = players.get(0);
		ReversiPlayer ai = players.get(1);
		
		//Set four positions at the center of the board.
		ReversiPlayer whitePlayer = (human.getAsciiDisplayPiece().equals(whitePieceDisplay)) ? human : ai;
		ReversiPlayer blackPlayer = (human == whitePlayer) ? ai : human;

		this.createElementAtPositionForPlayer(new Position("d",4), whitePlayer);
		this.createElementAtPositionForPlayer(new Position("e",5), whitePlayer);
		this.createElementAtPositionForPlayer(new Position("d",5), blackPlayer);
		this.createElementAtPositionForPlayer(new Position("e",4), blackPlayer);
	}
	
	private void createElementAtPositionForPlayer(Position position, ReversiPlayer player)
	{
		ReversiEntity newPiece = new ReversiEntity(player, position);
		BoardPiece<ReversiEntity> boardPiece = this.getBoardPiece(position);
		boardPiece.setEntity(newPiece);
	}

	public ReversiBoard cloneBoard() 
	{
		Map<Position, BoardPiece<ReversiEntity>> elementsClone = this.cloneBoardPieces();
		ReversiBoard newBoard = new ReversiBoard(elementsClone);
		return newBoard;
	}

	public Map<ReversiPlayer, List<ReversiEntity>> getPlayerElementsMap(){
		Map<ReversiPlayer, List<ReversiEntity>> results = new HashMap<ReversiPlayer, List<ReversiEntity>>();

		for(BoardPiece<ReversiEntity> piece : this.boardElements.values())
		{
			ReversiEntity entity = piece.getEntity();
			
			if(entity != null) {
				ReversiPlayer owner = entity.getOwner();
				
				if(owner != null) {
					List<ReversiEntity> entityList = results.get(owner);
					
					if(entityList == null) {
						entityList = new ArrayList<ReversiEntity>();
						results.put(owner, entityList);
					}
					
					entityList.add(entity);
				}
			}
		}
		
		return results;
	}

	public Integer countElementsOwnedByPlayer(ReversiPlayer player){
		List<ReversiEntity> entities = this.getElementsOwnedByPlayer(player);
		return entities.size();
	}
	
	public List<ReversiEntity> getElementsOwnedByPlayer(ReversiPlayer player){
		List<ReversiEntity> entities = new ArrayList<ReversiEntity>();

		for(BoardPiece<ReversiEntity> piece : this.boardElements.values())
		{
			ReversiEntity entity = piece.getEntity();
			
			if(entity != null) {
				ReversiPlayer owner = entity.getOwner();
				boolean isOwner = (player.equals(owner));
				
				if(isOwner) {
					entities.add(entity);
				}
			}
		}
		
		return entities;
	}

	public Integer countElementsNotOwnedByPlayer(ReversiPlayer player){
		List<ReversiEntity> entities = this.getElementsNotOwnedByPlayer(player);
		return entities.size();
	}

	public List<ReversiEntity> getElementsNotOwnedByPlayer(ReversiPlayer player){
		List<ReversiEntity> entities = new ArrayList<ReversiEntity>();

		for(BoardPiece<ReversiEntity> piece : this.boardElements.values())
		{
			ReversiEntity entity = piece.getEntity();
			
			if(entity != null) {
				ReversiPlayer owner = entity.getOwner();
				boolean isOwner = (player.equals(owner));
				
				if(!isOwner) {
					entities.add(entity);
				}
			}
		}
		
		return entities;
	}
	
	public Set<ReversiPlayer> getOpponentsOfPlayerOnBoard(ReversiPlayer player){
		Set<ReversiPlayer> opponents = new HashSet<ReversiPlayer>();

		for(BoardPiece<ReversiEntity> piece : this.boardElements.values())
		{
			ReversiEntity entity = piece.getEntity();
			
			if(entity != null) {
				ReversiPlayer owner = entity.getOwner();
				boolean isOpponent = (player.equals(owner) == false);
				
				if(isOpponent) {
					opponents.add(owner);
				}
			}
		}
		
		return opponents;
	}
}
