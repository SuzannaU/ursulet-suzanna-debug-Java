package Interfaces;

import java.io.IOException;
import java.util.TreeMap;

import Exceptions.EmptyListException;

/**
 * formats the raw list of symptoms: quantity to one per line
 */
public interface IFormatter {
    public StringBuilder format() throws IOException, EmptyListException;
}
