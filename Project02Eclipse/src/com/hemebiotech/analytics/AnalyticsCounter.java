import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Classes.*;
import Interfaces.*;

/**
 * Main Class, where process is executed
 */
public class AnalyticsCounter {
	private static Logger logger = LogManager.getLogger(AnalyticsCounter.class);

	/**
	 * 
	 * @param sourceFilePath of source file as String
	 * 
	 *                       Call writeInFile() method from that object
	 * @return create result.out file with symptoms list and quantity
	 * @throws IOException
	 * 
	 */
	public static void main(String args[]) throws IOException {
		try {
			IReader reader = new SymptomsReader("symptoms.txt");
			List<String> list = new ArrayList<String>(reader.read());
			ICounter counter = new SymptomsCounter(list);
			IFormatter formatter = new SymptomsFormatter(counter);
			IWriter writer = new SymptomsWriter(formatter);
			writer.write("result.out");
		} catch (FileNotFoundException e) {
			logger.error("Source file cannot be found.");
		}
	}
}
