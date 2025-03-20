package thread.control.yield;

public class YieldMain {


    static final int THEAD_COUNT = 100;

    public static void main(String[] args) {


        Thread thread = new Thread(new MyRunnder());




        thread.start();
    }



    static class MyRunnder implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                Thread.yield();
            }
        }
    }
}
