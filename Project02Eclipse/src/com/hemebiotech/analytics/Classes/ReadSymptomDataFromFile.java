package Classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Interfaces.ISymptomReader;

/**
 * Simple brute force implementation
 */
public class ReadSymptomDataFromFile implements ISymptomReader {
	private static Logger logger = LogManager.getLogger(ReadSymptomDataFromFile.class);

	private String filepath;
	/**
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
		logger.error("filepath recovered");
	}
	public String getFilepath() {
		return this.filepath;
	}	
	/**
	 * @return ArrayList<String> containing all symptoms read
	 */
	@Override
	public List<String> getSymptoms() throws IllegalArgumentException, IOException {
		ArrayList<String> result = new ArrayList<String>();
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (FileNotFoundException e) {
				logger.error(filepath + " cannot be found.");
				throw new FileNotFoundException(filepath + " cannot be found.");
			} catch (IOException e) {
				logger.error("Cannot read " + filepath);
				throw new IOException("Cannot read " + filepath, e);
			}
		
			logger.error("ArrayList<String> result is created");
			return result;
		}else{
			logger.error("Filepath is empty");
			throw new IllegalArgumentException ("Filepath is empty");
		}
	}
	
	public List<String> getSymptomsList() throws IllegalArgumentException, IOException{
		return getSymptoms();
	}
	public void printSymptoms() throws IllegalArgumentException, IOException{
		System.out.println(getSymptoms().toString());

	}
}
