package thread.control.interrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ThreadStopMainV2 {

    public static void main(String[] args) {

        MyTask task = new MyTask();
        Thread thread1 = new Thread(task,"work");
        thread1.start();

        sleep(4000);
        log("작업 중단 지시 thread interrupt");
        thread1.interrupt();
        log("work 스레드 인터럽트 상태 1 :  " + thread1.isInterrupted());


    }

    static  class MyTask implements Runnable{


        volatile  boolean runFlag = true;

        @Override
        public void run() {



            try {
                while(runFlag) {
                    log("작업중..");
                    Thread.sleep(3000);
                }
                } catch (InterruptedException e) {
                log("work 스레드 인터럽트 상태2 : " + Thread.currentThread().isInterrupted() );
                log("message: " +e.getMessage());
                log("state  : " + Thread.currentThread().getState());
                }


            
            log("작업 정리");
            log("작업 종료");
        }
    }
}
