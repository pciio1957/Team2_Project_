package Deposit;

import java.util.Scanner;

public class BankApplication {
	private static DPR1Account[] accountArray = new DPR1Account[100];
private static Scanner scanner = new Scanner(System.in);
static int num = 0;
public static void main(String[] args) {
    boolean run = true;
    while (run) {
        System.out.println("----------------------------------------");
        System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료 ");
        System.out.println("----------------------------------------");
        System.out.print("선택 >> ");

        int selectNo = scanner.nextInt();

        if (selectNo == 1) {
            createAccount();
        } else if (selectNo == 2) {
            accountList();
        } else if (selectNo == 3) {
            deposit();
        } else if (selectNo == 4) {
            withdraw();
        } else if (selectNo == 5) {
            System.exit(0);
        } else {
            System.out.println("잘못된 값을 입력 하였습니다.");
        }
    }

}

//계좌 생성 하기
private static void createAccount() {
    String ano = null;
    String owner = null;
    int balance = 0;
    accountArray[num] = new DPR1Account(ano, owner, balance);
    System.out.println("------");
    System.out.println("계좌 생성");
    System.out.println("------");
    System.out.print("계좌번호 : ");
    ano = scanner.next();
    accountArray[num].setAno(ano); 
    System.out.print("계좌주 : ");
    owner = scanner.next();
    accountArray[num].setOwner(owner);
    System.out.print("초기입금액 : ");
    balance = scanner.nextInt();
    accountArray[num].setBalance(balance);
    System.out.println("결과 : 계좌가 생성되었습니다.");

    num++;
}

// 계좌 목록 보기
private static void accountList() {
    for (int i = 0 ; i < num; i++ ) {
        System.out.println(accountArray[i].getAno()+"\t"+accountArray[i].getOwner()+"\t"+accountArray[i].getBalance());
    }
}

// 예금하기
private static void deposit() {
    System.out.println("------");
    System.out.println("예금");
    System.out.println("------");
    System.out.print("계좌번호 : ");
    String ano = scanner.next();
    System.out.print("예금액 : ");
    findAccount(ano).setBalance(findAccount(ano).getBalance() + scanner.nextInt());
    System.out.println("결과 : 예금이 성공되었습니다.");
}

// 출금하기
private static void withdraw() {
    System.out.println("------");
    System.out.println("출금");
    System.out.println("------");
    System.out.println("계좌번호  : ");
    String ano = scanner.next();
    System.out.print("출금액 : ");
    int remain = findAccount(ano).getBalance() - scanner.nextInt();
    if (remain < 0) {
        System.out.println("결과 : 출금 가능액을 초과하였습니다.");
    } else {
        findAccount(ano).setBalance(remain);
        System.out.println("결과 : 출금이 성공되었습니다.");
    }
    
    
}

// Account 배열에서 ano와 동일한 Account 객체 찾기
private static DPR1Account findAccount(String ano) {
    for (int i = 0 ; i < num; i++) {
        if (accountArray[i].getAno().equals(ano)) {
            return accountArray[i];
        }
    }
    System.out.println("해당 계좌번호를 찾을 수 없습니다.");
    return null;
}
}