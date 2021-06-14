package SungKeun.DHLOTTO.LOTTO720;

import java.util.ArrayList;

public class LT1Service {
	LT1DAO lt1dao = new LT1DAO();
	public ArrayList<LT1DTO> LT1List(LT1DTO lto) {

		System.out.println("===============================================\n");
		System.out.println("# Service #\n");
//		DAO로 데이터를 넘기기 위한 확인 과정
		System.out.println("JoinDAO에 전송 할 회원 정보 데이터 1 (선택 조) : " + lto.getLtType());
		System.out.println("JoinDAO에 전송 할 회원 정보 데이터 4 (복권 번호 6자리) : " + lto.getLtNum() + "\n");
		System.out.println("JoinDAO에서 받을 회원 정보 데이터 크기 : " + lt1dao.LT1List(lto).size() + "\n");
		return lt1dao.LT1List(lto);

	}
}
