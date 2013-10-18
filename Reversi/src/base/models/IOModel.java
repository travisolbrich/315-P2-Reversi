package base.models;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public interface IOModel{

	public OutputStream getOutputStream() throws IOException;
	
	public PrintWriter getWriter() throws IOException;

	public Scanner getInputScanner() throws IOException;

}
