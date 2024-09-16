package classes;

import java.io.IOException;
import java.util.Set;
import java.util.Map;
import exceptions.EmptyListException;
import interfaces.*;

public class SymptomsFormatter implements IFormatter {
	private Map<String, Integer> rawQuantities;

	public SymptomsFormatter(Map<String, Integer> rawQuantities) {
		this.rawQuantities = rawQuantities;
	}

    /**
     * Formats a Map of symptoms/quantities into a StringBuilder ready to be written
     *
     * @param  Map<String, Integer> from constructor attribute
     * @return StringBuilder with one 'symtpom: quantity' per line
     * @throws EmptyListException EmptyListException if the raw list of entry was
     *                            empty
     * @throws IOException        if source file not accessible or does not exist
     *                            EmptyListException if the raw list of entry was
     *                            empty
     */
    @Override
    public StringBuilder format() throws IOException, EmptyListException {
        StringBuilder formattedList = new StringBuilder();
        Map<String, Integer> map = rawQuantities;
        Set<String> items = map.keySet();
        formattedList.append("List of symptoms and their occurence:\n");
        for (String item : items) {
            Integer quantity = map.get(item);
            formattedList.append(item + ": " + quantity + "\n");
        }
        return formattedList;
    }
}
