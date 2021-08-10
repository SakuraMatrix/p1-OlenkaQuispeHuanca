import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class App {

    public static void main(String[] args){
        Logger logger = LoggerFactory.getLogger(App.class);
        logger.info("Application starting...");

        System.out.println("Hello World!");
    }

}
