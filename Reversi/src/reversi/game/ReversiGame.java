package reversi.game;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import reversi.game.board.ReversiMoveFinder;
import reversi.game.controller.ReversiBoardController;
import reversi.game.controller.ReversiControllerSet;
import reversi.game.controller.ReversiDisplayController;
import reversi.game.controller.ReversiInputController;
import reversi.game.controller.ReversiPlayerController;
import reversi.game.controller.ReversiTurnController;
import reversi.models.ReversiBoard;
import reversi.models.ReversiPlayer;
import reversi.models.game.ReversiInput;
import reversi.server.ReversiServerResponse;
import reversi.server.commands.ReversiCommand.ReversiCommandType;
import base.game.messages.MessageHandler;
import base.models.Position;
import base.models.game.Turn;

public class ReversiGame {

	protected final ReversiControllerSet controllerSet;

	public ReversiGame(ReversiControllerSet controllerSet) {
		this.controllerSet = controllerSet;
	}

	public Boolean playGame() throws IOException {
		Boolean gameSuccess = true;

		MessageHandler messageHandler = controllerSet.getMessageHandler();
		ReversiBoardController boardController = controllerSet.getBoardController();
		ReversiInputController inputController = controllerSet.getInputController();
		ReversiPlayerController playerController = controllerSet.getPlayerController();
		ReversiTurnController turnController = controllerSet.getTurnController();
		ReversiDisplayController displayController = controllerSet.getDisplayController();

		ReversiBoard board = boardController.generateNewBoard();
		List<ReversiPlayer> players = playerController.getPlayers();
		ReversiPlayer humanPlayer = players.get(0);

		Integer playerCount = players.size();

		board.setInitialPieces(players);

		boolean hasWinner = false;
		Integer currentTurn = 0;

		while (hasWinner == false) {

			ReversiPlayer currentPlayer = players
					.get(currentTurn % playerCount);
			ReversiPlayer nextPlayer = players.get((currentTurn + 1)
					% playerCount);
			Integer turnId = (currentTurn += 1);

			playerController.updateScore(board);
			displayController.drawBoard(board, players);

			boolean success = false;
			while (!success) {
				ReversiMoveFinder finder = new ReversiMoveFinder(board, humanPlayer);
				Set<Position> allowed = finder.findMoves();
				
				System.out.print("Allowed to play at [" + allowed.size() +"] ");
				
				for (Position position : allowed) {
					System.out.print(position.getColumn() + position.getRow() + ", ");
				}
				
				System.out.println();
				System.out.println("Current player is " + currentPlayer.getName());
				
				ReversiInput input = inputController.getInputForPlayer(	currentPlayer, board);
				

				// Process Undo/Redo commands here.
				if (input.isCommand()) {
					ReversiCommandType type = input.getCommand().getType();

					switch (type) {
					case Undo: {
						success = turnController.undoTurn(players, board);
					}
						break;
					case Redo: {
						success = turnController.redoTurn(players, board);
					}
						break;
					default: {
						success = false;
					}
						break;
					}
				} else {					
					
					// Process turns from here.
					Turn<ReversiPlayer, ReversiInput> turn = new Turn<ReversiPlayer, ReversiInput>(
							turnId);
					turn.addInput(input);
					success = turnController.processTurn(turn, board);
				}

				if (currentPlayer.isHuman()) {
					if (success == false) {
						ReversiServerResponse.sendIllegal(currentPlayer);
					} else {
						ReversiServerResponse.sendOk(currentPlayer);
					}
				} else {
					ReversiServerResponse.sendComment(humanPlayer,
							input.toString());
				}
			}

			hasWinner = (turnController.playerCanMakePlay(nextPlayer, board) == false);
		}

		ReversiPlayer winner = playerController.determineWinner(board);
		humanPlayer.getWriter().println(winner + " wins!");

		return gameSuccess;
	}
}
