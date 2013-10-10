package reversi.server.models;

import reversi.models.ReversiPlayer;
import base.server.GameSettings;

/**
 * Contains setup settings and players. Used by a GameFactory to create a new
 * ReversiGame.
 * 
 * @author dereekb
 * 
 */
public class ReversiSettings extends GameSettings<ReversiPlayer> {

	private Boolean includeAi;
	private Integer difficulty;

	public ReversiSettings() {
	}

	public Boolean getIncludeAi() {
		return includeAi;
	}

	public void setIncludeAi(Boolean includeAi) {
		this.includeAi = includeAi;
	}

	public Integer getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Integer difficulty) {
		this.difficulty = difficulty;
	}

}
