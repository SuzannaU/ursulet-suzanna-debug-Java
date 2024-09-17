package classe;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import exception.EmptyListException;
import interface2.*;

/**
 * @see interfaces.IWriter
 * 
 * Formats then writes results in output file
 * 
 * Calls format method
 * @see classes.SymptomsFormatter 
 *
 */
public class OutputFileWriter implements IWriter {
    private static Logger logger = LogManager.getLogger(OutputFileWriter.class);
    private Map<String, Integer> rawQuantities;

    public OutputFileWriter(Map<String, Integer> rawQuantities) {
        this.rawQuantities = rawQuantities;
    }

    /**
     * Calls format method 
     * @see classes.SymptomsFormatter
     * 
     * @param Map<String, Integer> from constructor attribute
     * @return StringBuilder to be written
     * @throws IOException
     * @throws EmptyListException
     */
    public StringBuilder format(Map<String, Integer> rawQuantities) throws IOException, EmptyListException {
        StringBuilder formattedList = new StringBuilder();
        IFormatter formatter = new SymptomsFormatter(this.rawQuantities);
        formattedList = formatter.format();
        return formattedList;
    }

    /**
     *
     * @param outputFileName
     * @return void / creates file and writes in it
     * @throws EmptyListException EmptyListException if the raw list of entry is
     *                            empty
     * @throws IOException        if output file cannot be written
     */
    @Override
    public void write(String outputFileName) {
        try {
            StringBuilder stringBuilder = format(this.rawQuantities);
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));
            logger.info("result.out is created");
            writer.write(stringBuilder.toString());
            writer.close();
            logger.info("File has been written");
        } catch (IOException e) {
            logger.error("Cannot write in file");
        } catch (EmptyListException e3) {
            logger.error("List empty, nothing to write");
        }
    }
}
