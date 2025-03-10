package thread.control.join;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class JoinMainV3 {

    public static void main(String[] args) throws InterruptedException {
        log("start");


        SumTask task1 = new SumTask(1,50);
        SumTask task2 = new SumTask(51,100);

        Thread thread1 =  new Thread(task1, "thread-1");
        Thread thread2 =  new Thread(task2, "thread-2");

        thread1.start();
        thread2.start();

        //스레드가 종료 될때 까지 대기
        log("join() - main 스레드가 thread1,2 종료까지 대기합니다");
        thread1.join(1000); //terminated 될때까지 무기한 waiting , 시간을 넘기면 해당 시간까지만 대기한다.
       // thread2.join();
        log("join 완료 main스레드 대기 완료");

        log("task1 result = "+ task1.result);
        log("task2 result = "+ task2.result);


        int sumAll = task1.result + task2.result;
        log("taskAllSum = " + sumAll);


        log("End");
    }


    static class SumTask implements Runnable{

        int startValue;
        int endValue;
        int result;

        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public void run() {
            log("작업 시작");


            sleep(2000);
            int sum = 0;
            for(int i=startValue; i<endValue; i++){
                sum += i;
            }
            result = sum;


            log("작업 완료 result : "+ result );


        }
    }

    static class  Job implements Runnable{

        @Override
        public void run() {
            log("작업 시작");

            sleep(2000);

            log("작업 완료");
        }
    }
}
