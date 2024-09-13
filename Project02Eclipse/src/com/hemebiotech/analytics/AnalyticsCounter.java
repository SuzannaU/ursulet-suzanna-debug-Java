import Classes.*;
import Interfaces.IWriter;
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
	 * 
	 */
	public static void main(String args[]){
		IWriter file = new WriteInFile("symptoms.txt");
		file.writeInFile();
	}
}
