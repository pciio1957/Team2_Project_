package SungKeun.JSTUDY.COMMUNITY;

import SungKeun.JSTUDY.Model;

public class JSCController {

	private JSCService jscservice = new JSCService();
	
	public String JSCList2(JSCDTO jco1, Model d) {
				
		System.out.println("===============================================\n");
		System.out.println("# Controller에서 받은 복권 입력 데이터 #\n");
//		Main에서 입력받은 정보를 Controller로 불러온다.
//		System.out.println("선택 한 복권 객체 : " + jco1.getMyLotto());
		System.out.println("\n# Controller에서 받은 당첨 번호 데이터 #\n");
//		Main에서 입력받은 정보를 Controller로 불러온다.
//		System.out.println("당첨 된 번호 (보너스 포함) 객체 : " + jco1.getResult() + "\n");
		
		d.addAttribute("jsclist", jscservice.JSCList(jco1));
		return "LOTTO645_복권_입력_정보.jsp";
	}
}
