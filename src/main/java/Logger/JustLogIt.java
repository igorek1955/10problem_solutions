package Logger;
import org.apache.commons.logging.Log;

import java.util.logging.Handler;



public class JustLogIt {
    public static void main(String[] args) throws Exception {
        LogClassFactory lcf = new LogClassFactory();
        LogToFileClass log = lcf.getLTF("df"); //выбираем логирование в файл
        log.setMethod();//выбираем логирование метода в файл
        log.logItToFile();//логируем
    }
}


    interface ReturnTypes{
        void setObject();
        void setClazz();
        void setMethod();
    }



    interface LogToConsole{
        Handler getConsoleHandler();
        void logItToConsole();
    }

    interface LogToFile{
        Handler getFileHandler();
        void logItToFile();
        void setPathForHandler(String string);
    }

    interface LogToOutputStream{
        Handler getStreamHandler();
        void logItToOutputStream();
    }

    interface AbstractFactory{
        LogToConsole getLTC();
        LogToFile getLTF(String filePath);
        LogToOutputStream getLTO();
    }





