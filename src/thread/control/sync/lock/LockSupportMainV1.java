package thread.control.sync.lock;

import java.util.concurrent.locks.LockSupport;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class LockSupportMainV1 {

    public static void main(String[] args) {

        Thread thread1 = new Thread(new ParkTask(),"park-1");
        thread1.start();

        //잠시 대기하여 park-1
        sleep(100);
        log("park-1 state : "+thread1.getState());

        LockSupport.unpark(thread1); //park-1 스레드를 실행 상태로 만든다. Runnable 상태로 만든다.

        //thread1.interrupt(); //wait 상태로 만들어진 스레드를 interrupt하면 깨울수있다


    }


    static class ParkTask implements Runnable {
        @Override
        public void run() {
            log("park 시작");
            LockSupport.park(); //스레드를 waiting 상태로 만든다.
            log("park 종료, state: " + Thread.currentThread().getState());
            log("인터럽트 상태: " + Thread.currentThread().isInterrupted());
        }
    }
}
