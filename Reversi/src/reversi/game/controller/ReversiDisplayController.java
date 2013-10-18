package reversi.game.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import reversi.models.ReversiBoard;
import reversi.models.ReversiPlayer;
import reversi.server.display.ReversiAsciiDisplayController;

public class ReversiDisplayController {

	/**
	 * If there is an AI player, they will automatically echo unless they are set to display none.
	 */
	private boolean drawToSystem = false;

	public ReversiDisplayController() {
	}

	public ReversiDisplayController(boolean drawToSystem) {
		this.drawToSystem = drawToSystem;
	}

	public List<ReversiPlayer> getAsciiViewingPlayers(List<ReversiPlayer> players) {
		List<ReversiPlayer> observers = new ArrayList<ReversiPlayer>();

		for (ReversiPlayer player : players) {
			if (player.isHuman() && player.showAsciiDisplay()) {
				observers.add(player);
			}
		}

		return observers;
	}

	public void drawBoard(ReversiBoard board, List<ReversiPlayer> players) throws IOException {
		String boardDisplay = ReversiAsciiDisplayController.drawBoard(board);

		List<ReversiPlayer> playersWithAsciiDisplay = this.getAsciiViewingPlayers(players);
		for (ReversiPlayer observer : playersWithAsciiDisplay) {
			PrintWriter writer = observer.getWriter();
			writer.println(boardDisplay);
		}

		if (this.drawToSystem) {
			System.out.println(boardDisplay);
		}
	}

	public boolean isDrawToSystem() {
		return drawToSystem;
	}

	public void setDrawToSystem(boolean drawToSystem) {
		this.drawToSystem = drawToSystem;
	}
}
