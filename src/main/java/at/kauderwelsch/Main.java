package at.kauderwelsch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException {
        log.info("main-method is running");
        doTestLoggingExample();
    }

    /**
     * example for logback logging on file and autoscan to load changed configuration without restarting service.
     * @throws InterruptedException
     */
     public static void doTestLoggingExample() throws InterruptedException {
         LoggingExampel loggingExampel = new LoggingExampel();
         do{
             loggingExampel.exceptionHandler();
             //Thread.sleep(800);
             Thread.sleep(30000);
         } while(true);
     }
}
