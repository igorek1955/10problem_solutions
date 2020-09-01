package test;

class Clock1 implements Runnable {
    public void run() {
        Thread currentThread = Thread.currentThread();

//        while (!currentThread.isInterrupted()) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException ignored) { }
//            System.out.println("Tik");
//        }

        //while внутри try - работает

        try{
            while (!currentThread.isInterrupted()){
                System.out.println("Tik");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e){
        }
    }
}


