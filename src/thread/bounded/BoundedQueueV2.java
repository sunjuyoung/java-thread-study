package thread.bounded;

import java.util.ArrayDeque;
import java.util.Queue;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BoundedQueueV2 implements BoundedQueue{

    private final Queue<String> queue = new ArrayDeque<>();
    private final int max;

    public BoundedQueueV2(int max) {
        this.max = max;
    }

    @Override
    public synchronized void put(String data) {
        //queue 가득차면 버리지 말고 대기
        while(queue.size() == max){
            log("Queue is full, data 생산자 대기 " + data);
            sleep(1000);
        }
        queue.offer(data);

    }

    @Override
    public synchronized   String take() {
        while(queue.isEmpty()){
            log("Queue is empty, 소비자 대기");
            sleep(1000);
        }
        return queue.poll();
    }

    @Override
    public String toString() {
        return "" +
                "queue = " + queue +
                ", max = " + max +
                '}';
    }
}
