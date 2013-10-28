package reversi.client.gui;

import java.awt.Dimension;

import javax.swing.JPanel;

/**
 * The Game's GUI
 * 
 * @author dereekb
 * 
 */
public class ReversiGameGUI extends JPanel {
	 
	private static final Dimension GAME_GUI_SIZE = new Dimension(800, 800);

	@Override
	public Dimension getPreferredSize() {
		return GAME_GUI_SIZE;
	}
}
