package Reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Interfaces.ISymptomReader;



public class Counter {
	private static Logger logger = LogManager.getLogger(Counter.class);
    private String filepath;
    private ReadSymptomDataFromFile result;
    //Map<String, Integer> symptomsQuantity = new HashMap<String, Integer>();

    public Counter (String filepath) {
		this.filepath = filepath;
        this.result = new ReadSymptomDataFromFile(this.filepath);
		logger.error("filepath recovered");
	}
	public Map<String, Integer> addSymptoms(){
		List<String> symptomsList = result.getSymptoms();
        HashMap<String, Integer> symptomsQuantity = new HashMap<String, Integer>();
		for(String symptom : symptomsList){
			symptomsQuantity.put(symptom, symptomsQuantity.getOrDefault(symptom,1)+1);
			//logger.error("symptom added");
		} return symptomsQuantity;
	}
    public Map<String, Integer> getSymptomsQuantity(){
		return (addSymptoms());
	}
/* 	public void printSymptomsQuantity(){
		System.out.println(String.valueOf(addSymptoms()));
	} */
}
