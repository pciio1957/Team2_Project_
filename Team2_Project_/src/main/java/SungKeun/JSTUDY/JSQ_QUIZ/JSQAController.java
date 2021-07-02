package SungKeun.JSTUDY.JSQ_QUIZ;

import SungKeun.JSTUDY.Model;

public class JSQAController {
	
	private JSQAService jsqaservice = new JSQAService();
	
	public String JSQAList2(JSQADTO jcqa1, Model d) {
	
		System.out.println("===============================================\n");
		System.out.println("# Controller에서 받은 퀴즈 정보 입력 데이터 #\n");
//		Main에서 입력받은 정보를 Controller로 불러온다.
//		문제 번호, 문제, 문제 정답
		System.out.println("퀴즈 정답 : " + jcqa1.getAnswer());
	
		d.addAttribute("jsqalist", jsqaservice.JSQAList(jcqa1));
		
		return "JSTUDY QUIZ 유저 정보.jsp";
	}
}
