package thread.start;

public class BadThreadMain {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " : main() start");

        HelloThread helloThread = new HelloThread();
        System.out.println(Thread.currentThread().getName() + " : start() 호출전");
        helloThread.run(); //메인스레드는 직접 실행하므로 순서대로 실행
        System.out.println(Thread.currentThread().getName() + " : start()호출 후 ");

        System.out.println(Thread.currentThread().getName() + " : end....");
    }
}
