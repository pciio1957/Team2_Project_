package DaEun.LTE;


public class LTE_CONTROLLER {
	private LTE_SERVICE service = new LTE_SERVICE();
	
	public String schList2(LTE_DTO p, 
			LTE_Model d) {
		System.out.println("# 컨트롤에서 받은 데이터 #");
		System.out.println("이벤트 제목:"+p.getEvname());
		System.out.println("이벤트 기간:"+p.getEvdate());
		System.out.println("당첨자 발표:"+p.getAnnodate());
		System.out.println("이벤트 설명"+p.getExplan());
		d.addAttribute("eventlist",LTE_SERVICE.class );
		return "경로/@@@.jsp";
}
}
