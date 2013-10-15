package reversi.parser;

import java.util.ArrayList;
import java.util.List;

import reversi.server.commands.ReversiCommand;
import reversi.server.commands.ReversiCommand.ReversiCommandType;
import reversi.server.commands.ReversiCommandReader;

public class ReversiParser implements ReversiCommandReader {
	
	public ReversiCommand parseCommand(String toParse)
	{
		toParse = toParse.toUpperCase();
		String[] tokens = toParse.split("\\s+");
		
		if(tokens[0].equals("EXIT")) return new ReversiCommand(ReversiCommandType.Exit);		
		
		if(tokens[0].equals("DISPLAY")) return new ReversiCommand(ReversiCommandType.Display);
		
		if(tokens[0].equals("UNDO")) return new ReversiCommand(ReversiCommandType.Undo);
		
		if(tokens[0].equals("EASY")) return new ReversiCommand(ReversiCommandType.Easy);
		
		if(tokens[0].equals("MEDIUM")) return new ReversiCommand(ReversiCommandType.Medium);
		
		if(tokens[0].equals("HARD")) return new ReversiCommand(ReversiCommandType.Hard);
		
		if(tokens[0].equals("HUMAN-AI")) return new ReversiCommand(ReversiCommandType.HumanAI);
		
		if(tokens[0].equals("AI-AI")) return parseAIAI(tokens);
		
		if(tokens[0].equals(";")) return new ReversiCommand(ReversiCommandType.Comment);
		
		ReversiCommand command = null;
		
		if(tokens[0].length() == 2)
		{
			String move = tokens[0];
			String column = move.substring(0,1);
			String row = move.substring(1,2);
			
			List<String> moveParameters = new ArrayList<String>();
			moveParameters.add(column);
			moveParameters.add(row);
			
			command = new ReversiCommand(ReversiCommandType.Move, moveParameters);
		} else {
			command = new ReversiCommand(ReversiCommandType.Unknown);
		}
		
		return command;
	}

	private ReversiCommand parseAIAI(String[] tokens) {
		List<String> parameters  = new ArrayList<String>();
		
		for(String item : tokens)
		{
			if( ! item.equals("AI-AI")) parameters.add(item);
		}
		
		return new ReversiCommand(ReversiCommandType.AIAI, parameters);
	}
	
}
