package SungKeun.JSTUDY.JSQ_QUIZ;

import java.util.ArrayList;

public class JSQAService {
	
	JSQADAO jsqadao = new JSQADAO();
	
	public ArrayList<JSQADTO> JSQAList(JSQADTO jcqa1) {
	
		System.out.println("===============================================\n");
		System.out.println("# Service #\n");
//		DAO로 데이터를 넘기기 위한 확인 과정
//		문제 번호, 문제, 유저 정답, 문제 정답
		System.out.println("JSQADAO에 전송 할 유저 전송 퀴즈 정답 데이터 1 : " + jcqa1.getAnswer() + "\n");
//		System.out.println("JSQADAO에서 받을 유저 전송 퀴즈 문제 데이터 크기 : " + jsqudao.JSQUList(jcqu1).size() + "\n");
		return jsqadao.JSQAList(jcqa1);
	}
}
