package Reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
	public List<String> getSymptoms() {
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
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		logger.error("ArrayList<String> result is created");
		return result;
	}
	
	public List<String> getSymptomsList(){
		return getSymptoms();
	}
	public void printSymptoms(){
		System.out.println(getSymptoms().toString());

	}
}
