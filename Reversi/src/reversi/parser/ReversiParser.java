package reversi.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import reversi.server.commands.ReversiCommand;
import reversi.server.commands.ReversiCommand.ReversiCommandType;
import reversi.server.commands.ReversiCommandReader;

public class ReversiParser implements ReversiCommandReader {

	private static final Map<String, ReversiCommandType> commandsMap = new HashMap<String, ReversiCommandType>();

	static {
		commandsMap.put("OK", ReversiCommandType.Ok);
		commandsMap.put("EXIT", ReversiCommandType.Exit);
		commandsMap.put("DISPLAY", ReversiCommandType.Display);
		commandsMap.put("UNDO", ReversiCommandType.Undo);
		commandsMap.put("EASY", ReversiCommandType.Easy);
		commandsMap.put("MEDIUM", ReversiCommandType.Medium);
		commandsMap.put("HARD", ReversiCommandType.Hard);
		commandsMap.put("IMPOSSIBLE", ReversiCommandType.Impossible);
		commandsMap.put("WHITE", ReversiCommandType.White);
		commandsMap.put("BLACK", ReversiCommandType.Black);
		commandsMap.put("AI-LOCAL", ReversiCommandType.AILOCAL);
		commandsMap.put("HUMAN-AI", ReversiCommandType.HumanAI);
		commandsMap.put("AI-AI", ReversiCommandType.AIAI);
		commandsMap.put(";", ReversiCommandType.Comment);
	}

	public ReversiCommand parseCommand(String toParse)
	{
		ReversiCommand command = null;
		
		String[] tokens = toParse.split("\\s+");
		
		String tokenCommand = tokens[0].toUpperCase();
		ReversiCommandType parsedCommandType = commandsMap.get(tokenCommand);
		
		if(parsedCommandType != null) {
			command = this.parseCommandTokens(parsedCommandType, tokens);
		} else if (tokenCommand.length() == 2) {
			
			//Parse a move
			String move = tokens[0];
			String column = move.substring(0, 1);
			String row = move.substring(1, 2);

			List<String> moveParameters = new ArrayList<String>();
			moveParameters.add(column);
			moveParameters.add(row);

			command = new ReversiCommand(ReversiCommandType.Move, moveParameters);
			
		} else {
			command = new ReversiCommand(ReversiCommandType.Unknown);
		}
		
		return command;
	}

	private ReversiCommand parseCommandTokens(ReversiCommandType parsedCommandType, String[] tokens) {
		
		ReversiCommand command = null;
				
		switch(parsedCommandType) {
			case AIAI:
			case Comment: {

				List<String> parameters = Arrays.asList(tokens);
				parameters.remove(0);	//Remove command identifier.

				command = new ReversiCommand(parsedCommandType, parameters);
			} break;
			default: {
				command = new ReversiCommand(parsedCommandType);
			} break;
		}
		return command;
	}

}
