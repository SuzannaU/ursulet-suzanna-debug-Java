package interface2;

import java.io.IOException;
import java.util.Map;

import exception.EmptyListException;

/**
 * Counts items from List and puts them in a Map
 */
public interface ICounter {
    public Map<String, Integer> count() throws IOException, EmptyListException;
}
