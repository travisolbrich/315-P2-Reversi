package base.models.game;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import base.models.Player;

public class Turn<P extends Player, I extends Input<P>> {

	private final Integer turnId;
	private final List<I> turnInput = new ArrayList<I>();

	public Turn(Integer turnId) {
		this.turnId = turnId;
	}

	public Integer getTurnId() {
		return turnId;
	}

	public List<I> getTurnInput() {
		return turnInput;
	}

	public void addInput(Collection<I> input) {
		this.turnInput.addAll(input);
	}

	public void addInput(I input) {
		this.turnInput.add(input);
	}

}
