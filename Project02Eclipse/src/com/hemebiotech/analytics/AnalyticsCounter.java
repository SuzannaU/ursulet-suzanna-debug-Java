import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import classe.*;
import exception.EmptyListException;
import interface2.*;

public class AnalyticsCounter {
	private static Logger logger = LogManager.getLogger(AnalyticsCounter.class);

	/**
	 * 
	 * Reads source file and creates List of items
	 * Counts items and generates Map of Items/Quantities
	 * Formats and writes results in output file
	 * 
	 * @throws IOException if source file not found or not accessible
	 * @throws EmptyListException 
	 * 
	 */
	public static void main(String args[]) throws IOException, EmptyListException {
		try {
			IReader reader = new SourceFileReader("symptoms.txt");
			List<String> list = new ArrayList<String>(reader.read());
			ICounter counter = new ListCounter(list);
			Map<String, Integer> map = new TreeMap<String,Integer>(counter.count());
			IWriter writer = new OutputFileWriter(map);
			writer.write("result.out");
		} catch (FileNotFoundException e) {
			logger.error("Source file is not accessible.");
		} catch (EmptyListException e) {
			logger.error("List is empty, nothing to write.");
		}
	}
}
