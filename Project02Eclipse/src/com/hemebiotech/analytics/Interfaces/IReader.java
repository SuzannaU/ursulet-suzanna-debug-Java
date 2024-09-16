package interfaces;

import java.io.IOException;
import java.util.List;

/**
 * Reads data and returns a List<String>
 * 
 */
public interface IReader {
	public List<String> read() throws IOException;
}
