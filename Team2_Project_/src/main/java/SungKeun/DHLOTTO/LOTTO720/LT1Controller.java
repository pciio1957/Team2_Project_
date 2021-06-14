package SungKeun.DHLOTTO.LOTTO720;

import SungKeun.DHLOTTO.Model;

public class LT1Controller {
	
	private LT1Service service = new LT1Service();
	
	public String LT1List2(LT1DTO lt, Model d) {
				
		System.out.println("===============================================\n");
		System.out.println("# Controller에서 받은 회원 정보 데이터 #\n");
//		Main에서 입력받은 정보를 Controller로 불러온다.
		System.out.println("선택된 조 : " + lt.getLtType());
		System.out.println("선택된 복권 번호 (6자리) : " + lt.getLtNum() + "\n");
		/*
		  Controller => Service => Dao (DB 처리)
 					<=		  <=
		 */
		
		// view단에 넘겨 줄 데이터 key, object
		d.addAttribute("lt1list", service.LT1List(lt));
		// 화면단에 대한 호출
		return "회원가입_정보.jsp";
//		return "경로/@@@.jsp";
	}
}
