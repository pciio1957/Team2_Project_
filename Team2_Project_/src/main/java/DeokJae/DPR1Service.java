package DeokJae;

import java.util.ArrayList;

public class DPR1Service {

	DPR1DAO dr1dao = new DPR1DAO();
	public ArrayList<DPR1Recharge>  DPR1List(DPR1Recharge dr){
		System.out.println("# 서비스단 처리#");
		System.out.println("DPR1DAO에 전송 할 예치금 입력 데이터");
		System.out.println("DPR1DAO에서 받을 예치금 입력 데이터 크기:"+ dr1dao.DPR1List(dr).size());
		return dr1dao.DPR1List(dr);
	}
	
}