package SungKeun.JSTUDY.JSQ_WEEKLYQUIZ;

import java.util.ArrayList;

public class JSQService {
	JSQDAO jswqdao = new JSQDAO();
	public ArrayList<JSQDTO> JSQList(JSQDTO jcwq1) {
		
		System.out.println("===============================================\n");
		System.out.println("# Service #\n");
//		DAO로 데이터를 넘기기 위한 확인 과정
//		문제 번호, 문제, 문제 정답
		System.out.println("JSQDAO에 전송 할 퀴즈 문제 번호 데이터 1 : " + jcwq1.getQuestNum() + "\n");
		System.out.println("JSQDAO에 전송 할 퀴즈 문제 데이터 2 : " + jcwq1.getQuest() + "\n");
		System.out.println("JSQDAO에 전송 할 문제 정답 데이터 3 : " + jcwq1.getAnswer() + "\n");
//		System.out.println("JSQDAO에서 받을 퀴즈 정보 입력 데이터 크기 : " + jsqdao.JSQList(jcoq1).size() + "\n");
		return jswqdao.JSQList(jcwq1);
	}
}
