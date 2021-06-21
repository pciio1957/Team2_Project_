package DeokJae;

import java.util.ArrayList;


public class DPR1Service {
	DPR1DAO dao = new DPR1DAO();
	
	public ArrayList<DPR1Account> cntList(DPR1Account cnt){
		System.out.println("# 서비스 단 처리#");
		System.out.println("DAO에 전송 데이터1:"+cnt.getAno());
		System.out.println("DAO에 받은 데이터 크기:"+
				dao.cntList(cnt).size());
		return dao.cntList(cnt);
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
