package DeokJae;

import java.util.ArrayList;

public class DPR1DAO {

//	public int showDepositLeft(MemberProfile mp) {
//		int balance = prDao.callDepositLeft(mp);
//		return balance;
//	}
	public ArrayList<DPR1Recharge> DPR1List(DPR1Recharge dr){
		ArrayList<DPR1Recharge> drlist = new ArrayList<DPR1Recharge>();
		System.out.println("# DB서버에 넘겨줄 예치금 충전 데이터");
		System.out.println("입금내역:"+dr.getDepositH());
		System.out.println("금액:"+dr.getPrice());
		System.out.println("계좌주명:"+dr.getBankName());
		drlist.add(new DPR1Recharge("복권 예치금","5000원","동행복권_홍길동"));

		return drlist;
	}
}	
	
	
//	public String recharge(DPR1Recharge dr, Model d) {
//		System.out.println("# DB 처리(예치금 충전하기) #");
//		System.out.println(dr.getDepositH()); //입금내역 : 복권 예치금
//		System.out.println(dr.getPrice());	// 금액 
//		System.out.println(dr.getBankName());	// 계좌주명 : 동행복권_000
//		return "예치금 충전(가상계좌입금하기)"; //DB에서 받은 결과값을 가정.
