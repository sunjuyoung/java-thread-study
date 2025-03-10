package thread.start;

public class DaemonThreadMain {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "main() start");
        DaemonThread daemonThread = new DaemonThread();

//        tDaemon(true) : 데몬 스레드로 설정한다.
//데몬 스레드 여부는 start() 실행 전에 결정해야 한다. 이후에는 변경되지 않는다

        daemonThread.setDaemon(true);
        daemonThread.start();

        System.out.println(Thread.currentThread().getName() + "main() end");
    }

    static class DaemonThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " run()");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + ": end()");
        }
    }
}
