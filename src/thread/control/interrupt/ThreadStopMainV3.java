package thread.control.interrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ThreadStopMainV3 {

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

                while(!Thread.currentThread().isInterrupted()) { //인터럽트 상태확인 .변경 x
                    log("작업중..");
                }
                log("work 스레드 인터럽트 상태2 : " + Thread.currentThread().isInterrupted() );
                log("state  : " + Thread.currentThread().getState());

                //인터럽트상태가 계속 true인상태이다

            //이후 에 작업에서 만약 인터럽트 캐치 되었을때
            //의도치 않은 종료가 발생할수 있으므로
            //자바에서 인터럽트 예외가 한 번 발생하면, 스레드의 인터럽트 상태를 다시 정상( `
            // false`
            // )으로 돌리는 것은 이런 이유
            //때문이다. **
            // **
            //스레드의 인터럽트 상태를 정상으로 돌리지 않으면 이후에도 계속 인터럽트가 발생하게 된다. **
            // **
            //인터럽트의 목적을 달성하면 인터럽트 상태를 다시 정상으로 돌려두어야 한다. *

            log("작업 정리");
            log("작업 종료");
        }
    }
}
