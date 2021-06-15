package SungKeun.DHLOTTO.LOTTO645;

import SungKeun.DHLOTTO.Model;

public class LT1Controller {
	
	private LT1Service service = new LT1Service();
	
	public String LT1List2(LT1DTO lt, Model d) {
				
		System.out.println("===============================================\n");
		System.out.println("# Controller에서 받은 복권 입력 데이터 #\n");
//		Main에서 입력받은 정보를 Controller로 불러온다.
		System.out.println("선택한 복권 (보너스 포함) 객체 : " + lt.getMyLotto());
		
		
		// view단에 넘겨 줄 데이터 key, object
		d.addAttribute("lt1list", service.LT1List(lt));
		// 화면단에 대한 호출
		return "복권입력_정보.jsp";
//		return "경로/@@@.jsp";
	}
}
