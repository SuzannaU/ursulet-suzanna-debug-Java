package interfaces;

import java.io.IOException;
import exceptions.EmptyListException;

/**
 * Formats into a StringBuilder
 */
public interface IFormatter {
    public StringBuilder format() throws IOException, EmptyListException;
}
