package SungKeun.JSTUDY.JSQ_QUIZ;

import SungKeun.JSTUDY.Model;

public class JSQController {
	
	private JSQService jsqservice = new JSQService();
	
	public String JSQList2(JSQDTO jcq1, Model d) {
				
		System.out.println("===============================================\n");
		System.out.println("# Controller에서 받은 퀴즈 정보 입력 데이터 #\n");
//		Main에서 입력받은 정보를 Controller로 불러온다.
//		문제 번호, 문제, 문제 정답
		System.out.println("퀴즈 문제 번호 : " + jcq1.getQuestNum());
		System.out.println("퀴즈 문제 : " + jcq1.getQuest());
		System.out.println("퀴즈 문제 정답 : " + jcq1.getAnswer());
		
		d.addAttribute("jsqlist", jsqservice.JSQList(jcq1));
		
		return "JSTUDY QUIZ 정보.jsp";
	}
}
