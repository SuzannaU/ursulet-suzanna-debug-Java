package Classes;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import Exceptions.EmptyListException;

import Interfaces.ICounter;
import Interfaces.IFormatter;
/**
 * @see Interfaces.IFormatter
 * Formats a K-V of symptoms and their quantities into a StringBuilder of one 'symptom: quantity' per line
 */
public class SymptomsFormatter extends GetFilePath implements IFormatter {
    private static Logger logger = LogManager.getLogger(SymptomsFormatter.class);
    private ICounter rawSymptomsQuantity;

    public SymptomsFormatter (String filepath) {
		super (filepath);
        this.rawSymptomsQuantity = new SymptomsCounter(this.filepath);
	}
	/**
	 *
	 * @param rawSymptomsQuantity from CountSymptoms Class
	 * @return StringBuilder with one 'symtpom: quantity' per line
	 * @throw IOException if source file not accessible or does not exist
	 * 		EmptyListException if the raw list of entry was empty
	 */
    @Override
    public StringBuilder formatter () throws IOException, EmptyListException {
        StringBuilder formattedList = new StringBuilder();
        try{
            Map<String,Integer> rawSymptomsQuantity = this.rawSymptomsQuantity.counter();
            Set<String> symptoms = rawSymptomsQuantity.keySet();
            formattedList.append("List of symptoms and their occurence:\n");
            for(String symptom : symptoms){
                Integer quantity = rawSymptomsQuantity.get(symptom);
                formattedList.append(symptom + ": " + quantity + "\n");
                //logger.error("symptom appended");	    //to be used as utility
            }
        }catch (IOException | EmptyListException e){
            logger.error("rawSymptomsList is empty, formattedList is not created");
            throw new EmptyListException();
        }
        logger.error("formattedList is created");
        return formattedList;
    }
	/**
	 * Utility function, not used in main process
	 * 
	 * @return StringBuilder with one 'symtpom: quantity' per line
	 * @throws IOException, EmptyListException
	 */
    public StringBuilder getFormattedList() throws IOException, EmptyListException{
        return formatter();
	}
	/**
	 * Utility function, not used in main process
	 * 
	 * @return Print list of one 'symtpom: quantity' per line in console
	 * @throws IOException, EmptyListException
	 */
	public void printFormattedList() throws IOException, EmptyListException{
		try{
			System.out.println(formatter().toString());
		}catch (IOException | EmptyListException e) {
			logger.error("Cannot print any symptoms");
		}
	}
}
