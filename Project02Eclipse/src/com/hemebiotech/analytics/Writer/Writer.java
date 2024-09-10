package Writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Reader.*;

public class Writer {
    private static Logger logger = LogManager.getLogger(Writer.class);
    private String filepath;
    private Counter symptomsQuantity;

    public Writer (String filepath) {
		this.filepath = filepath;
        this.symptomsQuantity = new Counter(this.filepath);
		logger.error("filepath recovered");
	}

    public void printSymptomsQuantity(){
        System.out.println(symptomsQuantity.getSymptomsQuantity());
    }
    public StringBuilder formatSymptomsList (){
        Map<String,Integer> symptomsQuantity = this.symptomsQuantity.getSymptomsQuantity();
        Set<String> symptoms = symptomsQuantity.keySet();
        StringBuilder formattedList = new StringBuilder();
        formattedList.append("List of symptoms and their occurences:\n");
        for(String symptom : symptoms){
            Integer quantity = symptomsQuantity.get(symptom);
            formattedList.append(symptom + " : " + quantity + "\n");
        }
        return formattedList;
    }
    public StringBuilder getFormattedList(){
		return formatSymptomsList();
	}
    public void writeInFile (){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("result.out"));
            writer.write(getFormattedList().toString());
            writer.close();
        } catch (IOException e){
            logger.error("Cannot write in file");
        }
    }
}
