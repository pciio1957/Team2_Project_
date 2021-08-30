package DONGHANG.ACCOUNT;

import java.util.Scanner;

public class DPR1Main {
	
	static DPR1Controller controller = new DPR1Controller();
	private static DPR1Account[] accountArray = new DPR1Account[100];
	private static Scanner scanner = new Scanner(System.in);
	static int num = 0;
//	private static boolean isCreated=false; // 계좌등록여부
	public static void main(String[] args) {

		// 예치금화면
//		DPR1Recharge dr1 = new DPR1Recharge("복권 예치금","5000원","동행복권_홍길동");
//		DPR1Controller dpr1ctrl = new DPR1Controller();
//		System.out.println("#호출된 화면#");
//		System.out.println(dpr1ctrl.DPR1List2(dr1, new Model()));
		
		DPR1Account cnt = new DPR1Account("[케이뱅크] 701-0303-637-8522","동행복권_홍길동",5000);
		DPR1Controller dpractrl = new DPR1Controller();
		System.out.println("#호출된 화면#");
		//System.out.println(dpractrl.cntList1(cnt, new Model()));
		
		// [1]계좌목록 [2]예치금 조회 [3]예치금 충전 [4] 예치금 출금 
		boolean run = true;
	    while (run) {
	        System.out.println("----------------------------------------");
	        System.out.println("1.계좌목록 | 2.예치금충전 | 3.출금 | 4.종료 ");
	        System.out.println("----------------------------------------");
	        System.out.print("입력 : ");
	        int selectNo = scanner.nextInt();
	        scanner.nextLine();
	        
	        if (selectNo == 1) {
	        	//accountList();
	        	System.out.println("회원의 이름을 입력하세요:");
	        	String name = scanner.nextLine();
	        	
	        	DPR1Account account01 = new DPR1Account(name);
	        	dpractrl.listShow(account01, new Model());
	        	
	        } else if (selectNo == 2) {
	        	//deposit(); 
	        	DPR1Account account01 = new DPR1Account("홍길동");
	        	System.out.println("충전할 금액을 입력하세요:");
	        	int str = scanner.nextInt();
	        	
	        	dpractrl.recharge(account01, str, new Model());
	        	
	        } else if (selectNo == 3) {
//	        	 withdraw(); 
	        	DPR1Account account01 = new DPR1Account("홍길동");
	        	System.out.println("출금할 금액을 입력하세요:");
	        	int str1 = scanner.nextInt();
	        	
	        	dpractrl.withdraw(account01, str1, new Model());
	        	
	        } else if (selectNo == 4) {
	        	System.exit(0);
	        } else {
	            System.out.println("잘못된 값을 입력 하였습니다.");
	        }
	    }

	}
}
	// 1 계좌 목록 보기 // 2 예치금 중전하기 // 3출금하기 
	
//	 1 계좌 목록 보기
//	private static void accountList() {
//	    for (int i = 0 ; i < num; i++ ) {
//	        System.out.println(accountArray[i].getAno()+"\t"+accountArray[i].getOwner()+"\t"+accountArray[i].getBalance());
//	    }
//	}
	// 2 예치금 중전하기
//	private static void deposit() {
//	    System.out.println("------");
//	    System.out.println("예금");
//	    System.out.println("------");
//	    System.out.print("계좌번호 : ");
//	    String ano = scanner.next();
//	    System.out.print("예금액 : ");
//	    findAccount(ano).setBalance(findAccount(ano).getBalance() + scanner.nextInt());
//	    System.out.println("결과 : 예금이 성공되었습니다.");
//	}
	// 3출금하기
//	private static void withdraw() {
//	    System.out.println("------");
//	    System.out.println("출금");
//	    System.out.println("------");
//	    System.out.println("계좌번호  : ");
//	    String ano = scanner.next();
//	    System.out.print("출금액 : ");
//	    int remain = findAccount(ano).getBalance() - scanner.nextInt();
//	    if (remain < 0) {
//	        System.out.println("결과 : 출금 가능액을 초과하였습니다.");
//	    } else {
//	        findAccount(ano).setBalance(remain);
//	        System.out.println("결과 : 출금이 성공되었습니다.");
//	    }
//	    
//	    
//	}
	
	// Account 배열에서 ano와 동일한 Account 객체 찾기
//	private static DPR1Account findAccount(String ano) {
//	    for (int i = 0 ; i < num; i++) {
//	        if (accountArray[i].getAno().equals(ano)) {
//	            return accountArray[i];
//	        }
//	    }
//	    System.out.println("해당 계좌번호를 찾을 수 없습니다.");
//	    return null;
//	}
//}


