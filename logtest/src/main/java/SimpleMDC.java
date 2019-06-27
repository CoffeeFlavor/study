import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * @author : seven
 * date: 22/03/2019
 * time: 14:26
 */
public class SimpleMDC {

    public static void main(String[] args) {
        MDC.put("first", "Dorathy");

        final Logger logger = LoggerFactory.getLogger(SimpleMDC.class);
        MDC.put("last", "Parker");

        logger.info("Check enclosed");
        logger.debug("The most beautiful two words in English");

        MDC.put("first", "Richard");
        MDC.put("last", "Nixon");
        logger.info("I am not a crook.");
        logger.info("Attributed to the former US president. 17 Nov 1973.");

        new Thread(new Runnable() {
            public void run() {
                MDC.put("first", "jennie");
                MDC.put("last", "liu");
                logger.info("I am not a girl.");

            }
        }).start();
    }
}
