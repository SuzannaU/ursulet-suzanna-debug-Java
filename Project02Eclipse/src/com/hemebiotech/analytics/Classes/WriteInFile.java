package Classes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Exceptions.EmptyListException;

public class WriteInFile extends GetFilePath {
    private static Logger logger = LogManager.getLogger(WriteInFile.class);
    private FormatList formattedList;

    public WriteInFile (String filepath) {
		super (filepath);
        this.formattedList = new FormatList(this.filepath);
	}
    public void writeInFile (){
        try{
            StringBuilder formattedList = this.formattedList.formatSymptomsList();
            BufferedWriter writer = new BufferedWriter(new FileWriter("result.out"));
            logger.error("result.out is created");
            writer.write(formattedList.toString());
            writer.close();
            logger.error("File has been written");
        } catch (IOException e){
            logger.error("Cannot write in file");
        } catch (EmptyListException e){
            logger.error("rawSymptomsList is empty, no file created");
        }
    }
}
