package Logger;

import javax.net.ssl.HandshakeCompletedEvent;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.StreamHandler;

class LogToOutputstreamClass implements LogToOutputStream, ReturnTypes{
    private String name = "file's not specified";// имя объекта, метода или класса
    private Logger logger = null;
    private Handler handler;


    private Logger getConsoleLogger(){
        return Logger.getLogger(this.getClass().getName());
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

    @Override
    public Handler getStreamHandler() {
        return new StreamHandler();
    }

    @Override
    public void logItToOutputStream() {
        logger = getConsoleLogger();
        handler = getStreamHandler();
        logger.addHandler(handler);
        logger.info(name + " " + LocalDateTime.now());
    }
}