package Interfaces;

import java.io.IOException;

import Exceptions.EmptyListException;

public interface IFormatter {
    public StringBuilder formatSymptomsList () throws IOException, EmptyListException;
}
