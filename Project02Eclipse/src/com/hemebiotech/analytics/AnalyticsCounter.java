import java.io.IOException;

import Classes.*;
import Exceptions.EmptyListException;
import Interfaces.*;
/**
 * Main Class, where process is executed
 */
public class AnalyticsCounter {
	/**
	 * @
	 * Instanciate object typed IWriter, according to WriteINFile Class
	 * @param filepath of source file as String
	 * 
	 * Call writeInFile() method from that object
	 * @return create result.out file with symptoms list and quantity
	 * @throws IOException 
	 * @throws EmptyListException 
	 * 
	 */
	public static void main(String args[]) throws IOException, EmptyListException{
		IWriter writer = new SymptomsWriter("symptoms.txt");
		writer.write();
	}
	
/* 		What it should look like:

		IReader reader = new SymptomsReader("symptoms.txt");
		ICounter counter = new SymptomsCounter(reader.reader(););
		IWriter writer = new SymptomsWriter(counter.counter(););
		 */
}
