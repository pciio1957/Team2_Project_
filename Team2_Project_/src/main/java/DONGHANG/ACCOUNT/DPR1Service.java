package DONGHANG.ACCOUNT;

import java.util.ArrayList;


public class DPR1Service {
	DPR1DAO dao = new DPR1DAO();
	public ArrayList<DPR1Account> cntList;
	
	// 예치금 조회 화면
	public String listShow(DPR1Account cnt){
		System.out.println("# 서비스 단 처리#");
		System.out.println("DAO에 전송 데이터1:"+cnt.getAno());
		System.out.println("DAO에 받은 데이터 크기:"+
				dao.listshow(cnt).size());
		cntList = dao.listshow(cnt); 
		
		for(DPR1Account a:cntList) {
			if(a.getAno().equals(cnt.getAno())) {
				System.out.println("계좌주 : " + a.getAno());
				System.out.println("계좌번호 : " + a.getOwner());
				System.out.println("초기입금액 : " + a.getBalance());

			}
			
		}
		
		return "조회완료";
	}
	public String rechange(DPR1Account aco, int str) {
		System.out.println("# 서비스 #");
		
		// 가상계좌 - 임의 계좌번호
		cntList = dao.listshow(aco); 
		
		int cnt = 0;
		for(DPR1Account a:cntList) {
			if(a.getAno().equals(aco.getAno())) {
				System.out.println("# service : 해당되는 데이터가 있음 #");
//				System.out.println("계좌주 : " + a.getAno());
//				System.out.println("계좌번호 : " + a.getOwner());
				System.out.println("초기입금액 : " + a.getBalance());
				System.out.println("입력 입금액 : " + str);
				int money = a.getBalance();
				int tot = money + str;
				
				DPR1Account account = new DPR1Account(a.getAno(), a.getOwner(), tot);
				dao.recharge(account, cnt);
			}
			cnt++; 
		}
		
		return "충전 완료";
	}
	public String withdraw(DPR1Account aco, int str1) {
		System.out.println("# 서비스 #");
		
		// 가상계좌 - 임의 계좌번호
		cntList = dao.listshow(aco); 
		
		int cnt = 0;
		for(DPR1Account a:cntList) {
			if(a.getAno().equals(aco.getAno())) {
				System.out.println("# service : 해당되는 데이터가 있음 #");
//				System.out.println("계좌주 : " + a.getAno());
//				System.out.println("계좌번호 : " + a.getOwner());
				System.out.println("초기입금액 : " + a.getBalance());
				System.out.println("입력한 출금액 : " + str1);
				int money1 = a.getBalance();
				int tot = money1 - str1;
				
				DPR1Account account = new DPR1Account(a.getAno(), a.getOwner(), tot);
				dao.withdraw(account, cnt);
			}
			cnt++; 
		}
		return "출금 완료";
	}
	
//	private ArrayList<DPR1Recharge> DPR1List = new ArrayList<DPR1Recharge>();
//	DPR1DAO dao1 = new DPR1DAO();
//	public ArrayList<DPR1Recharge>  DPR1List(DPR1Recharge dr){
//		System.out.println("# 서비스단 처리#");
//		System.out.println("DPR1DAO에 전송 할 예치금 입력 데이터");
//		System.out.println("DPR1DAO에서 받을 예치금 입력 데이터 크기:"+ dao1.DPR1List(dr).size());
//		return dao1.DPR1List(dr);
//		
//		}
	
	}
	
/*
	DPR1DAO dao = new DPR1DAO();
	
	public ArrayList<DPR1Recharge>  DPR1List(DPR1Recharge dr){
		System.out.println("# 서비스단 처리#");
		System.out.println("DPR1DAO에 전송 할 예치금 입력 데이터");
		System.out.println("DPR1DAO에서 받을 예치금 입력 데이터 크기:"+ dao.DPR1List(dr).size());
		return dao.DPR1List(dr); */
