package reversi.client.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import reversi.client.connection.ReversiClientConnection;
import reversi.client.gui.game.ReversiGameGUI;


/**
 * Client GUI that shows the client menu.
 * @author dereekb
 *
 */
public class ReversiClientGUI extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private static final String ReversiWindowName = "Reversi";

	private static final Integer windowWidth = 1024;
	private static final Integer windowHeight = 768;
	private static final Integer textFieldWidth = 300;
	private static final Integer textFieldHeight = 40;
	private static final Integer buttonWidth = 300;
	private static final Integer buttonHeight = 120;
	
	private static final Dimension WINDOW_SIZE = new Dimension(windowWidth, windowHeight);

	private static final String ServerButtonAction = "s";
	private static final String PlayLocalGameButtonAction = "l";
	private static final String PlayRemoteGameButtonAction = "r";	
	
	private final ReversiGameGUI gameGui;
	private ReversiClientGUIDelegate delegate;

	private JPanel buttonPanel;
	private JButton startServerButton;
	private JButton playLocalGameButton;
	private JButton playRemoteGameButton;

	private JPanel inputPanel;
	private JTextField serverField;
	private JTextField portField;
	
	private JTextField messageOutput;
	private JTextField localServerPort;

	public ReversiClientGUI(ReversiClientGUIDelegate delegate) {
		super(ReversiWindowName);
		this.delegate = delegate;

		this.gameGui = new ReversiGameGUI();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(0, 0, windowWidth, windowHeight);
        this.buildMainMenu();
	}

	private void buildMainMenu() {
		
		messageOutput = new JTextField();
		messageOutput.setBounds(0, windowHeight, windowWidth, textFieldHeight);
		this.add(messageOutput, BorderLayout.SOUTH);

		this.buttonPanel = new JPanel();
		this.buttonPanel.setLayout(new GridLayout(3, 1));
		
		startServerButton = new JButton("Start Server");
		startServerButton.setVerticalTextPosition(AbstractButton.CENTER);
		startServerButton.setHorizontalTextPosition(AbstractButton.LEADING);
		startServerButton.setMnemonic(KeyEvent.VK_D);
		startServerButton.setActionCommand(ServerButtonAction);
		
		startServerButton.addActionListener(this);
		this.buttonPanel.add(startServerButton);

		playLocalGameButton = new JButton("Play Local");
		playLocalGameButton.setVerticalTextPosition(AbstractButton.CENTER);
		playLocalGameButton.setHorizontalTextPosition(AbstractButton.LEADING);
		playLocalGameButton.setMnemonic(KeyEvent.VK_D);
		playLocalGameButton.setActionCommand(PlayLocalGameButtonAction);
		playLocalGameButton.setEnabled(false);
		
		playLocalGameButton.addActionListener(this);
		this.buttonPanel.add(playLocalGameButton);
		
		playRemoteGameButton = new JButton("Play Remote");
		playRemoteGameButton.setVerticalTextPosition(AbstractButton.CENTER);
		playRemoteGameButton.setHorizontalTextPosition(AbstractButton.LEADING);
		playRemoteGameButton.setMnemonic(KeyEvent.VK_D);
		playRemoteGameButton.setActionCommand(PlayRemoteGameButtonAction);
		
		playRemoteGameButton.addActionListener(this);
		
		this.buttonPanel.add(playRemoteGameButton);		
		this.add(buttonPanel, BorderLayout.WEST);
		
		this.inputPanel = new JPanel();
		this.inputPanel.setLayout(new GridLayout(3, 3));

		inputPanel.add(new JLabel("Local Server Port"));		
		this.localServerPort = new JTextField("1400");
		inputPanel.add(localServerPort);
		
		inputPanel.add(new JLabel("Server Address"));		
		this.serverField = new JTextField("");
		inputPanel.add(serverField);

		inputPanel.add(new JLabel("Port Number"));
		this.portField = new JTextField("");
		inputPanel.add(portField);
		this.add(inputPanel, BorderLayout.NORTH);

		this.add(this.gameGui, BorderLayout.CENTER);
		this.gameGui.setVisible(false);
	}

	public void setMenuItemsVisible (boolean visible) {
		this.buttonPanel.setVisible(visible);
		this.inputPanel.setVisible(visible);
	}
	
	public void setClientConnection(ReversiClientConnection connection) {
		this.gameGui.setClientConnection(connection);
	}
	
	public void showGameGUI(boolean show) {
		if(show) {
			this.setMenuItemsVisible(false);
			this.gameGui.showGameMenu(true);
			this.gameGui.setVisible(true);
		} else {
			this.setMenuItemsVisible(true);
			this.gameGui.setVisible(false);
		}
	}

	public void enableStartServerButton (boolean enabled) {
		this.startServerButton.setEnabled(enabled);
		this.playLocalGameButton.setEnabled(!enabled);
	}

	public void displayMessage(String message) {
		this.messageOutput.setText(message);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String actionCommand = e.getActionCommand();
		
		switch (actionCommand) {
			case ServerButtonAction: {

				String localPortField = this.localServerPort.getText();
				
				try{
					Integer port = new Integer(localPortField);
					this.delegate.startServer(port);
				} catch (NumberFormatException n) {
					this.displayMessage("Bad input for local server port. Must be a number between 1-65565");
				}
				
			} break;
			case PlayLocalGameButtonAction: {
				this.delegate.playLocal();
			} break;
			case PlayRemoteGameButtonAction: {
								
				String addressFieldText = this.serverField.getText();
				String portFieldText = this.portField.getText();
				
				this.delegate.playRemote(addressFieldText, portFieldText);
			} break;				
		}
	}
	
	@Override
	public Dimension getPreferredSize() {
		return WINDOW_SIZE;
	}
}
