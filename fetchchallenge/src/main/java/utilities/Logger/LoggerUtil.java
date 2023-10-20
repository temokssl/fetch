package main.java.utilities.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class LoggerUtil {
	private static Logger logger;

    static {
        logger = LogManager.getLogger(LoggerUtil.class);
    }

    public static void logInfo(String message) {
        logger.info(message);
    }

    public static void logWarning(String message) {
        logger.warn(message);
    }

    public static void logError(String message) {
        logger.error(message);
    }
}