package reversi.client.gui.game.panels;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GameMenuPanel extends JPanel implements ActionListener {

	public static interface GameMenuPanelDelegate {
		public void remoteAiActionSent();

		public void difficultyActionSent();

		public void gameModeActionSent();
	}

	private static final Dimension GAME_GUI_SIZE = new Dimension(200, 700);

	private static final String whiteAction = "WHITE";
	private static final String blackAction = "BLACK";

	private static final String easyAction = "EASY";
	private static final String mediumAction = "MEDIUM";
	private static final String hardAction = "HARD";

	private static final String humanAiAction = "HUMAN-AI";
	private static final String remoteAiAiAction = "AI-AI";
	private static final String localAiAiAction = "LOCAL-AI";

	private JButton noActionButton;
	private JButton whiteActionButton;
	private JButton blackActionButton;

	private JButton easyActionButton;
	private JButton mediumActionButton;
	private JButton hardActionButton;

	private JButton humanAiActionButton;
	private JButton remoteAiActionButton;
	private JButton localAiActionButton;

	private GameMenuPanelDelegate delegate;
	private ActionListener forwardListener;

	public GameMenuPanel(ActionListener listener, GameMenuPanelDelegate delegate) {
		this.delegate = delegate;

		this.setLayout(new GridLayout(10, 1));
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
		this.add(whiteActionButton);
		this.blackActionButton = createButton("Select Black", blackAction);
		this.add(blackActionButton);

		this.easyActionButton = createButton("Easy", easyAction);
		this.add(easyActionButton);
		this.mediumActionButton = createButton("Medium", mediumAction);
		this.add(mediumActionButton);
		this.hardActionButton = createButton("Hard", hardAction);
		this.add(hardActionButton);

		this.noActionButton = createButton("", "");
		this.noActionButton.setEnabled(false);
		this.add(noActionButton);

		this.humanAiActionButton = createButton("Human AI", humanAiAction);
		this.add(humanAiActionButton);

		this.remoteAiActionButton = createButton("Remote AI", remoteAiAiAction);
		this.add(remoteAiActionButton);

		this.localAiActionButton = createButton("Local AI", localAiAiAction);
		this.add(localAiActionButton);

		this.whiteActionButton.addActionListener(this);
		this.blackActionButton.addActionListener(this);
		this.easyActionButton.addActionListener(this);
		this.mediumActionButton.addActionListener(this);
		this.hardActionButton.addActionListener(this);
		this.humanAiActionButton.addActionListener(this);
		this.remoteAiActionButton.addActionListener(this);
		this.localAiActionButton.addActionListener(this);
	}

	private void setListener(ActionListener listener) {
		this.forwardListener = listener;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == this.remoteAiActionButton) {
			this.delegate.remoteAiActionSent();
		} else {

			String action = e.getActionCommand();

			switch (action) {

			case easyAction:
			case mediumAction:
			case hardAction: {
				this.delegate.difficultyActionSent();
			}
				break;

			case humanAiAction:
			case localAiAiAction: {
				this.delegate.gameModeActionSent();
			}
				break;

			}

			this.forwardListener.actionPerformed(e);
		}
	}

	@Override
	public Dimension getPreferredSize() {
		return GAME_GUI_SIZE;
	}

}
