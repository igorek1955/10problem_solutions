package Logger;

import java.time.LocalDateTime;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

class LogToConsoleClass implements LogToConsole, ReturnTypes{
    private String name = "file's not specified";// имя объекта, метода или класса
    private Logger logger = null;
    private Handler handler;



    @Override
    public Handler getConsoleHandler() {
        handler = new ConsoleHandler();
        return handler;
    }

    private Logger getConsoleLogger(){
        return Logger.getLogger(this.getClass().getName());
    }

    @Override
    public void logItToConsole() {
        logger = getConsoleLogger();
        logger.info(name + " " + LocalDateTime.now());
    }


    @Override
    public void setObject() {
        this.name = "Object Name";
    }

    @Override
    public void setClazz() {
        this.name = "Class Name";
    }

    @Override
    public void setMethod() {
        this.name = "Method Name";
    }
}