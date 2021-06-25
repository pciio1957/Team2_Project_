package SungKeun.JSTUDY.WEEKLYQUIZ;

import java.util.ArrayList;

public class JSQDAO {
	public ArrayList<JSQDTO> JSQList(JSQDTO jcoq1) {
		
		ArrayList<JSQDTO> jsqlist  = new ArrayList<JSQDTO>();
//		jsclist.add(new JSCDTO(lto1.getMyLotto(), lto1.getResult()));
		
	    // 전체 복권 입력 데이터를 확인하기 위한 메소드
		System.out.println("===============================================\n");
		System.out.println("# DB 서버에 넘겨 줄 복권 입력 데이터 #\n");
//		System.out.println("선택 한 복권 번호 (객체) : " + jcoq1.getMyLotto() + "\n");
//		System.out.println("생성 된 당첨 번호 (객체) : " + jcoq1.getResult() + "\n");
		System.out.println("===============================================\n");
		System.out.println("# DB 서버에서 온 복권 입력 데이터 리스트 #\n");
		jsqlist.add(new JSQDTO());
		System.out.println("===============================================\n");
		
		return jsqlist;
	}
}
