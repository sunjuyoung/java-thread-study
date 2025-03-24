package thread.control.volat;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class VolatileFlagMain {

    public static void main(String[] args) {

        MyTask myTask = new MyTask();
        Thread thread = new Thread(myTask);

        log("runFlag = " + myTask.runFlag);
        thread.start();

        sleep(1000);

        log("작업 중단 지시 runFlag = false");
        myTask.runFlag = false;
        log("runFlag = " + myTask.runFlag);

    }

    static class MyTask implements Runnable{

        //boolean runFlag = true;
        volatile  boolean runFlag = true;

        @Override
        public void run() {
            log("작업 시작");
            while(runFlag) {
        
            }

            log("작업 종료");

        }
    }
}
