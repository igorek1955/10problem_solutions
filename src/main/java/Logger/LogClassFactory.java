package Logger;

public class LogClassFactory implements AbstractFactory {
    private String name;


    @Override
    public LogToConsole getLTC() {
        return new LogToConsoleClass();
    }

    @Override
    public LogToFileClass getLTF(String filePath) {
        //filePathIgnored
        LogToFileClass l = new LogToFileClass();
        l.setPathForHandler("C:\\Users\\Igor\\Desktop\\test.txt");
        return l;
    }

    @Override
    public LogToOutputStream getLTO() {
        return null;
    }
}
