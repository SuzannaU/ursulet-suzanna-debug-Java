package classes;

import java.io.IOException;
import java.util.Set;
import java.util.Map;
import exceptions.EmptyListException;
import interfaces.IFormatter;

/**
 * Formats a Map into a writable StringBuilder
 * 
 * @see interfaces.IReader
 */
public class SymptomsFormatter implements IFormatter {
    private Map<String, Integer> rawQuantities;
    private StringBuilder formattedList = new StringBuilder();

    public SymptomsFormatter(Map<String, Integer> rawQuantities) {
        this.rawQuantities = rawQuantities;
    }

    /**
     * Formats a Map of symptoms/quantities into a StringBuilder ready to be written
     * 
     * @param Map<String, Integer> from constructor attribute
     * @return StringBuilder with one 'symtpom: quantity' per line
     * @throws EmptyListException EmptyListException if the raw list of entry was
     *                            empty
     * @throws IOException        if source file not accessible or does not exist
     *                            EmptyListException if the raw list of entry was
     *                            empty
     */
    public StringBuilder formatSymptoms() throws IOException, EmptyListException {
        Set<String> items = rawQuantities.keySet();
        formattedList.append("List of symptoms and their occurence:\n");
        for (String item : items) {
            Integer quantity = rawQuantities.get(item);
            formattedList.append(item + ": " + quantity + "\n");
        }
        return formattedList;
    }
}
