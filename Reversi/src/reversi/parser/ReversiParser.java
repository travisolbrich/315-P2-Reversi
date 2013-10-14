package reversi.parser;

import java.util.ArrayList;
import java.util.List;

import reversi.server.commands.ReversiCommand;
import reversi.server.commands.ReversiCommand.ReversiCommandType;
import reversi.server.commands.ReversiCommandReader;

public class ReversiParser implements ReversiCommandReader {
	
	private String[] columns = {"a", "b", "c", "d", "e", "f", "g", "h"};
	
	public ReversiCommand parseCommand(String toParse)
	{
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
		
		// Check for a move
		for(String test : columns)
		{
			Integer row = new Integer(tokens[1]);
			
			if(tokens[0].equals(test) && (row <= 8 && row >= 1))
			{
				ArrayList<String> parameters = new ArrayList<String>();
				parameters.add(tokens[0]);
				parameters.add(tokens[1]);
				
				return new ReversiCommand(ReversiCommandType.Move, parameters);
			}
		}
		
		return new ReversiCommand(ReversiCommandType.Unknown);
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
