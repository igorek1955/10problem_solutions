package test;


public class Threads {
    public static void main(String[] args) {
        Thread t = new Thread(new SubThread4());
        t.start();
    }
}

interface Message{
    void showWarning();
}



class SubThread4 implements Message, Runnable {

    public void run(){
        try{
            while (!Thread.interrupted()){
                System.out.println("running");
                Thread.sleep(2000);
                showWarning();
            }
        } catch (Exception e){
            System.out.println("warning worked");
        }
    }

    @Override
    public void showWarning() {
        Thread.currentThread().interrupt();
    }
}

