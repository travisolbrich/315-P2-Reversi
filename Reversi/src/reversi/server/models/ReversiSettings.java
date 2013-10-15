package reversi.server.models;

import java.util.ArrayList;
import java.util.List;

import reversi.models.ReversiPlayer;

/**
 * Contains setup settings and players. Used by a GameFactory to create a new
 * ReversiGame.
 * 
 * @author dereekb
 * 
 */
public class ReversiSettings {

	private Boolean includeAi;
	private List<ReversiPlayer> players = new ArrayList<ReversiPlayer>();
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

	public List<ReversiPlayer> getPlayers() {
		return players;
	}

	public void setPlayers(List<ReversiPlayer> players) {
		this.players = players;
	}

}
