package Classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Interfaces.IReader;

/**
 * Obtains data from source file
 * 
 * @see Interfaces.ISymptomReader
 */
public class SymptomsReader implements IReader {
	private static Logger logger = LogManager.getLogger(SymptomsReader.class);
	private String sourceFilePath;

	/**
	 *
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 must be one per line
	 * @return ArrayList<String> containing all symptoms read
	 * @throw IOException if source file exist but not accessible
	 *        or FileNotFoundException if source file does not exist
	 */
	public SymptomsReader(String sourceFilePath) {
		this.sourceFilePath = sourceFilePath;
	}

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
		logger.error("rawSymptomsList is created");
		return rawList;
	}

	/**
	 * Utility function, not used in main process
	 * 
	 * @return List<String> of raw symptoms list
	 * @throws IOException
	 */
	public List<String> getRawSymptomsList() throws IOException {
		return read();
	}

	/**
	 * Utility function, not used in main process
	 * 
	 * @return Print list of raw symptoms in console
	 * @throws IOException
	 */
	public void printRawSymptomsList() throws IOException {
		try {
			System.out.println(read().toString());
		} catch (IOException e) {
			logger.error("Cannot print any symptoms");
		}
	}
}
