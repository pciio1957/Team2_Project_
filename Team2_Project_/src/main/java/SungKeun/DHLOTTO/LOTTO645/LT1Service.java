package SungKeun.DHLOTTO.LOTTO645;

import java.util.ArrayList;

public class LT1Service {
	LT1DAO lt1dao = new LT1DAO();
	public ArrayList<LT1DTO> LT1List(LT1DTO lto) {

		System.out.println("===============================================\n");
		System.out.println("# Service #\n");
//		DAO로 데이터를 넘기기 위한 확인 과정
		System.out.println("LT1DAO에 전송 할 복권 입력 데이터 1 (선택한 복권 번호 (보너스 포함)) : " + lto.getMyLotto() + "\n");
		System.out.println("LT1DAO에서 받을 복권 입력 데이터 크기 : " + lt1dao.LT1List(lto).size() + "\n");
		return lt1dao.LT1List(lto);

	}
}




