package base.models;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Base player class that contains information about a given player.
 * @author dereekb
 *
 * @param <E> Elements that the player can control.
 */
public abstract class Player implements IOModel{

	private final String name;
	private Boolean inGame = true;
	private Boolean controlledByAi = false;
	private Boolean asciiDisplay = false;

	protected final InputStream inputStream;
	protected final OutputStream outputStream;

	public Player(String name) {
		this.name = name;
		this.inputStream = System.in;
		this.outputStream = System.out;
	}
	
	public Player(String name, InputStream inputStream, OutputStream outputStream) {
		this.name = name;
		this.inputStream = inputStream;
		this.outputStream = outputStream;
	}

	public String getName() {
		return name;
	}

	public Boolean isInGame() {
		return inGame;
	}

	public void setInGame(Boolean inGame) {
		this.inGame = inGame;
	}

	public Boolean isHuman() {
		return (controlledByAi == false);
	}

	public Boolean isAI() {
		return controlledByAi;
	}

	public void setControlledByAi(Boolean controlledByAi) {
		this.controlledByAi = controlledByAi;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public OutputStream getOutputStream() {
		return outputStream;
	}

	public PrintWriter getWriter() throws IOException{
		OutputStream output = this.getOutputStream();
		PrintWriter writer = new PrintWriter(output, true);
		return writer;
	}

	public Scanner getInputScanner() throws IOException{
		InputStream input = this.getInputStream();
		Scanner scanner = new Scanner(input);
		return scanner;
	}

	public Boolean getAsciiDisplay() {
		return asciiDisplay;
	}

	public void setAsciiDisplay(Boolean asciiDisplay) {
		this.asciiDisplay = asciiDisplay;
	}
	
	public void toggleAsciiDisplay() {
		this.asciiDisplay = !this.asciiDisplay;
	}
}
