package thread.start;

import static util.MyLogger.log;

public class ManyThreadMainV1 {

    public static void main(String[] args) {
        log("main start");

        HelloRunnable run = new HelloRunnable();
        Thread thread1 = new Thread(run);
        thread1.start();
        Thread thread2 = new Thread(run);
        thread2.start();
        Thread thread3 = new Thread(run);
        thread3.start();
        log("main end");


    }
}
