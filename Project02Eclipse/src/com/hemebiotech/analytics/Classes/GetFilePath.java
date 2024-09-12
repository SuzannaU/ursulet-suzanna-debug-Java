package Classes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * Abstract Class to set filepath as attribute for all classes extending
 */
public abstract class GetFilePath {
    private static Logger logger = LogManager.getLogger(GetFilePath.class);
    protected String filepath;

    public GetFilePath (String filepath){
        this.filepath = filepath;
        logger.error("filepath recovered");
    }
}
