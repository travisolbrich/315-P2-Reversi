package reversi.client.gui.game.panels;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import reversi.client.gui.game.ReversiGameGUIActionHandler;
import reversi.client.gui.game.panels.GameMenuPanel.GameMenuPanelDelegate;

public class GameRemoteAIPanel extends JPanel implements ActionListener{
	
	private static final Dimension GAME_GUI_SIZE = new Dimension(200, 700);

	private JTextField localDifficulty;	
	private JTextField remoteDifficulty;
	private JTextField serverAddress;	
	private JTextField serverPort;
	
	private JButton startGameButton;
	private ActionListener forwardListener;
	
	public GameRemoteAIPanel(ReversiGameGUIActionHandler menuActionHandler) {
		this.setLayout(new GridLayout(10, 1));
		this.buildMenu();
		this.setListener(menuActionHandler);
	}

	private void buildMenu() {

	    this.add(new JLabel("Local Difficulty"));		
		this.localDifficulty = new JTextField("");
		this.add(localDifficulty);

	    this.add(new JLabel("Remote Difficulty"));		
		this.remoteDifficulty = new JTextField("");
		this.add(remoteDifficulty);

	    this.add(new JLabel("Server Address"));		
		this.serverAddress = new JTextField("");
		this.add(serverAddress);
		
	    this.add(new JLabel("Port Number"));		
		this.serverPort = new JTextField("");
		this.add(serverPort);

		JButton button = new JButton("Start Remote Game");
		button.setVerticalTextPosition(AbstractButton.CENTER);
		button.setHorizontalTextPosition(AbstractButton.LEADING);
		button.setMnemonic(KeyEvent.VK_D);
		button.addActionListener(this);
		
		this.startGameButton = button;
		this.add(startGameButton);
	}

	private void setListener(ActionListener listener) {
		this.forwardListener = listener;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		String localDifficulty = this.localDifficulty.getText();
		String remoteDifficulty = this.remoteDifficulty.getText();
		String serverAddress = this.serverAddress.getText();
		String serverPort = this.serverPort.getText();
		
		String request = String.format("%@ %@ %@ %@", localDifficulty, remoteDifficulty, serverAddress, serverPort);
		ActionEvent event = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, request);
		this.forwardListener.actionPerformed(event);
	}

	@Override
	public Dimension getPreferredSize() {
		return GAME_GUI_SIZE;
	}

}
