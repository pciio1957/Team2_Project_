package SungKeun.JSTUDY.COMMUNITY;

import java.util.ArrayList;

public class JSCDAO {
	public ArrayList<JSCDTO> JSCList(JSCDTO jcoo1) {
		
		ArrayList<JSCDTO> jsclist  = new ArrayList<JSCDTO>();
//		jsclist.add(new JSCDTO(lto1.getMyLotto(), lto1.getResult()));
		
	    // 전체 복권 입력 데이터를 확인하기 위한 메소드
		System.out.println("===============================================\n");
		System.out.println("# DB 서버에 넘겨 줄 복권 입력 데이터 #\n");
//		System.out.println("선택 한 복권 번호 (객체) : " + jcoo1.getMyLotto() + "\n");
//		System.out.println("생성 된 당첨 번호 (객체) : " + jcoo1.getResult() + "\n");
		System.out.println("===============================================\n");
		System.out.println("# DB 서버에서 온 복권 입력 데이터 리스트 #\n");
		jsclist.add(new JSCDTO());
		System.out.println("===============================================\n");
		
		return jsclist;
	}
}
