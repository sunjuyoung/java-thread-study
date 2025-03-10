package thread.start;

import util.MyLogger;

import static util.MyLogger.*;

public class InnerRunnableMainV1 {

    public static void main(String[] args) {

        log("main() start");
        
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
        
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                log("run() 익명클래스");
            }
        });
        thread1.start();
        
        
        log("main() end");
    }


    //특정클래스안에서만 사용할때는 정적 이너 클래스
    
    static class MyRunnable implements Runnable{

        @Override
        public void run() {
           log("run()");

        }
    }

}
