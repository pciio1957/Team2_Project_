package SungKeun.JSTUDY.JSQ_QUIZ;

import java.util.ArrayList;

public class JSQUDAO {
	
	public ArrayList<JSQUDTO> JSQUList(JSQUDTO jcqu1) {
	
		ArrayList<JSQUDTO> jsqulist  = new ArrayList<JSQUDTO>();
		jsqulist.add(new JSQUDTO(jcqu1.getQuestNum(), jcqu1.getQuest(), jcqu1.getUsrAns(), jcqu1.getAnswer()));
	
    	// 전체 퀴즈 정보 입력 데이터를 확인하기 위한 메소드
		System.out.println("===============================================\n");
		System.out.println("# DB 서버에 넘겨 줄 퀴즈 정보 데이터 #\n");
		System.out.println("퀴즈 문제 번호 : " + jcqu1.getQuestNum() + "\n");
		System.out.println("퀴즈 문제 : " + jcqu1.getQuest() + "\n");
		System.out.println("퀴즈 유저 정답 : " + jcqu1.getUsrAns() + "\n");
		System.out.println("퀴즈 문제 정답 : " + jcqu1.getAnswer() + "\n");
		System.out.println("===============================================\n");
		System.out.println("# DB 서버에서 온 퀴즈 입력 정보 데이터 리스트 #\n");
//		문제 번호, 문제, 문제 정답
		jsqulist.add(new JSQUDTO(0, "이것은 컴퓨터 프로그램입니다.", "윈도우클리너", "이클립스"));
		jsqulist.add(new JSQUDTO(3, "이것은 획기적인 언어입니다.", "자바", "JAVA(자바)"));
		jsqulist.add(new JSQUDTO(8, "이것은 이클립스와 비슷한 프로그램입니다.", "인텔리제이", "비주얼스튜디오코드(VSC)"));
		System.out.println("===============================================\n");
	
		return jsqulist;
	}
}
