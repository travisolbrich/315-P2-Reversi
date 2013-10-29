package reversi.client.gui.game;

import javax.swing.JButton;
import javax.swing.JTextField;

import reversi.client.gui.game.panels.GameMenuResponsesPanel;

public class ReversiTextPlayGUI {

	private final ReversiGameGUIActionHandler actionHandler;
	private final ReversiGameGUI reversiGameGUI;
	
	private JTextField serverPort;
	private JButton startGameButton;
	
	public ReversiTextPlayGUI(ReversiGameGUIActionHandler actionHandler, GameMenuResponsesPanel responseGui, ReversiGameGUI reversiGameGUI) {
		this.actionHandler = actionHandler;
		this.reversiGameGUI = reversiGameGUI;
	}
	
}
