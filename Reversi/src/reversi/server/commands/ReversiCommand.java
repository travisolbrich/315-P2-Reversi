package reversi.server.commands;

import java.util.List;

public class ReversiCommand 
{
	public static enum ReversiCommandType
	{
		Exit,

		Display,

		Undo,
		
		Redo,
		
		Easy,
		
		Medium,
		
		Hard,
		
		Impossible,
		
		HumanAI,
		
		AIAI,
		
		AILOCAL,	//For watching the server's AI fight itself.
		
		Move, 
		
		Comment,
		
		Unknown, 
		
		Black,
		
		White, 
		
		Ok
	}
	
	private final ReversiCommandType type;
	private final List<String> parameters;
	
	public ReversiCommand(ReversiCommandType type, List<String> parameters)
	{
		this.type = type;
		this.parameters = parameters;
	}
	
	public ReversiCommand(ReversiCommandType type)
	{
		this.type = type;
		this.parameters = null;
	}

	public List<String> getParameters() {
		return this.parameters;
	}

	public ReversiCommandType getType() {
		return type;
	}
}
