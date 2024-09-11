package Classes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Exceptions.EmptyListException;

public class WriteInFile {
    private static Logger logger = LogManager.getLogger(WriteInFile.class);
    private String filepath;
    private CountSymptoms symptomsQuantity;

    public WriteInFile (String filepath) {
		this.filepath = filepath;
        this.symptomsQuantity = new CountSymptoms(this.filepath);
		logger.error("filepath recovered");
	}
    
    public StringBuilder formatSymptomsList () throws IllegalArgumentException, IOException{
        StringBuilder formattedList = new StringBuilder();
        try{
            Map<String,Integer> symptomsQuantity = this.symptomsQuantity.getSymptomsQuantity();
            Set<String> symptoms = symptomsQuantity.keySet();
            formattedList.append("List of symptoms and their occurence:\n");
            for(String symptom : symptoms){
                Integer quantity = symptomsQuantity.get(symptom);
                formattedList.append(symptom + " : " + quantity + "\n");
            }
        }catch (EmptyListException e){
            logger.error("List is empty");
            throw new IllegalArgumentException();
        }
        return formattedList;
    }
    public StringBuilder getFormattedList() throws IllegalArgumentException, IOException{
		return formatSymptomsList();
	}
    public void writeInFile (){
        try{
            StringBuilder formattedList = getFormattedList();
            BufferedWriter writer = new BufferedWriter(new FileWriter("result.out"));
            logger.error("result.out has been created");
            writer.write(formattedList.toString());
            writer.close();
            logger.error("File has been written");
        } catch (IOException e){
            logger.error("Cannot write in file");
        } catch (IllegalArgumentException e){
            logger.error("List is empty, nothing to print");
        }
    }
}
