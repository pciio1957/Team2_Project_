package SungKeun.DHLOTTO.LT1_LOTTO645;

import SungKeun.DHLOTTO.Model;

public class LT1Controller {
	
	private LT1Service lt1service = new LT1Service();
	
	public String LT1List2(LT1DTO lt1, Model d) {
				
		System.out.println("===============================================\n");
		System.out.println("# Controller에서 받은 복권 입력 데이터 #\n");
//		Main에서 입력받은 정보를 Controller로 불러온다.
		System.out.println("선택한 복권 (보너스 포함) 객체 : " + lt1.getMyLotto());
		
		
		// view단에 넘겨 줄 데이터 key, object
		d.addAttribute("lt1list", lt1service.LT1List(lt1));
		// 화면단에 대한 호출
		return "LOTTO645_복권_입력_정보.jsp";
//		return "경로/@@@.jsp";
	}
}