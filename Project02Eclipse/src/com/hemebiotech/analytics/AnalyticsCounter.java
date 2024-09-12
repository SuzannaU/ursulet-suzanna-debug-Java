import java.io.IOException;

import Classes.*;
import Exceptions.EmptyListException;

public class AnalyticsCounter {	
	public static void main(String args[]) throws IOException, EmptyListException{
		WriteInFile file = new WriteInFile("symptoms.txt");
		file.writeInFile();
	}
}
