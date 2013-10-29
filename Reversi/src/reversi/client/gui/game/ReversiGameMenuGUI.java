package reversi.client.gui.game;

import javax.swing.JPanel;

import reversi.client.gui.game.panels.GameMenuPanel;
import reversi.client.gui.game.panels.GameMenuPanel.GameMenuPanelDelegate;
import reversi.client.gui.game.panels.GameRemoteAIPanel;

public class ReversiGameMenuGUI extends JPanel implements GameMenuPanelDelegate{

	private final ReversiGameGUIActionHandler actionHandler;

	private final GameMenuPanel buttonPanel;
	private final GameRemoteAIPanel remoteAIPanel;
	private final ReversiGameGUI reversiGameGUI;
	
	private boolean selectedDifficulty = false;
	private boolean selectedGameMode = false;

	public ReversiGameMenuGUI(ReversiGameGUIActionHandler menuActionHandler, ReversiGameGUI reversiGameGUI) {
		this.actionHandler = menuActionHandler;
		this.reversiGameGUI = reversiGameGUI;
		
		this.buttonPanel = new GameMenuPanel(menuActionHandler, this);
		this.add(buttonPanel);
		
		this.remoteAIPanel = new GameRemoteAIPanel(menuActionHandler);
		this.add(remoteAIPanel);
		this.remoteAIPanel.setVisible(false);
	}

	@Override
	public void remoteAiActionSent() {
		boolean show = this.remoteAIPanel.isVisible();
		this.remoteAIPanel.setVisible(!show);
	}

	public ReversiGameGUIActionHandler getActionHandler() {
		return actionHandler;
	}

	@Override
	public void difficultyActionSent() {
		this.selectedDifficulty = true;
	}

	@Override
	public void gameModeActionSent() {
		this.selectedGameMode = true;
	}
	
	private void checkGameReadiness() {
		
		if(this.selectedDifficulty && this.selectedGameMode) {
			this.reversiGameGUI.startGame();
		}
		
	}
}
