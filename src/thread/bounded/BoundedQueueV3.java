package thread.bounded;

import java.util.ArrayDeque;
import java.util.Queue;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BoundedQueueV3 implements BoundedQueue{

    private final Queue<String> queue = new ArrayDeque<>();
    private final int max;

    public BoundedQueueV3(int max) {
        this.max = max;
    }

    @Override
    public synchronized void put(String data) {
        //queue 가득차면 버리지 말고 대기
        while(queue.size() == max){
            log("Queue is full, data 생산자 대기 " + data);
            try {
                wait();//RUNNABLE -> WAITING, 락은 반납 ,this생략
                log("생산자 깨어남");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        queue.offer(data);
        //대기중인 소비자 있으면 깨워라
        log("생산자 데이터 저장 ,notify 호출");
        notify();// WAITING -> RUNNABLE

    }

    @Override
    public synchronized   String take() {
        while(queue.isEmpty()){
            log("Queue is empty, 소비자 대기");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        String poll = queue.poll();
        log("소비자 데이터 획득, notify 호출");
        notify();
        return poll;
    }

    @Override
    public String toString() {
        return "" +
                "queue = " + queue +
                ", max = " + max +
                '}';
    }
}
