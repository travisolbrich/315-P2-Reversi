package reversi.client.gui;

import javax.swing.JButton;
import base.models.Position;

public class ReversiBoardPieceGUI extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final Position position;

	public ReversiBoardPieceGUI(Position position) {
		this.position = position;
	}

	public Position getPosition() {
		return position;
	}

}
