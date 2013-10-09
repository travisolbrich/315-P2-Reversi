package reversi.server.commands;

import java.util.List;

public class ReversiCommand 
{
	public static enum ReversiCommandType
	{
		ReversiCommandTypeExit,

		ReversiCommandTypeDisplay,

		ReversiCommandTypeUndo,
		
		ReversiCommandTypeRedo,
		
		ReversiCommandTypeDifficulty,

		ReversiCommandTypeHumanAI,
		
		ReversiCommandTypeAIAI
	}
	
	public final ReversiCommandType type;
	public final List<String> parameters;
	
	public ReversiCommand(ReversiCommandType type, List<String> parameters)
	{
		this.type = type;
		this.parameters = parameters;
	}
	
}
