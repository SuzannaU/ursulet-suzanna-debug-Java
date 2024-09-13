package Classes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import Exceptions.EmptyListException;
import Interfaces.IFormatter;
import Interfaces.IWriter;

/**
 * @see Interfaces.IWriter
 *      Create a result.out text file with the formatted list of symptom and
 *      quantities
 */
public class SymptomsWriter implements IWriter {
    private static Logger logger = LogManager.getLogger(SymptomsWriter.class);
    private IFormatter formattedList;

    public SymptomsWriter(IFormatter formattedList) {
        this.formattedList = formattedList;
    }

    /**
     *
     * @param formattedList from FormatList class
     * @return void / creates file and writes in it
     * @exception IOException        if unable to create file
     * @exception EmptyListException if source file not found or raw list of entry
     *                               was empty
     */
    @Override
    public void write(String resultFilePath) {
        try {
            StringBuilder stringBuilder = this.formattedList.format();
            BufferedWriter writer = new BufferedWriter(new FileWriter(resultFilePath));
            logger.error("result.out is created");
            writer.write(stringBuilder.toString());
            writer.close();
            logger.error("File has been written");
        } catch (IOException e) {
            logger.error("Cannot write in file");
        } catch (EmptyListException e3) {
            logger.error("List empty, nothing to write");
        }
    }
}
