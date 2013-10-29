package reversi.client.game;

import java.util.ArrayList;
import java.util.List;

import base.models.Position;
import base.models.game.Turn;
import reversi.game.controller.ReversiBoardController;
import reversi.game.controller.ReversiTurnController;
import reversi.models.ReversiBoard;
import reversi.models.ReversiPlayer;
import reversi.models.game.ReversiInput;

/**
 * Tracks the state of a Reversi Game.
 * @author dereekb
 *
 */
public class ReversiClientGame {

	private final ReversiTurnController turnController;
	private final ReversiBoard board;
	private ReversiPlayer homePlayer;
	private ReversiPlayer remotePlayer;
	
	public ReversiClientGame() {
		ReversiBoardController boardController = new ReversiBoardController();
		this.turnController = new ReversiTurnController();
		this.board = boardController.generateNewBoard();
	}
	
	public void setUpBoard(String homePiece) {
		List<ReversiPlayer> activePlayers = new ArrayList<ReversiPlayer>();
		ReversiPlayer homePlayer = new ReversiPlayer("Home", homePiece);
		ReversiPlayer remotePlayer = new ReversiPlayer("Away");
		
		activePlayers.add(homePlayer);
		activePlayers.add(remotePlayer);
		
		board.setInitialPieces(activePlayers);
	}

	public void makeHomePlay(Position position) {
	
		Turn<ReversiPlayer, ReversiInput> turn = new Turn<ReversiPlayer, ReversiInput>(0);
		ReversiInput input = new ReversiInput(this.homePlayer, position);
		turn.addInput(input);
		turnController.processTurn(turn, board);
	}
	
	public void makeAwayPlay(Position position) {
		Turn<ReversiPlayer, ReversiInput> turn = new Turn<ReversiPlayer, ReversiInput>(0);
		ReversiInput input = new ReversiInput(this.homePlayer, position);
		turn.addInput(input);
		turnController.processTurn(turn, board);
	}
	
	public void undoPlay() {

		List<ReversiPlayer> activePlayers = new ArrayList<ReversiPlayer>();
		activePlayers.add(this.homePlayer);
		activePlayers.add(this.remotePlayer);
		
		turnController.undoTurn(activePlayers, this.board);
	}
	
	public void redoPlay() {

		List<ReversiPlayer> activePlayers = new ArrayList<ReversiPlayer>();
		activePlayers.add(this.homePlayer);
		activePlayers.add(this.remotePlayer);
		
		turnController.redoTurn(activePlayers, this.board);
	}
}
