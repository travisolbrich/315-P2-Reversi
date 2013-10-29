package reversi.client.gui;

/**
 * Used by a ReversiClientGUI to handle a user's actions.
 * @author dereekb
 *
 */
public interface ReversiClientGUIDelegate{

	public void startServer(Integer port);

	public boolean playLocal();
	
	public boolean playRemote(String address, String port);

}
