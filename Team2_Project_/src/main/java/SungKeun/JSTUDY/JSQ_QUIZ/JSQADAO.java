package SungKeun.JSTUDY.JSQ_QUIZ;

import java.util.ArrayList;

public class JSQADAO {
	
	public ArrayList<JSQADTO> JSQAList(JSQADTO jcqa1) {
	
		ArrayList<JSQADTO> jsqalist  = new ArrayList<JSQADTO>();
		jsqalist.add(new JSQADTO(jcqa1.getAnswer()));
	
    	// 전체 퀴즈 정보 입력 데이터를 확인하기 위한 메소드
		System.out.println("===============================================\n");
		System.out.println("# DB 서버에 넘겨 줄 퀴즈 정답 정보 데이터 #\n");
		System.out.println("퀴즈 정답 : " + jcqa1.getAnswer() + "\n");
		System.out.println("===============================================\n");
		System.out.println("# DB 서버에서 온 퀴즈 입력 정보 데이터 리스트 #\n");
//		문제 번호, 문제, 문제 정답
		jsqalist.add(new JSQADTO("이클립스"));
		jsqalist.add(new JSQADTO("JAVA"));
		jsqalist.add(new JSQADTO("VSCode"));
		System.out.println("===============================================\n");
	
		return jsqalist;
	}
}
