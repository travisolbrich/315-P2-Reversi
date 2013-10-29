package reversi.client.gui.game.panels;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GameMenuPanel extends JPanel{

	private static final String whiteAction = "WHITE";
	private static final String blackAction = "BLACK";

	private static final String easyAction = "EASY";
	private static final String mediumAction = "MEDIUM";
	private static final String hardAction = "HARD";
			
	private JButton noActionButton;
	private JButton whiteActionButton;
	private JButton blackActionButton;
	
	private JButton easyActionButton;
	private JButton mediumActionButton;
	private JButton hardActionButton;
	
	private JButton humanAiActionButton;
	private JButton remoteAiActionButton;
	
	public GameMenuPanel(ActionListener listener) {
		this.setLayout(new GridLayout(2, 3));
		
		this.buildMenu();
		this.setListener(listener);
	}

	private static JButton createButton(String title, String action) {
		JButton button = new JButton(title);
		button.setVerticalTextPosition(AbstractButton.CENTER);
		button.setHorizontalTextPosition(AbstractButton.LEADING);
		button.setMnemonic(KeyEvent.VK_D);
		button.setActionCommand(action);
		return button;
	}
	
	private void buildMenu() {
		this.whiteActionButton = createButton("Select White", whiteAction);
		this.blackActionButton = createButton("Select Black", blackAction);

		this.easyActionButton = createButton("Easy", easyAction);
		this.mediumActionButton = createButton("Medium", mediumAction);
		this.hardActionButton = createButton("Hard", hardAction);
	}

	private void setListener(ActionListener listener) {
		this.whiteActionButton.addActionListener(listener);
		this.blackActionButton.addActionListener(listener);
		this.easyActionButton.addActionListener(listener);
		this.mediumActionButton.addActionListener(listener);
		this.hardActionButton.addActionListener(listener);
	}
	
	
}
