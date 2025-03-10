package thread.control.interrupt;

import util.MyLogger;

import static util.MyLogger.*;
import static util.ThreadUtils.sleep;

public class ThreadStopMainV1 {

    public static void main(String[] args) {

        MyTask task = new MyTask();
        Thread thread1 = new Thread(task,"work");
        thread1.start();

        sleep(4000);
        log("작업 중단 지시 runFlag = false");
        task.runFlag = false;

    }

    static  class MyTask implements Runnable{


        volatile  boolean runFlag = true;

        @Override
        public void run() {

            //runflag false를 해도  while문 안에 작업을완료하고 종료.. 바로 종료하는 방법은...
            while(runFlag){
                log("작업중..");
                sleep(3000);
                
            }
            
            log("작업 정리");
            log("작업 종료");
        }
    }
}
