package Interfaces;

import java.util.List;
import java.io.IOException;

/**
 * Obtains data from a file
 * Data must be one per line
 * 
 */
public interface IReader {
	List<String> read() throws IOException;
}
