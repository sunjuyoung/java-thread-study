package thread.start;

public class HelloThreadMain {

    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName() + " : main() start");

        HelloThread helloThread = new HelloThread();
        System.out.println(Thread.currentThread().getName() + " : start() 호출전");
        helloThread.start(); //메인스레드는 실행하라고 던져놓고 기다리지 않고 다음 작업을 수행한다. -> main 과 thread-0.은 동시에(같이) 실행된다
        //메인스레드가 thread-0을 실행하는게 아니다
        System.out.println(Thread.currentThread().getName() + " : start()호출 후 ");

        System.out.println(Thread.currentThread().getName() + " : end....");


    }
}
