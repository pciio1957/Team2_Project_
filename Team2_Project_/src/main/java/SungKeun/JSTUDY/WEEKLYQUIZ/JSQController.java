package SungKeun.JSTUDY.WEEKLYQUIZ;

import SungKeun.JSTUDY.Model;

public class JSQController {
	
	private JSQService jsqservice = new JSQService();
	
	public String JSQList2(JSQDTO jcq1, Model d) {
				
		System.out.println("===============================================\n");
		System.out.println("# Controller에서 받은 복권 입력 데이터 #\n");
//		Main에서 입력받은 정보를 Controller로 불러온다.
//		System.out.println("선택 한 복권 객체 : " + jco1.getMyLotto());
		System.out.println("\n# Controller에서 받은 당첨 번호 데이터 #\n");
//		Main에서 입력받은 정보를 Controller로 불러온다.
//		System.out.println("당첨 된 번호 (보너스 포함) 객체 : " + jco1.getResult() + "\n");
		
		d.addAttribute("lt1list", jsqservice.JSQList(jcq1));
		return "LOTTO645_복권_입력_정보.jsp";
	}
}
