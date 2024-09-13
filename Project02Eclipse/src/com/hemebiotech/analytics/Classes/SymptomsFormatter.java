package Classes;

import java.io.IOException;
import java.util.Set;
import java.util.Map;

import Exceptions.EmptyListException;
/**
 * @see Interfaces.IFormatter
 * Formats a K-V of symptoms and their quantities into a StringBuilder of one 'symptom: quantity' per line
 */
import Interfaces.*;

public class SymptomsFormatter implements IFormatter {
    private ICounter rawSymptomsQuantity;

    public SymptomsFormatter(ICounter rawSymptomsQuantity) {
        this.rawSymptomsQuantity = rawSymptomsQuantity;
    }

    /**
     *
     * @param rawSymptomsQuantity from CountSymptoms Class
     * @return StringBuilder with one 'symtpom: quantity' per line
     * @throws EmptyListException
     * @throw IOException if source file not accessible or does not exist
     *        EmptyListException if the raw list of entry was empty
     */
    @Override
    public StringBuilder format() throws IOException, EmptyListException {
        StringBuilder formattedList = new StringBuilder();
        Map<String, Integer> map = this.rawSymptomsQuantity.count();
        Set<String> symptoms = map.keySet();
        formattedList.append("List of symptoms and their occurence:\n");
        for (String symptom : symptoms) {
            Integer quantity = map.get(symptom);
            formattedList.append(symptom + ": " + quantity + "\n");
            // logger.error("symptom appended"); //to be used as utility
        }
        return formattedList;
    }
}
