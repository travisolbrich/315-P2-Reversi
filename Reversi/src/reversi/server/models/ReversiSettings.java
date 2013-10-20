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

	public enum GameMode {
		HumanAi,
		AIAIRemote,
		AIAILocal
	}
	
	private GameMode gameMode = null;
	private List<ReversiPlayer> players = new ArrayList<ReversiPlayer>();
	private Integer aiDifficulty;
	private Integer aiDifficultySecondary;

	public ReversiSettings(){}
	
	public Integer getAiDifficulty() {
		return aiDifficulty;
	}

	public void setAiDifficulty(Integer aiDifficulty) {
		this.aiDifficulty = aiDifficulty;
	}

	public Integer getAiDifficultySecondary() {
		return aiDifficultySecondary;
	}

	public void setAiDifficultySecondary(Integer aiDifficultySecondary) {
		this.aiDifficultySecondary = aiDifficultySecondary;
	}

	public List<ReversiPlayer> getPlayers() {
		return players;
	}

	public void setPlayers(List<ReversiPlayer> players) {
		this.players = players;
	}

	public GameMode getGameMode() {
		return gameMode;
	}

	public void setGameMode(GameMode gameMode) {
		this.gameMode = gameMode;
	}
}
