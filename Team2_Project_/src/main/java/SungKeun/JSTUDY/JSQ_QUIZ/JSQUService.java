package SungKeun.JSTUDY.JSQ_QUIZ;

import java.util.ArrayList;

public class JSQUService {
	
	JSQUDAO jsqudao = new JSQUDAO();
	
	public ArrayList<JSQUDTO> JSQUList(JSQUDTO jcqu1) {
	
		System.out.println("===============================================\n");
		System.out.println("# Service #\n");
//		DAO로 데이터를 넘기기 위한 확인 과정
//		문제 번호, 문제, 유저 정답, 문제 정답
		System.out.println("JSQUDAO에 전송 할 퀴즈 문제 번호 데이터 1 : " + jcqu1.getQuestNum() + "\n");
		System.out.println("JSQUDAO에 전송 할 퀴즈 문제 데이터 2 : " + jcqu1.getQuest() + "\n");
		System.out.println("JSQUDAO에 전송 할 유저 정답 데이터 3 : " + jcqu1.getUsrAns() + "\n");
		System.out.println("JSQUDAO에 전송 할 문제 정답 데이터 3 : " + jcqu1.getAnswer() + "\n");
//		System.out.println("JSQUDAO에서 받을 퀴즈 정보 유저 입력 데이터 크기 : " + jsqudao.JSQUList(jcqu1).size() + "\n");
		return jsqudao.JSQUList(jcqu1);
	}
}
