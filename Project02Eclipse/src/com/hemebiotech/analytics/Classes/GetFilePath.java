package Classes;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class GetFilePath {
    private static Logger logger = LogManager.getLogger(GetFilePath.class);
    protected String filepath;

    public GetFilePath (String filepath){
        this.filepath = filepath;
        logger.error("filepath recovered");
    }
}
