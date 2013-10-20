package base.game.controllers.input;

import base.models.Board;
import base.models.Player;
import base.models.game.Input;

/**
 * Controller that makes moves for an AI player.
 * 
 * @author dereekb
 * 
 * @param <I>
 *            Type of Input
 * @param <P>
 *            Type of Player
 */
public interface IntelligenceInputController<P extends Player, I extends Input<P>, B extends Board<?>> {

	public I inputForIntelligence(P intelligence, B board);

	public Integer getDifficultyForAiPlayer(P intelligence);

}
