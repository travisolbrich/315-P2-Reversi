package reversi.game.controller;

import java.util.List;

import base.game.messages.GroupMessageHandler;
import base.models.IOModel;

public class ReversiGroupCommentWriter extends GroupMessageHandler{

	private static final String defaultFormat = ";%s: %s";
	
	public ReversiGroupCommentWriter(List<? extends IOModel> listeners) {
		super(listeners, defaultFormat, false);
	}
}
