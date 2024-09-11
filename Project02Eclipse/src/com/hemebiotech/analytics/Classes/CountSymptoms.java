package Classes;

import java.util.TreeMap;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Exceptions.EmptyListException;



public class CountSymptoms {
	private static Logger logger = LogManager.getLogger(CountSymptoms.class);
    private String filepath;
    private ReadSymptomDataFromFile result;

    public CountSymptoms (String filepath) {
		this.filepath = filepath;
        this.result = new ReadSymptomDataFromFile(this.filepath);
		logger.error("filepath recovered");
	}
	public Map<String, Integer> addSymptoms() throws EmptyListException, IllegalArgumentException, IOException{
		List<String> symptomsList = result.getSymptoms();
        TreeMap<String, Integer> symptomsQuantity = new TreeMap<String, Integer>();
		if (symptomsList.isEmpty()){
            logger.error("List is empty");
			throw new EmptyListException();
		}else{
		for(String symptom : symptomsList){
			symptomsQuantity.put(symptom, symptomsQuantity.getOrDefault(symptom,1)+1);
			//logger.error("symptom added");
		} return symptomsQuantity;
		}
	}
    public Map<String, Integer> getSymptomsQuantity() throws EmptyListException, IllegalArgumentException, IOException{
		return (addSymptoms());
	}
}
