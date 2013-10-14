package reversi.models;


import reversi.server.display.ReversiAsciiDisplayController;
import base.models.Board;

public class ReversiBoard extends Board<ReversiEntity> {

	public String getASCIIView()
	{
		return ReversiAsciiDisplayController.drawBoard(this);
	}

}
