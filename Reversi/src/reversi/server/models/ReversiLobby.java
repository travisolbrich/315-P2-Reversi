package reversi.server.models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import reversi.game.ReversiGame;
import reversi.models.ReversiBoard;
import reversi.models.ReversiPlayer;
import reversi.parser.ReversiParser;
import reversi.server.ReversiGameFactory;
import reversi.server.ReversiServerResponse;
import reversi.server.commands.ReversiCommand;
import reversi.server.commands.ReversiCommand.ReversiCommandType;
import reversi.server.controllers.exceptions.ExitException;
import reversi.server.display.ReversiAsciiDisplayController;
import reversi.server.models.ReversiSettings.GameMode;
import base.server.GameLobby;
import base.server.ServerLobbyManager;

/**
 * Lobby for Reversi.
 * 
 * Will wait until two players connect, or the first player decides to play
 * against a single player.
 * 
 * @author dereekb
 * 
 */
public class ReversiLobby extends GameLobby<ReversiRemoteClient> {

	private static final Integer easyDifficulty = 1;
	private static final Integer mediumDifficulty = 2;
	private static final Integer hardDifficulty = 3;
	private static final Integer impossibleDifficulty = 4;

	private ReversiRemoteClient host;

	private final ReversiGameFactory gameFactory = new ReversiGameFactory();
	private final ReversiSettings settings = new ReversiSettings();

	private boolean selectedDifficulty = false;
	private boolean selectedGameMode = false;

	public ReversiLobby(ReversiRemoteClient host, ServerLobbyManager<?, ?, ?> manager) throws IOException {
		super(manager);
		this.setHost(host);
		this.getClients().add(host);

		ReversiServerResponse.sendWelcome(host);
	}

	public ReversiLobby(ReversiRemoteClient host, ServerLobbyManager<?, ?, ?> manager, String lobbyName)
			throws IOException {
		super(manager, lobbyName);
		this.setHost(host);
		this.getClients().add(host);

		ReversiServerResponse.sendWelcome(host);
	}

	@Override
	public void runLobby() throws IOException {

		boolean beginGame = false;

		ReversiParser parser = new ReversiParser();
		Scanner scanner = host.getInputScanner();

		while (getClients().size() > 0 && !beginGame) {

			boolean success = true;

			try {

				String input = scanner.nextLine();
				ReversiCommand command = parser.parseCommand(input);

				if (command != null) {
					success = this.processCommand(command);
				} else {
					success = false;
				}

			} finally {
				if (success) {
					ReversiServerResponse.sendOk(host);
				} else {
					ReversiServerResponse.sendIllegal(host);
				}

				beginGame = this.canBeginGame();
			}
		}
	}

	private boolean canBeginGame() {
		return (this.selectedDifficulty && this.selectedGameMode);
	}

	public boolean processCommand(ReversiCommand command) {
		boolean success = true;
		ReversiCommandType type = command.getType();

		switch (type) {
		case Easy: {
			this.settings.setAiDifficulty(easyDifficulty);
			this.settings.setAiDifficultySecondary(easyDifficulty);
			this.selectedDifficulty = true;
		}
			break;
		case Medium: {
			this.settings.setAiDifficulty(mediumDifficulty);
			this.settings.setAiDifficultySecondary(mediumDifficulty);
			this.selectedDifficulty = true;
		}
			break;
		case Hard: {
			this.settings.setAiDifficulty(hardDifficulty);
			this.settings.setAiDifficultySecondary(hardDifficulty);
			this.selectedDifficulty = true;
		}
		case Impossible: {
			this.settings.setAiDifficulty(impossibleDifficulty);
			this.settings.setAiDifficultySecondary(impossibleDifficulty);
			this.selectedDifficulty = true;
		}
			break;
		case Display: {
			ReversiPlayer hostPlayer = this.host.getPlayer();
			hostPlayer.toggleAsciiDisplay();
		}
			break;
		case Exit: {
			throw new ExitException(this.host);
		}
		case HumanAI: {
			ReversiPlayer hostPlayer = this.host.getPlayer();
			hostPlayer.setPlaying(true);
			this.settings.setGameMode(GameMode.HumanAi);
			this.selectedGameMode = true;
		}
			break;
		case AIAI: {
			ReversiPlayer hostPlayer = this.host.getPlayer();
			hostPlayer.setPlaying(false);

			/*
			 * // TODO: AI-AI playing List<String> parameters =
			 * command.getParameters(); String address = parameters.get(0);
			 * String port = parameters.get(1); String thisDifficulty =
			 * parameters.get(2); String theirDifficulty = parameters.get(3);
			 */

			this.settings.setGameMode(GameMode.AIAIRemote);
			this.selectedGameMode = true;
			this.selectedDifficulty = true;
		}
			break;
		case AILOCAL: {
			ReversiPlayer hostPlayer = this.host.getPlayer();
			hostPlayer.setPlaying(false);

			this.settings.setGameMode(GameMode.AIAILocal);
			this.selectedGameMode = true;
			this.selectedDifficulty = true;
		}
			break;
		case Black: {
			this.host.setAsciiPiece(ReversiAsciiDisplayController.blackReversiPiece);
		}
			break;
		case White: {
			this.host.setAsciiPiece(ReversiAsciiDisplayController.whiteReversiPiece);
		}
			break;
		default: {
			success = false;
		}
			break;
		}

		return success;
	}

	@Override
	public void runGame() throws IOException {

		List<ReversiPlayer> players = new ArrayList<ReversiPlayer>();

		for (ReversiRemoteClient client : this.clients) {
			String asciiPiece = client.getAsciiPiece();
			ReversiPlayer player = client.getPlayer();

			if (player == null) {
				player = new ReversiPlayer(asciiPiece, client.getSocket());
				player.setAsciiPiece(asciiPiece);
				client.setPlayer(player);
			}

			player.setControlledByAi(false);
			players.add(player);
		}

		this.settings.setPlayers(players);
		ReversiGame game = this.gameFactory.createNewGame(this.settings);
		game.playGame();
	}

	public void runGameEnded() throws IOException {

		// TODO: Maybe mention they are back in the lobby, or that the settings
		// have been reset.

		this.selectedGameMode = false;
		this.selectedDifficulty = false;
	}

	@Override
	public void closeLobby() throws IOException {
		super.closeLobby();
	}

	public ReversiRemoteClient getHost() {
		return host;
	}

	public void setHost(ReversiRemoteClient host) throws IOException {
		this.host = host;
		host.setAsciiPiece(ReversiBoard.blackReversiPiece);

		ReversiPlayer hostPlayer = new ReversiPlayer("Host", "?", host.getSocket());
		this.host.setPlayer(hostPlayer);
	}

}
