package util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public abstract class MyLogger {

    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

    public static void log(Object obj){
        String time = LocalTime.now().format(formatter);
        System.out.printf("%s [%9s] %s\n", time, Thread.currentThread().getName(), obj);
//        참고로 마지막의 출력할 객체는 문자열이 아니라 Object 타입인데, %s 를 사용하면 toString() 을 사
//용해서 문자열로 변환 후 출력한다. 이렇게 Object 타입을 사용하면 문자열 뿐만 아니라 객체도 출력할
//수 있다


    }
}
