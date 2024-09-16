package classes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import exceptions.EmptyListException;
import interfaces.ICounter;
import interfaces.IFormatter;
import interfaces.IWriter;

/**
 * @see interfaces.IWriter
 *      formats then writes results in output file
 *
 */
public class OutputFileWriter implements IWriter {
    private static Logger logger = LogManager.getLogger(OutputFileWriter.class);
    private ICounter counter;

    public OutputFileWriter(ICounter counter) {
        this.counter = counter;
    }

    /**
     * Calls format method
     * @see classes.SymptomsFormatter
     * 
     * @param counter
     * @return StringBuilder to be written
     * @throws IOException
     * @throws EmptyListException
     */
    public StringBuilder format(ICounter counter) throws IOException, EmptyListException {
        StringBuilder formattedList = new StringBuilder();
        IFormatter formatter = new SymptomsFormatter();
        formattedList = formatter.format(counter);
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
            StringBuilder stringBuilder = format(this.counter);
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
