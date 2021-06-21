package DeokJae;

import java.util.ArrayList;


public class DPR1DAO {
	
	// 계좌번호, 계좌주명, 예치금 
	public ArrayList<DPR1Account> cntList(DPR1Account cnt){
		ArrayList<DPR1Account> list = new ArrayList<DPR1Account>();
		System.out.println("# DB서버에 넘겨줄 검색 데이터#");
		System.out.println("계좌번호:"+cnt.getAno());
		System.out.println("계좌주:"+cnt.getOwner());
		System.out.println("예치금:"+cnt.getBalance());
		System.out.println("# DB 서버에서 온 데이터 리스트 #");
		list.add(new DPR1Account("[케이뱅크] 701-0303-637-8522","동행복권_홍길동",5000));
		for(DPR1Account acc:list) {
			System.out.print(acc.getAno()+"\t");
			System.out.print(acc.getOwner()+"\t");
			System.out.print(acc.getBalance()+"\t");
		}
		return list;
	}
}
	
	
//	public ArrayList<DPR1Recharge> DPR1List(DPR1Recharge dr){
//		ArrayList<DPR1Recharge> drlist = new ArrayList<DPR1Recharge>();
//		System.out.println("# DB서버에 넘겨줄 예치금 충전 데이터");
//		System.out.println("입금내역:"+dr.getDepositH());
//		System.out.println("금액:"+dr.getPrice());
//		System.out.println("계좌주명:"+dr.getBankName());
//		drlist.add(new DPR1Recharge("복권 예치금","5000원","동행복권_홍길동"));
//
//		return drlist;
//	}
//}	
//	public String recharge(DPR1Recharge dr, Model d) {
//		System.out.println("# DB 처리(예치금 충전하기) #");
//		System.out.println(dr.getDepositH()); //입금내역 : 복권 예치금
//		System.out.println(dr.getPrice());	// 금액 
//		System.out.println(dr.getBankName());	// 계좌주명 : 동행복권_000
//		return "예치금 충전(가상계좌입금하기)"; //DB에서 받은 결과값을 가정.

//// 계좌번호, 계좌주명, 예치금 
//ArrayList<DPR1Account> DPRList1 = new ArrayList<DPR1Account>();
//
//public DPR1DAO() {
//	super();
//	DPRList1.add(new DPR1Account("동행복권_이덕재","[케이뱅크] 701-0303-637-8522",5000));
//}
//	public ArrayList<DPR1Account> DPRList(){
//	System.out.println("[DAO] 예치금 조회");
//	System.out.println();
//	return DPRList1;
//}
