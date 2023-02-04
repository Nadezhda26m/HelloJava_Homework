import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Logging {
    public static Logger createSimpleLogFile(String path, String fileName,
                                             boolean append) throws Exception {
        Logger logger = Logger.getLogger(Class.class.getName());
        FileHandler fh = new FileHandler("%s%s".formatted(path, fileName), append);
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);
        return logger;
    }
}
