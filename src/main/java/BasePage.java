import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BasePage {

    private static final Logger logger = LogManager.getLogger(BasePage.class);

    public static void main(String[] args) {

        logger.info("info message");
        logger.debug("debug message");
        logger.warn("warning message");
        logger.error("error message");
        logger.fatal("fatal message");
    }
}


