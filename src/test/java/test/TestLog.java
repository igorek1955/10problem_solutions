package test;

import org.apache.commons.logging.Log;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestLog {
    public static final Logger logger = Logger.getLogger(TestLog.class.getName());

    public static void main(String[] args) {
        logger.log(Level.INFO, "ok");
        TestLog test = new TestLog();
        test.coolio();
    }

    void coolio(){
        Logger logger2 = Logger.getLogger(this.toString());
        System.out.println("coolio");
        logger2.log(Level.INFO,"sup");
    }

}


