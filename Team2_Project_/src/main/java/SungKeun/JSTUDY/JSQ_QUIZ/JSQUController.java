package SungKeun.JSTUDY.JSQ_QUIZ;

import SungKeun.JSTUDY.Model;

public class JSQUController {
	
	private JSQUService jsquservice = new JSQUService();
	
	public String JSQUList2(JSQUDTO jcqu1, Model d) {
	
		System.out.println("===============================================\n");
		System.out.println("# Controller에서 받은 퀴즈 정보 유저 입력 데이터 #\n");
//		Main에서 입력받은 정보를 Controller로 불러온다.
//		문제 번호, 문제, 문제 정답
		System.out.println("퀴즈 문제 번호 : " + jcqu1.getQuestNum());
		System.out.println("퀴즈 문제 : " + jcqu1.getQuest());
		System.out.println("퀴즈 유저 정답 : " + jcqu1.getUsrAns());
		System.out.println("퀴즈 문제 정답 : " + jcqu1.getAnswer());
	
		d.addAttribute("jsqulist", jsquservice.JSQUList(jcqu1));
		
		return "JSTUDY QUIZ 유저 정보.jsp";
	}
}
