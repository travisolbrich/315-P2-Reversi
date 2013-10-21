package reversi.GUI;

/*
 * Possibly use "GridLayout" class.
 * Not sure of the limits, still checking.
 */

import java.awt.*;
import javax.swing.*;



public class guiBoard extends JFrame {
	
	DisplayGui();

}

/*
 * Variable will allow switching between menu display and game board display
 */
private void variableGameState( int state) {
	switch (gameState)
		case 0:
			//TODO: Display everything
		case 1:
			//TODO: Display menu
		case 2:
			//TODO: Display board
			//TODO: Display game
			//TODO: Display pieces (sprites)
}

/*
 * Paint method based on variable state
 */
public void DisplayGUI(Graphics2D gfx) {
	int gameState;
	
	if(gameState = 0)
		/*
		 * Draw/redraw: variableGameState(0);
		 */
		
	else if(gameState = 1)
		/*
		 * Draw/redraw: varaibleGameState(1);
		 */
		
	else if(gameState = 2)
		/*
		 * Draw/redraw: variableGameState(2); 
		 */
		
	//GridLayout reversiLayout = newGridLayout(8, 8);
	//addComponentsToPane(getContentPane());
	
	//setSize(800, 800);
	setVisible(true);
}

private void addComponentsToPane( Container contentPane) {
	
}