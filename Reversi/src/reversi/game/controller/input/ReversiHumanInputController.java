package reversi.game.controller.input;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import reversi.models.ReversiPlayer;
import reversi.models.game.ReversiInput;
import reversi.parser.ReversiParser;
import reversi.server.commands.ReversiCommand;
import reversi.server.controllers.exceptions.ExitException;
import base.game.controllers.input.HumanInputController;
import base.models.Position;

/**
 * Input controller used for local games run through the Console.
 * 
 * @author dereekb
 * 
 */
public class ReversiHumanInputController implements
		HumanInputController<ReversiPlayer, ReversiInput> {

	private final ReversiParser parser = new ReversiParser();

	@Override
	public ReversiInput inputForHuman(ReversiPlayer human) {

		ReversiInput reversiInput = null;
		InputStream inputStream = human.getInputStream();
		Scanner scanner = new Scanner(inputStream);

		boolean validInput = false;

		while (validInput) {
			String input = scanner.nextLine();
			ReversiCommand command = parser.parseCommand(input);

			/*
			 * TODO This is the input controller to use for local games.
			 * 
			 * This input controller will recieve input from System.in and transform
			 * that into reversi input.
			 * 
			 * For handling a GUI, this class can be extended (Or another can just
			 * implement HumanInputController) to update the GUI and wait for a
			 * player to click.
			 */

			switch (command.getType()) {
				case Move: {
					
					List<String> parameters = command.getParameters();
					String column = parameters.get(0);
					String row = parameters.get(1);
					Integer rowInteger = new Integer(row);
					
					Position position = new Position(column, rowInteger);
					reversiInput = new ReversiInput(human, position);
					validInput = true;
				}
					break;
				case Exit: {
					throw new ExitException();
				}
				default: break;
			}
		}

		scanner.close();
		
		return reversiInput;
	}

}
