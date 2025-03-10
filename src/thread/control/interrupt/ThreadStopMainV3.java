package thread.control.interrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ThreadStopMainV3 {

    public static void main(String[] args) {

        MyTask task = new MyTask();
        Thread thread1 = new Thread(task,"work");
        thread1.start();

        sleep(1000);
        log("작업 중단 지시 thread interrupt");
        thread1.interrupt();
        log("work 스레드 인터럽트 상태 1 :  " + thread1.isInterrupted());


    }

    static  class MyTask implements Runnable{

        @Override
        public void run() {

                while(!Thread.currentThread().isInterrupted()) { //인터럽트 상태확인 .변경 x
                    log("작업중..");
                }
                log("work 스레드 인터럽트 상태2 : " + Thread.currentThread().isInterrupted() );
                log("state  : " + Thread.currentThread().getState());

            log("작업 정리");
            log("작업 종료");
        }
    }
}
