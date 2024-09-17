package interface2;

import java.io.IOException;

import exception.EmptyListException;

/**
 * Formats into a StringBuilder
 */
public interface IFormatter {
    public StringBuilder format() throws IOException, EmptyListException;
}
