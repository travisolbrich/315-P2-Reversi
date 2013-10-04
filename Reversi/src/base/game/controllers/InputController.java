package base.game.controllers;

import java.util.ArrayList;
import java.util.List;

import base.game.controllers.input.HumanInputController;
import base.game.controllers.input.IntelligenceInputController;
import base.models.Player;
import base.models.game.Input;

/**
 * Basic input controller that runs loop over players waiting for input.
 * 
 * @author dereekb
 * 
 * @param <P>
 * @param <I>
 * @param <A>
 */
public abstract class InputController<P extends Player, I extends Input<P>> {

	private final IntelligenceInputController<P, I> intelligenceController;
	private final HumanInputController<P, I> humanController;

	public InputController(HumanInputController<P, I> humanController) {
		this(humanController, null);
	}

	public InputController(HumanInputController<P, I> humanController,
			IntelligenceInputController<P, I> intelligenceController) {
		this.intelligenceController = intelligenceController;
		this.humanController = humanController;
	}

	public List<I> getInputForPlayers(List<P> players) {
		List<I> turnInput = new ArrayList<I>();
		List<P> playingPlayers = this.filterPlayersForNextTurn(players);

		for (P player : playingPlayers) {
			I input = null;

				boolean isHuman = player.isHuman();

				if (isHuman) {
					input = this.humanController.inputForHuman(player);
				} else {
					input = this.intelligenceController
							.inputForIntelligence(player);
				}

				if (input != null) {
					turnInput.add(input);
				}
		}

		return turnInput;
	}

	protected abstract List<P> filterPlayersForNextTurn(List<P> players);
}
