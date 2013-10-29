package reversi.client.gui.game.board;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;

import reversi.models.ReversiEntity;

import base.models.BoardPiece;
import base.models.Position;

/**
 * Game GUI that shows the game board.
 * 
 * @author shaneb
 * 
 */
public class ReversiGameBoardGUI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String ReversiWindowName = "Reversi Game Board";

	private static final Integer windowHeight = 544;
	private static final Integer windowWidth = 544;
	
	private static final Dimension WINDOW_SIZE = new Dimension(windowWidth, windowHeight);

	protected final Map<Position, ReversiBoardPieceGUI> boardElements = new HashMap<Position, ReversiBoardPieceGUI>();

	private JPanel boardPanel;

	public void buildBoard() {

		this.boardPanel = new JPanel();
		this.boardPanel.setLayout(new GridLayout(8, 8));
		
		for (int r = 1; r <= 8; r += 1) {

			for (int c = 0; c < 8; c += 1) {
	
				Position position = new Position(c, r);
				ReversiBoardPieceGUI newPiece = new ReversiBoardPieceGUI(position);
				boardElements.put(position, newPiece);
				
				newPiece.setActionCommand(position.toString());
			}
		}
		
	}

	public void updateBoard(ReversiGameBoardGUI board) {

		for (int r = 1; r <= 8; r += 1) {

			for (int c = 0; c < 8; c += 1) {
	
				Position position = new Position(c, r);
				ReversiBoardPieceGUI newPiece = new ReversiBoardPieceGUI(position);
				boardElements.put(position, newPiece);
				
				newPiece.setActionCommand(position.toString());
			}
		}
		
	}
	
	@Override
	public Dimension getPreferredSize() {
		return WINDOW_SIZE;
	}

}
