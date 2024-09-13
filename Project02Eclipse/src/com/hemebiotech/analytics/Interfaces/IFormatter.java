package Interfaces;
import java.io.IOException;
import Exceptions.EmptyListException;
/**
 * formats the raw list of symptoms: quantity to one per line
 */
public interface IFormatter {
    public StringBuilder formatter() throws IOException, EmptyListException;
}
