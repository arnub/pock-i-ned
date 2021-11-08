package at.kauderwelsch;

import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExampel {
    private static final Logger log = LoggerFactory.getLogger(LoggingExampel.class);

    public void exceptionHandler(){
        try {
            doSOmething();
        } catch (Exception e) {
            System.out.println("---");
            log.debug("error oc.",e);
            System.out.println("END OF ");
        }
    }

    int doSOmething(){
        try {
            return 1 / 0;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public static void soutStackTrace(Exception e){
        System.out.println("soutStackTrace:\n" + e.getStackTrace());
    }

    public static void soutStackTraceWithinAStream(Exception e){
        System.out.println("soutStackTraceWithinAStream:");
        Stream.of(e.getStackTrace()).forEach(toBePrinted -> System.out.println(toBePrinted));
    }

    public static void soutStackTraceWithFor(Exception e){
        System.out.println("soutStackTraceWithFor:");
        for (int i = 0; i < e.getStackTrace().length; i++) {
            System.out.println("I:" + i);
            System.out.println(e.getStackTrace()[i]);
        }
    }

    public static void soutExcMessage(Exception e){
        System.out.println("soutExcMessage:\n" + e.getMessage());
    }

    public static void soutExcCause(Exception e){
        System.out.println("soutExcCause:\n" + e.getCause());
    }

    public static void soutExcLocalizedMessage(Exception e){
        System.out.println("soutExcLocalizedMessage:\n" + e.getLocalizedMessage());
    }

    public static void soutExcClass(Exception e){
        System.out.println("soutExcClass:\n" + e.getClass());
    }

    public static void soutStackTraceWithForEach(Exception e){
        System.out.println("soutStackTraceWithForEach:");
        for(StackTraceElement element : e.getStackTrace()){
            System.out.println(element);
        }
    }

    public static void soutExc(Exception e){
        System.out.println("soutExc:\n" + e);
    }
}
