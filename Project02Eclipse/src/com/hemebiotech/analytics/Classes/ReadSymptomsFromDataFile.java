package Classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Simple brute force implementation
 */
public class ReadSymptomsFromDataFile extends GetFilePath {
	private static Logger logger = LogManager.getLogger(ReadSymptomsFromDataFile.class);
	/**
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomsFromDataFile (String filepath) {
		super (filepath);
	}
	/**
	 * @return ArrayList<String> containing all symptoms read
	 */
	public List<String> getSymptomsFromDataFile() throws IOException {
		ArrayList<String> rawSymptomsList = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader (new FileReader(filepath));
			String line = reader.readLine();				
			while (line != null) {
				rawSymptomsList.add(line);
				line = reader.readLine();
			}
			reader.close();
		} catch (FileNotFoundException e) {
			logger.error(filepath + " cannot be found.");
			throw new FileNotFoundException();
		} catch (IOException e) {
			logger.error("Cannot read " + filepath);
			throw new IOException();
		}		
		logger.error("rawSymptomsList is created");
		return rawSymptomsList;
	}
    public List<String> getRawSymptomsList() throws IOException{
		return getSymptomsFromDataFile();
	}
	public void printRawSymptomsList() throws IOException{
		try{
			System.out.println(getSymptomsFromDataFile().toString());
		}catch (IOException e) {
			logger.error("Cannot print any symptoms");
		}
	}
}
