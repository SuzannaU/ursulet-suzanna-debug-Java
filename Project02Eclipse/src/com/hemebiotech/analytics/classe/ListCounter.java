package classe;

import java.util.TreeMap;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import exception.EmptyListException;
import interface2.*;

/**
 * @see interfaces.ICounter
 *      Converts a raw list of items into a Map of each item and their
 *      quantities
 */
public class ListCounter implements ICounter {
	private static Logger logger = LogManager.getLogger(ListCounter.class);
	private List<String> rawList;

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
	@Override
	public Map<String, Integer> count() throws IOException, EmptyListException {
		TreeMap<String, Integer> rawQuantities = new TreeMap<String, Integer>();
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
