package thread.control;

import util.MyLogger;
import util.ThreadUtils;

import static util.MyLogger.*;

public class ThreadStateMain {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new MyRunnable(), "myThread");
        log("myThread.state1 = "+ thread.getState());
        log("myThread.start()");
        thread.start();
        Thread.sleep(1000);

        log("main sleep end");

        log("myThread.state3 = "+ thread.getState()); //myrunnable이 sleep인 상태에서 자기 상태체크 불가
        //main에서 상태확인하면 TIMED_WAITING 확인가능
        Thread.sleep(3000);
        log("myThread.state3 = "+ thread.getState()); //Terminated
    }


    static class MyRunnable implements Runnable{

        @Override
        public void run() {
            log("start");
            Thread thread = Thread.currentThread();
            log("myTHread.state2 = "+ thread.getState()); //RUNNABLE
            log("sleep start");


            ThreadUtils.sleep(3000);

            log(" mythread sleep end");
        }
    }
}
