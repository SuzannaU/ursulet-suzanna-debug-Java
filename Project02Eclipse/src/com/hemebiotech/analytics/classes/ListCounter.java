package classes;

import java.util.TreeMap;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import exceptions.EmptyListException;
import interfaces.*;

/**
 * Converts a raw list of items into a Map of each item and its quantity
 * 
 * @see interfaces.ICounter
 */
public class ListCounter implements ICounter {
	private static Logger logger = LogManager.getLogger(ListCounter.class);
	private List<String> rawList;
	private TreeMap<String, Integer> rawQuantities = new TreeMap<String, Integer>();

	public ListCounter(List<String> rawList) {
		this.rawList = rawList;
	}

	/**
	 *
	 * @param rawList from constructor attribute
	 * @return TreeMap<String, Integer> containing all symptoms sorted
	 *         alphabetically with their quantities, no doubles
	 * @throws IOException        if file not accessible or does not exist (also
	 *                            handles FIleNotAccessibleException)
	 * @throws EmptyListException if the raw list of entry is empty
	 */
	public Map<String, Integer> count() throws IOException, EmptyListException {
		try {
			if (rawList.isEmpty()) {
				throw new EmptyListException();
			} else {
				for (String item : rawList) {
					rawQuantities.put(item, rawQuantities.getOrDefault(item, 1) + 1);
				}
			}
		} catch (EmptyListException e) {
			logger.error("rawList is empty");
			throw new EmptyListException();
		}
		logger.info("rawQuantities is created");
		return rawQuantities;
	}

}
