package reversi.client.gui.game;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import reversi.client.connection.ReversiClientConnection;
import reversi.client.gui.game.panels.GameMenuResponsesPanel;

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
	private GameMenuResponsesPanel responseGui;
	
	public void setResponseGui(GameMenuResponsesPanel responseGui) {
		this.responseGui = responseGui;
	}

	public ReversiGameGUI() {
		this.menuActionHandler = new ReversiGameGUIActionHandler();
		
		this.setLayout(new BorderLayout());
		
		this.menuGui = new ReversiGameMenuGUI(menuActionHandler, this);
		this.add(menuGui, BorderLayout.WEST);
		
		this.playGui = new ReversiGamePlayGUI(menuActionHandler, responseGui, this);
		this.add(playGui, BorderLayout.CENTER);
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

	public void setClientConnection(ReversiClientConnection connection) {
		this.menuActionHandler.setClient(connection);
		this.setResponseGui(connection);
	}

	public GameMenuResponsesPanel getResponseGui() {
		return responseGui;
	}

	public void setResponseGui(ReversiClientConnection connection){
		this.responseGui = new GameMenuResponsesPanel(connection);
		this.add(responseGui, BorderLayout.EAST);
		this.responseGui.start();
		this.responseGui.setVisible(true);
	}
	
	public ReversiGameGUIActionHandler getMenuActionHandler() {
		return menuActionHandler;
	}
	
	@Override
	public Dimension getPreferredSize() {
		return GAME_GUI_SIZE;
	}

	public void startGame() {
		
		//TODO: Get the player's key.
		String playersPiece = "@";
		
		this.showGameMenu(false);
		this.playGui.play(playersPiece);
	}

}
