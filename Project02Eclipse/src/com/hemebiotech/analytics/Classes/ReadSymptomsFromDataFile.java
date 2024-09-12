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
 * Obtains data from source file
 * @see Interfaces.ISymptomReader
 */
public class ReadSymptomsFromDataFile extends GetFilePath implements ISymptomReader {
	private static Logger logger = LogManager.getLogger(ReadSymptomsFromDataFile.class);
	
	public ReadSymptomsFromDataFile (String filepath) {
		super (filepath);
	}
	/**
	 *
	 * @param filepath a full or partial path to file with symptom strings in it, must be one per line
	 * @return ArrayList<String> containing all symptoms read
	 * @throw IOException if source file exist but not accessible 
	 * 		or FileNotFoundException if source file does not exist
	 */
	@Override
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
	/**
	 * Utility function, not used in main process
	 * 
	 * @return List<String> of raw symptoms list
	 * @throws IOException
	 */
    public List<String> getRawSymptomsList() throws IOException{
		return getSymptomsFromDataFile();
	}
	/**
	 * Utility function, not used in main process
	 * 
	 * @return Print list of raw symptoms in console
	 * @throws IOException
	 */
	public void printRawSymptomsList() throws IOException{
		try{
			System.out.println(getSymptomsFromDataFile().toString());
		}catch (IOException e) {
			logger.error("Cannot print any symptoms");
		}
	}
}
