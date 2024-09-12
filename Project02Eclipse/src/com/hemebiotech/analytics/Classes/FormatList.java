package Classes;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Exceptions.EmptyListException;
import Interfaces.IFormatter;

public class FormatList extends GetFilePath implements IFormatter {
    private static Logger logger = LogManager.getLogger(FormatList.class);
    private CountSymptoms rawSymptomsQuantity;

    public FormatList (String filepath) {
		super (filepath);
        this.rawSymptomsQuantity = new CountSymptoms(this.filepath);
	}
    @Override
    public StringBuilder formatSymptomsList () throws IOException, EmptyListException {
        StringBuilder formattedList = new StringBuilder();
        try{
            Map<String,Integer> rawSymptomsQuantity = this.rawSymptomsQuantity.countSymptoms();
            Set<String> symptoms = rawSymptomsQuantity.keySet();
            formattedList.append("List of symptoms and their occurence:\n");
            for(String symptom : symptoms){
                Integer quantity = rawSymptomsQuantity.get(symptom);
                formattedList.append(symptom + " : " + quantity + "\n");
                //logger.error("symptom appended");
            }
        }catch (IOException | EmptyListException e){
            logger.error("rawSymptomsList is empty, formattedList is not created");
            throw new EmptyListException();
        }
        logger.error("formattedList is created");
        return formattedList;
    }
    public StringBuilder getFormattedList() throws IOException, EmptyListException{
        return formatSymptomsList();
	}
	public void printFormattedList() throws IOException, EmptyListException{
		try{
			System.out.println(formatSymptomsList().toString());
		}catch (IOException | EmptyListException e) {
			logger.error("Cannot print any symptoms");
		}
	}
}
