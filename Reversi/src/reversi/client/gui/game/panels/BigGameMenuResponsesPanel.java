package reversi.client.gui.game.panels;

import java.awt.Dimension;

import reversi.client.connection.ReversiClientConnection;

public class BigGameMenuResponsesPanel extends GameMenuResponsesPanel{

	private static final Dimension GAME_GUI_SIZE = new Dimension(600, 600);

	public BigGameMenuResponsesPanel(ReversiClientConnection connection) {
		super(connection);
	}

	@Override
	public Dimension getPreferredSize() {
		return GAME_GUI_SIZE;
	}

}
