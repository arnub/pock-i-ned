package at.kauderwelsch;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.javafx.runtime.SystemProperties;

import at.kauderwelsch.additional.email.EMailUtil;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException, MessagingException {
        log.info("main-method is running");

        System.out.println("SimpleEmail Start");

        final String fromEmail = ""; //requires valid gmail id (compl. mail)
        final String password = ""; // correct password for gmail id
        final String toEmail = ""; // can be any email id

        System.out.println("TLSEmail Start");
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

//        props.put("mail.mime.encodeparameters","true");

//        System.out.println(props.get("mail.mime.encodeparameters"));
        System.out.println("SYST PROP: " + SystemProperties.getProperty("mail.mimne.encodeparameters"));
        //create Authenticator object to pass in Session.getInstance argument
        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };
        Session session = Session.getInstance(props, auth);

        //String filename65 = "/Users/armin.rauscher/dev/pock-i-ned/src/main/resources/FilenameEquals65CHARS-ubrurn4idfhi4htiehdiuduiehdoejusdf4hdeh.pdf";
        //String filename65 = "/Users/armin.rauscher/dev/pock-i-ned/src/main/resources/653456789098765$%&()(JKL-=876780%&((LKBVG&%RFGLPJSDFV_PSKJRO4.pdf";
        //len = 70
        String filename65 = "/Users/armin.rauscher/dev/pock-i-ned/src/main/resources/Automation_Team_Directory_05-Dec-2015_123219_21312_155018252272708.PDF";
        EMailUtil.sendAttachmentEmail(session, toEmail,"TLSEmail Testing Subject", "TLSEmail Testing Body", filename65);

        //String filename60 = "/Users/armin.rauscher/dev/pock-i-ned/src/main/resources/FilenameEquals60CHARS-ubrurn4idfhi4htiehdiuduiehdoeju4hd.pdf";
        String filename60 = "/Users/armin.rauscher/dev/pock-i-ned/src/main/resources/6034567865$%&()(JKL-=876780%&((LKBVG&%RFGLPJSDFV_PSKJRO4.pdf";
        EMailUtil.sendAttachmentEmail(session, toEmail,"TLSEmail Testing Subject", "TLSEmail Testing Body",filename60);
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
