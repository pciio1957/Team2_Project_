package SungKeun.DHLOTTO.LT2_CATCHME;

import java.util.ArrayList;

public class LT2Service {
	LT2DAO lt2dao = new LT2DAO();
	public ArrayList<LT2DTO> LT2List(LT2DTO lto2) {

		System.out.println("===============================================\n");
		System.out.println("# Service #\n");
//		DAO로 데이터를 넘기기 위한 확인 과정
//		System.out.println("LT2DAO에 전송 할 복권 입력 데이터 1 (선택한 복권 번호 (보너스 포함)) : " + lto2.getMyLotto() + "\n");
//		System.out.println("LT2DAO에서 받을 복권 입력 데이터 크기 : " + lt2dao.LT2List(lto2).size() + "\n");
		return lt2dao.LT2List(lto2);

	}
}
