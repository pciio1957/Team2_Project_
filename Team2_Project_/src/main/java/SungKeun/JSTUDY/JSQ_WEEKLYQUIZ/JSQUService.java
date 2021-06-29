package SungKeun.JSTUDY.JSQ_WEEKLYQUIZ;

import java.util.ArrayList;

public class JSQUService {
	
	JSQUDAO jswqudao = new JSQUDAO();
	
	public ArrayList<JSQUDTO> JSQUList(JSQUDTO jcuwq1) {
	
		System.out.println("===============================================\n");
		System.out.println("# Service #\n");
//		DAO로 데이터를 넘기기 위한 확인 과정
//		문제 번호, 문제, 유저 정답, 문제 정답
		System.out.println("JSQDAO에 전송 할 퀴즈 문제 번호 데이터 1 : " + jcuwq1.getQuestNum() + "\n");
		System.out.println("JSQDAO에 전송 할 퀴즈 문제 데이터 2 : " + jcuwq1.getQuest() + "\n");
		System.out.println("JSQDAO에 전송 할 유저 정답 데이터 3 : " + jcuwq1.getUsrAns() + "\n");
		System.out.println("JSQDAO에 전송 할 문제 정답 데이터 3 : " + jcuwq1.getAnswer() + "\n");
//		System.out.println("JSQDAO에서 받을 퀴즈 정보 입력 데이터 크기 : " + jsqdao.JSUQList(jcuwq1).size() + "\n");
		return jswqudao.JSQUList(jcuwq1);
	}
}
