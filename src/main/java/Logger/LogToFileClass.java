package Logger;

import java.io.IOException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

class LogToFileClass implements LogToFile, ReturnTypes{
    private String name; // имя объекта, метода или класса
    private Logger logger = null;
    private Handler handler;
    private String filePath;



    @Override
    public Handler getFileHandler() {
        try {
            handler = new FileHandler(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return handler;
    }

    private Logger getFileLogger(){
        return Logger.getLogger(this.getClass().getName());
    }

    @Override
    public void logItToFile() {
        logger = getFileLogger();
        handler = getFileHandler();
        logger.addHandler(handler);
        logger.info(name + " " + LocalDateTime.now());
    }

    @Override
    public void setPathForHandler(String string) {
        this.filePath = string;
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
