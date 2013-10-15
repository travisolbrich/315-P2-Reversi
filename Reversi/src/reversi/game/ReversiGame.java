package reversi.game;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import reversi.models.ReversiBoard;
import reversi.models.ReversiEntity;
import reversi.models.ReversiPlayer;
import reversi.models.game.ReversiInput;
import reversi.server.ReversiServerResponse;

import base.game.BoardGame;
import base.game.controllers.BoardController;
import base.game.controllers.ControllerSet;
import base.game.controllers.InputController;
import base.game.controllers.PlayerController;
import base.game.controllers.TurnController;
import base.game.messages.MessageHandler;
import base.models.game.Turn;

public class ReversiGame extends
		BoardGame<ReversiPlayer, ReversiEntity, ReversiInput, ReversiBoard> {

	public ReversiGame(
			ControllerSet<ReversiPlayer, ReversiEntity, ReversiInput, ReversiBoard> controllerSet) {
		super(controllerSet);
	}

	public Boolean playGame() throws IOException {
		Boolean gameSuccess = true;

		MessageHandler messageHandler = controllerSet.getMessageHandler();
		BoardController<ReversiBoard> boardController 
			= controllerSet.getBoardController();
		InputController<ReversiPlayer, ReversiInput, ReversiBoard> inputController 
			= controllerSet.getInputController();
		PlayerController<ReversiPlayer, ReversiEntity, ReversiBoard> playerController 
			= controllerSet.getPlayerController();
		TurnController<ReversiPlayer, ReversiEntity, ReversiInput> turnController 
			= controllerSet.getTurnController();

		ReversiBoard board = boardController.generateNewBoard();
		List<ReversiPlayer> players = playerController.getPlayers();
		ReversiPlayer humanPlayer = players.get(0);
		
		Integer playerCount = players.size();
		
		board.setInitialPieces(players);
		
		boolean hasWinner = false;
		Integer currentTurn = 0;
		
		while (hasWinner == false) {
			
			ReversiPlayer currentPlayer = players.get(currentTurn % playerCount);
			Integer turnId = (currentTurn += 1);
			
			playerController.updateScore(board);
			playerController.drawBoard(board);
			
			boolean success = false;
			while(!success)
			{
				ReversiInput input = inputController.getInputForPlayer(currentPlayer, board);				
				Turn<ReversiPlayer, ReversiInput> turn = new Turn<ReversiPlayer, ReversiInput>(turnId);
				turn.addInput(input);

				success = turnController.processTurn(turn, board);
				
				if(currentPlayer.isHuman())
				{
					if(success == false)
					{
						ReversiServerResponse.sendIllegal(currentPlayer);
					} else {
						ReversiServerResponse.sendOk(currentPlayer);
					}
				} else {
					ReversiServerResponse.sendComment(humanPlayer, input.toString());
				}
			}
		}

		playerController.drawFinalScore(board);

		return gameSuccess;
	}
}
