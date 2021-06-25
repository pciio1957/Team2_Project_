package SungKeun.JSTUDY.WEEKLYQUIZ;

import java.util.ArrayList;

public class JSQService {
	JSQDAO jsqdao = new JSQDAO();
	public ArrayList<JSQDTO> JSQList(JSQDTO jcoq1) {
		
		System.out.println("===============================================\n");
		System.out.println("# Service #\n");
//		DAO로 데이터를 넘기기 위한 확인 과정
//		System.out.println("LT1DAO에 전송 할 복권 번호 데이터 1 : " + jcoo1.getMyLotto() + "\n");
//		System.out.println("LT1DAO에 전송 할 당첨 번호 데이터 2 : " + jcoo1.getResult() + "\n");
//		System.out.println("LT1DAO에서 받을 복권 입력 데이터 크기 : "
//				+ lt1dao.LT1List(lto1).size() + "\n");
		return jsqdao.JSQList(jcoq1);
	}

}
