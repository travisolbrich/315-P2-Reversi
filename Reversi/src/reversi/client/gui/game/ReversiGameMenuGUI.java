package reversi.client.gui.game;

import javax.swing.JPanel;

import reversi.client.gui.game.panels.GameMenuPanel;
import reversi.client.gui.game.panels.GameRemoteAIPanel;

public class ReversiGameMenuGUI extends JPanel{

	private final ReversiGameGUIActionHandler actionHandler;

	private final GameMenuPanel buttonPanel;
	private final GameRemoteAIPanel remoteAIPanel;

	public ReversiGameMenuGUI(ReversiGameGUIActionHandler menuActionHandler) {
		this.actionHandler = menuActionHandler;
		this.buttonPanel = new GameMenuPanel(menuActionHandler);
		this.remoteAIPanel = new GameRemoteAIPanel(menuActionHandler);
	}

	private void buildMenu() {
		
	}

}
