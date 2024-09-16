package interfaces;

import java.io.IOException;

import exceptions.EmptyListException;

/**
 * Formats list generated with ICounter
 */
public interface IFormatter {
    public StringBuilder format(ICounter counter) throws IOException, EmptyListException;
}
