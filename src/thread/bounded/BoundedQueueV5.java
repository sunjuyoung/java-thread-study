package thread.bounded;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static util.MyLogger.log;

public class BoundedQueueV5 implements BoundedQueue{

    //lock 하난데 대기공간은 2개

    private final Lock lock = new ReentrantLock();
    private final Condition producerCond = lock.newCondition();
    private final Condition consumerCond = lock.newCondition();

    private final Queue<String> queue = new ArrayDeque<>();
    private final int max;

    public BoundedQueueV5(int max) {
        this.max = max;
    }

    @Override
    public  void put(String data) {
        lock.lock();
        try {
            while(queue.size() == max){
                log("Queue is full, data 생산자 대기 " + data);
                try {
                    //생산자는 생산자대기 공간에
                    producerCond.await();
                    
                    // this.wait()가 아닌 // wait() 메서드는 synchronized 블록 안에서만 호출할 수 있다.
                    log("생산자 깨어남");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            queue.offer(data);
            log("생산자 데이터 저장 ,notify 호출");
           // notify();// WAITING -> RUNNABLE
            consumerCond.signal();
        }finally {
            lock.unlock();
        }


    }

    @Override
    public    String take() {
        lock.lock();

        try {
            while(queue.isEmpty()){
                log("Queue is empty, 소비자 대기");
                try {
                    consumerCond.await();
                    log("소비자 깨어남");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            String poll = queue.poll();
            log("소비자 데이터 획득, notify 호출");
            producerCond.signal();
            return poll;
        }finally {
            lock.unlock();
        }

    }

    @Override
    public String toString() {
        return "" +
                "queue = " + queue +
                ", max = " + max +
                '}';
    }
}
