package thread.control.interrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ThreadStopMainV4 {

    //Thread.interrupted(), Thread.currentThread().isInterrupted() 차이점
    //Thread.interrupted() : 현재 스레드의 인터럽트 상태를 반환하고, 동시에 현재 스레드의 인터럽트 상태를 false로 변경한다.
    //Thread.currentThread().isInterrupted() : 현재 스레드의 인터럽트 상태를 반환한다. 인터럽트 상태는 변경하지 않는다.

    public static void main(String[] args) {

        MyTask task = new MyTask();
        Thread thread1 = new Thread(task,"work");
        thread1.start();

        sleep(500);
        log("작업 중단 지시 thread interrupt");
        thread1.interrupt();
        log("work 스레드 인터럽트 상태 1 :  " + thread1.isInterrupted());



    }

    static  class MyTask implements Runnable{

        @Override
        public void run() {

                while(!Thread.interrupted()) { //인터럽트 상태 변경한다
                    log("작업중..");
                }
                log("work 스레드 인터럽트 상태2 : " + Thread.currentThread().isInterrupted() );
                log("state  : " + Thread.currentThread().getState());


                //인터럽트 상태가 false 변경되었다


            log("작업 정리");
            log("작업 종료");
        }
    }
}
