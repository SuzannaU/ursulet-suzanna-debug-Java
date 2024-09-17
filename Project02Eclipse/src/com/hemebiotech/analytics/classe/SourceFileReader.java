package classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import interfaces.IReader;

/**
 * Obtains data from source file
 * 
 * @see interfaces.IReader
 */
public class SourceFileReader implements IReader {
	private static Logger logger = LogManager.getLogger(SourceFileReader.class);
	private String sourceFilePath;

	public SourceFileReader(String sourceFilePath) {
		this.sourceFilePath = sourceFilePath;
	}

	/**
	 * @param sourceFilePath a full or partial path to file with items in it,
	 *                       must be one per line
	 * @return ArrayList<String> containing all items read
	 * @throws IOException           if source file exists but not accessible
	 * @throws FileNotFoundException if source file does not exist
	 */
	@Override
	public List<String> read() throws IOException {
		ArrayList<String> rawList = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(sourceFilePath));
			String line = reader.readLine();
			while (line != null) {
				rawList.add(line);
				line = reader.readLine();
			}
			reader.close();
		} catch (FileNotFoundException e) {
			logger.error(sourceFilePath + " cannot be found.");
			throw new FileNotFoundException();
		} catch (IOException e) {
			logger.error("Cannot read " + sourceFilePath);
			throw new IOException();
		}
		logger.info("rawList is created");
		return rawList;
	}
}
