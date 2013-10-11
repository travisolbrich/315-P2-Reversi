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

		ReversiCommandTypeWhite,

		ReversiCommandTypeBlack,
		
		ReversiCommandTypeAIAI
	}
	
	public final ReversiCommandType type;
	public final List<String> parameters;
	
	public ReversiCommand(ReversiCommandType type, List<String> parameters)
	{
		this.type = type;
		this.parameters = parameters;
	}
	
	public ReversiCommandType getType() {
		return type;
	}

	public List<String> getParameters() {
		return parameters;
	}
}
