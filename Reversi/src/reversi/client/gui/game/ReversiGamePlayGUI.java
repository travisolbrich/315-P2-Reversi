package reversi.client.gui.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JPanel;

import base.models.Position;
import reversi.client.game.ReversiClientGame;
import reversi.client.gui.game.panels.GameMenuResponsesPanel;
import reversi.parser.ReversiParser;
import reversi.server.commands.ReversiCommand;

public class ReversiGamePlayGUI extends JPanel implements ActionListener{	
	
	private final ReversiGameGUIActionHandler actionHandler;
	private final ReversiGameGUI reversiGameGUI;
	private final GameMenuResponsesPanel responseGui;
	private final ReversiClientGame game;

	private boolean awaitingResponse = false;
	private ReversiCommand currentCommand = null;
	
	public ReversiGamePlayGUI(ReversiGameGUIActionHandler actionHandler, GameMenuResponsesPanel responseGui, ReversiGameGUI reversiGameGUI) {
		this.actionHandler = actionHandler;
		this.reversiGameGUI = reversiGameGUI;
		this.responseGui = responseGui;
		this.game = new ReversiClientGame();
	}

	public void play(String homePiece) {	
		this.game.setUpBoard(homePiece);
		this.responseGui.addListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String command = e.getActionCommand();
		ReversiParser parser = new ReversiParser();
		ReversiCommand parsedCommand = parser.parseCommand(command);

		//Action performed is an undo, redo, exit, or a move.
		//Allow only one request at a time.
		if(awaitingResponse == false) {
			switch (parsedCommand.getType()) {
				case Exit: 
				case Move:
				case Redo:
				case Undo: {
					this.awaitingResponse = true;
					this.currentCommand = parsedCommand;
					this.actionHandler.sendCommand(command);
				} break;
				default: break;
			}
		}
	}
	
	public void receivedResponse(String response) {

		ReversiParser parser = new ReversiParser();
		ReversiCommand parsedCommand = parser.parseCommand(response);

		switch (parsedCommand.getType()) {
			case Ok: {

				if(this.awaitingResponse) {
					this.awaitingResponse = false;

					boolean isOk = response.equals("OK");
					if(isOk) {
						switch (this.currentCommand.getType()) {
							case Exit: {
								
							} break;
							case Move: {
								List<String> parameters = parsedCommand.getParameters();
								String column = parameters.get(0);
								String row = parameters.get(1);
								
								Integer rowInteger = new Integer(row);
								Position position = new Position(column, rowInteger);
								
								this.game.makeHomePlay(position);
								this.awaitingResponse = true;	//Waiting for the opposing player's response.
							} break;
							case Redo:{
								this.game.redoPlay();
							} break;
							case Undo: {
								this.game.undoPlay();
							} break;
							default: break;
						}
					}
				}
			} break;
			case Move: {
				//Enemy Move.
				
				List<String> parameters = parsedCommand.getParameters();
				String column = parameters.get(0);
				String row = parameters.get(1);
				
				Integer rowInteger = new Integer(row);
				Position position = new Position(column, rowInteger);
				
				this.game.makeAwayPlay(position);
				
			}
			default: break;
		}
	}
}
