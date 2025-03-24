package thread.control.sync;

public interface BankAccount {

    //출금, 계좌 잔액보다 출금액이 많으면 false 리턴
    boolean withdraw(int amount);

    //잔액 조회
    int getBalance();
}
