package reversi.client.gui.game;

import java.awt.Dimension;

import javax.swing.JPanel;

import reversi.client.connection.ReveriClientConnection;

/**
 * The Game's GUI
 * 
 * @author dereekb
 * 
 */
public class ReversiGameGUI extends JPanel {
	 
	private static final long serialVersionUID = 1L;

	private static final Dimension GAME_GUI_SIZE = new Dimension(1024, 700);

	private final ReversiGameGUIActionHandler menuActionHandler;
	private final ReversiGameMenuGUI menuGui;
	private final ReversiGamePlayGUI playGui;
	
	public ReversiGameGUI() {
		this.menuActionHandler = new ReversiGameGUIActionHandler();
		this.menuGui = new ReversiGameMenuGUI(menuActionHandler);
		this.playGui = new ReversiGamePlayGUI(menuActionHandler);
	}

	public void showGamePlayScreen(boolean show) {
		this.showGameMenu(!show);
	}

	public void showGameMenu(boolean showMenu) {
		if (showMenu) {
			this.menuGui.setVisible(true);
			this.playGui.setVisible(false);
		} else {
			this.playGui.setVisible(true);
			this.menuGui.setVisible(false);
		}
	}

	public void setClientConnection(ReveriClientConnection connection) {
		this.menuActionHandler.setClient(connection);
	}
	
	public ReversiGameGUIActionHandler getMenuActionHandler() {
		return menuActionHandler;
	}
	
	@Override
	public Dimension getPreferredSize() {
		return GAME_GUI_SIZE;
	}

}
