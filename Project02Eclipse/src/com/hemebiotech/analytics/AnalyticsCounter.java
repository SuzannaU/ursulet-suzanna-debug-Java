import Classes.*;
/**
 * 
 */
public class AnalyticsCounter {
	/**
	 * Instanciate object typed WriteInFile, with source file filepath as param
	 * Call writeInFile() method from that object
	 * 
	 */
	public static void main(String args[]){
		WriteInFile file = new WriteInFile("symptoms.txt");
		file.writeInFile();
	}
}
