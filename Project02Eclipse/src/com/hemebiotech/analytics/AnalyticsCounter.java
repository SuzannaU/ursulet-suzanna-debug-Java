import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import classes.*;
import interfaces.*;
import exceptions.EmptyListException;

public class AnalyticsCounter {
	private static Logger logger = LogManager.getLogger(AnalyticsCounter.class);

	/**
	 * 
	 * Reads source file and creates List of items
	 * Counts items and generates Map of Items/Quantities
	 * Formats into a symptoms String
	 * Writes result in output file
	 * 
	 * @throws IOException        if source file not found or not accessible
	 * @throws EmptyListException if list is empty
	 * 
	 */
	public static void main(String args[]) throws IOException, EmptyListException {
		try {
			IReader reader = new SourceFileReader();
			List<String> listOfSymptoms = new ArrayList<String>(reader.read("symptoms.txt"));
			ICounter counter = new ListCounter(listOfSymptoms);
			Map<String, Integer> mapOfSymptomsQuantities = new TreeMap<String, Integer>(counter.count());
			IFormatter formatter = new SymptomsFormatter(mapOfSymptomsQuantities);
			StringBuilder formattedList = new StringBuilder(formatter.formatSymptoms());
			IWriter writer = new OutputFileWriter(formattedList);
			writer.write("result.out");
		} catch (FileNotFoundException e) {
			logger.error("Source file is not accessible.");
		} catch (EmptyListException e) {
			logger.error("List is empty, nothing to write.");
		}
	}
}
