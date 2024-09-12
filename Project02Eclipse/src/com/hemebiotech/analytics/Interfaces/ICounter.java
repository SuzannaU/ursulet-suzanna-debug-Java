package Interfaces;

import java.io.IOException;
import java.util.Map;

import Exceptions.EmptyListException;

public interface ICounter {
    public Map<String, Integer> countSymptoms() throws IOException, EmptyListException;
}
