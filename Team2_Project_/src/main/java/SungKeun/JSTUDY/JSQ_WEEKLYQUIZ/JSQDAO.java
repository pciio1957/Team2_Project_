package SungKeun.JSTUDY.JSQ_WEEKLYQUIZ;

import java.util.ArrayList;

public class JSQDAO {
	public ArrayList<JSQDTO> JSQList(JSQDTO jcwq1) {
		
		ArrayList<JSQDTO> jswqlist  = new ArrayList<JSQDTO>();
		jswqlist.add(new JSQDTO(jcwq1.getQuestNum(), jcwq1.getQuest(), jcwq1.getAnswer()));
		
	    // 전체 퀴즈 정보 입력 데이터를 확인하기 위한 메소드
		System.out.println("===============================================\n");
		System.out.println("# DB 서버에 넘겨 줄 퀴즈 정보 데이터 #\n");
		System.out.println("퀴즈 문제 번호 : " + jcwq1.getQuestNum() + "\n");
		System.out.println("퀴즈 문제 : " + jcwq1.getQuest() + "\n");
		System.out.println("퀴즈 문제 정답 : " + jcwq1.getAnswer() + "\n");
		System.out.println("===============================================\n");
		System.out.println("# DB 서버에서 온 퀴즈 입력 정보 데이터 리스트 #\n");
//		문제 번호, 문제, 문제 정답
		jswqlist.add(new JSQDTO(0, "이것은 컴퓨터 프로그램입니다.", "이클립스"));
		jswqlist.add(new JSQDTO(3, "이것은 획기적인 언어입니다.", "JAVA(자바)"));
		jswqlist.add(new JSQDTO(8, "이것은 이클립스와 비슷한 프로그램입니다.", "비주얼스튜디오코드(VSC)"));
		System.out.println("===============================================\n");
		
		return jswqlist;
	}
}
