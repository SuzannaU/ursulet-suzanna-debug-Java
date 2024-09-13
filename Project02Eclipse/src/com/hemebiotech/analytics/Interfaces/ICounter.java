package Interfaces;
import java.io.IOException;
import java.util.Map;
import Exceptions.EmptyListException;
/**
 * Counts symptoms and gets rid of doubles
 */
public interface ICounter {
    public Map<String, Integer> count() throws IOException, EmptyListException;
}
