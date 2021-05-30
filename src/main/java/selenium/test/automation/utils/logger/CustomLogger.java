package selenium.test.automation.utils.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomLogger {

    private static Logger logger;

    public CustomLogger() {
        logger = LogManager.getLogger("LOG");
    }

    public void info (String message){
        logger.info(message);
    }

    public void error (String message) {
        logger.error(message);
    }
}