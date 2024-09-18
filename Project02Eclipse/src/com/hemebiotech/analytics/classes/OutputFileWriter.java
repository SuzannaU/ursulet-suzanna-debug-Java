package classes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import exceptions.EmptyListException;
import interfaces.IWriter;

/**
 * Writes results in output file
 * 
 * @see interfaces.IWriter
 */
public class OutputFileWriter implements IWriter {
    private static Logger logger = LogManager.getLogger(OutputFileWriter.class);
    private StringBuilder formattedList;

    public OutputFileWriter(StringBuilder formattedList) {
        this.formattedList = formattedList;
    }

    /**
     *
     * @param outputFileName
     * @return void / creates file and writes in it
     * @throws EmptyListException EmptyListException if the raw list of entry is
     *                            empty
     * @throws IOException        if output file cannot be written
     */
    public void write(String outputFileName) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));
            logger.info("result.out is created");
            writer.write(formattedList.toString());
            writer.close();
            logger.info("File has been written");
        } catch (IOException e) {
            logger.error("Cannot write in file");
        }
    }
}
