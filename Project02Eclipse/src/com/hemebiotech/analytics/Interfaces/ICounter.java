package interfaces;

import java.io.IOException;
import java.util.Map;
import exceptions.EmptyListException;

/**
 * Counts items from List
 */
public interface ICounter {
    public Map<String, Integer> count() throws IOException, EmptyListException;
}
