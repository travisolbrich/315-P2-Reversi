package base.server;

import base.game.BoardGame;
import base.models.Board;
import base.models.Entity;
import base.models.Player;
import base.models.game.Input;

public interface ServerLobbyFactory<L extends GameLobby, P extends Player, S extends GameSettings<P>, G extends BoardGame<?, ?, ?, ?>> {

	public L newLobby(RemoteClient<P> client, BoardGameFactory<P, S, G> factory);

}
