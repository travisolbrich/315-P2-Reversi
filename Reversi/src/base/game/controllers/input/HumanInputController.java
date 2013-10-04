package base.game.controllers.input;

import base.models.Player;
import base.models.game.Input;

/**
 * Interface that takes input from a human. 
 * 
 * On a server, this function will talk to the human who's turn it is an wait for their response.
 * 
 * @author dereekb
 *
 * @param <P> Player
 * @param <I> Input
 */
public interface HumanInputController<P extends Player, I extends Input<P>> {

	public I inputForHuman(P human);

}
