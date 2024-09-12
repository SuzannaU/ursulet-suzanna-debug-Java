package Classes;

import java.util.TreeMap;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Exceptions.EmptyListException;
import Interfaces.ICounter;

public class CountSymptoms extends GetFilePath implements ICounter {
	private static Logger logger = LogManager.getLogger(CountSymptoms.class);
    private ReadSymptomsFromDataFile rawSymptomsList;

    public CountSymptoms (String filepath) {
		super (filepath);
        this.rawSymptomsList = new ReadSymptomsFromDataFile(this.filepath);
	}
	@Override
	public Map<String, Integer> countSymptoms() throws IOException, EmptyListException {
        TreeMap<String, Integer> rawSymptomsQuantity = new TreeMap<String, Integer>();
		try{			
			List<String> rawSymptomsList = this.rawSymptomsList.getSymptomsFromDataFile();
				if (rawSymptomsList.isEmpty()){
					logger.error("rawSymptomsList is empty");
					throw new EmptyListException();
				}
				else{
					for(String symptom : rawSymptomsList){
						rawSymptomsQuantity.put(symptom, rawSymptomsQuantity.getOrDefault(symptom,1)+1);
						//logger.error("symptom added");
					}
				}
	 	} catch (IOException | EmptyListException e) {
			logger.error("rawSymptomsList is empty, rawSymptomsQuantity is not created");
			throw new EmptyListException();
		}
		logger.error("rawSymptomsQuantity is created");
		return rawSymptomsQuantity;
	}
    public Map<String, Integer> getRawSymptomsQuantity() throws IOException, EmptyListException{
		return countSymptoms();
	}
	public void printRawSymptomsQuantity() throws IOException, EmptyListException{
		try{
			System.out.println(countSymptoms().toString());
		}catch (IOException | EmptyListException e) {
			logger.error("Cannot print any symptoms");
		}
	}
}
