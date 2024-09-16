import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import classes.*;
import interfaces.*;

public class AnalyticsCounter {
	private static Logger logger = LogManager.getLogger(AnalyticsCounter.class);

	/**
	 * 
	 * Reads source file and creates List of items
	 * Counts items and generates Map of Items/Quantities
	 * Formats and writes results in output file
	 * 
	 * @throws IOException if source file not found or not accessible
	 * 
	 */
	public static void main(String args[]) throws IOException {
		try {
			IReader reader = new SourceFileReader("symptoms.txt");
			List<String> list = new ArrayList<String>(reader.read());
			ICounter counter = new ListCounter(list);
			IWriter writer = new OutputFileWriter(counter);
			writer.write("result.out");
		} catch (FileNotFoundException e) {
			logger.error("Source file is not accessible.");
		}
	}
}
