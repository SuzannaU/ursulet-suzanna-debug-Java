package Classes;

import java.util.TreeMap;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import Exceptions.EmptyListException;

import Interfaces.ICounter;
import Interfaces.IReader;
/**
 * @see Interfaces.ICounter
 * Converts a raw symptoms list into a K-V of each symptoms (without doubles) and their quantities
 */
public class SymptomsCounter extends GetFilePath implements ICounter {
	private static Logger logger = LogManager.getLogger(SymptomsCounter.class);
    private IReader rawList;

    public SymptomsCounter (String filepath) {
		super (filepath);
        this.rawList = new SymptomsReader(this.filepath);
	}
	/**
	 *
	 * @param rawList from ReadSymptomsFromDataFile Class
	 * @return TreeMap<String, Integer> containing all symptoms sorted alphabetically with their quantities, no doubles
	 * @throw IOException if file not accessible or does not exist (also handles FIleNotAccessibleException)
	 * 		EmptyListException if the raw list of entry was empty
	 */
	@Override
	public Map<String, Integer> count() throws IOException, EmptyListException {
        TreeMap<String, Integer> rawSymptomsQuantity = new TreeMap<String, Integer>();
		try{			
			List<String> rawList = this.rawList.read();
				if (rawList.isEmpty()){
					logger.error("rawSymptomsList is empty");
					throw new EmptyListException();
				}
				else{
					for(String symptom : rawList){
						rawSymptomsQuantity.put(symptom, rawSymptomsQuantity.getOrDefault(symptom,1)+1);
						//logger.error("symptom added");	//to be used as utility
					}
				}
	 	} catch (IOException | EmptyListException e) {
			logger.error("rawSymptomsList is empty, rawSymptomsQuantity is not created");
			throw new EmptyListException();
		}
		logger.error("rawSymptomsQuantity is created");
		return rawSymptomsQuantity;
	}
	/**
	 * Utility function, not used in main process
	 * 
	 * @return Map<String, Integer> of symptoms list and quantities
	 * @throws IOException, EmptyListException
	 */
    public Map<String, Integer> getRawSymptomsQuantity() throws IOException, EmptyListException{
		return count();
	}
	/**
	 * Utility function, not used in main process
	 * 
	 * @return Print list of symptoms and quantity in console
	 * @throws IOException, EmptyListException
	 */
	public void printRawSymptomsQuantity() throws IOException, EmptyListException{
		try{
			System.out.println(count().toString());
		}catch (IOException | EmptyListException e) {
			logger.error("Cannot print any symptoms");
		}
	}
}
