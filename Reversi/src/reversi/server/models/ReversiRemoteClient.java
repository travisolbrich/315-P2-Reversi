package reversi.server.models;

import java.net.Socket;
import reversi.models.ReversiPlayer;
import base.server.RemoteClient;


public class ReversiRemoteClient extends RemoteClient<ReversiPlayer>{

	public ReversiRemoteClient(Socket socket){
		super(socket);
	}

}
