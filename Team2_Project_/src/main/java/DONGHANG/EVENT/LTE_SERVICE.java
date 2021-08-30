package DONGHANG.EVENT;

import java.util.ArrayList;
import java.util.Scanner;

public class LTE_SERVICE {

	Scanner sc = new Scanner(System.in);
	LTE_DAO dao = new LTE_DAO();
	// LTE_CONTROLLER ob = new LTE_CONTROLLER();
	public Object method;
	public String ltevent() {
		System.out.println("               이벤트 작성하기");
		System.out.println("-------------------------------------");
		LTE_DTO dto = new LTE_DTO();
		//LTE_CONTROLLER co = new LTE_CONTROLLER();
		System.out.println("이벤트 제목:");
		dto.setEvname(sc.nextLine());
		System.out.println("이벤트 기간:");
		dto.setEvdate(sc.nextLine());
		System.out.println("당첨자 발표:");
		dto.setAnnodate(sc.nextLine());
		System.out.println("이벤트 설명:");
		dto.setExplan(sc.nextLine());
		
		return "완료!";
	}
	/*
	 * public ArrayList<LTE_DTO> dtoList(LTE_DTO dto){
	 * System.out.println("# 서버스 단 처리 #");
	 * System.out.println("DAO에 전송 데이터1:"+dto.getEvname());
	 * System.out.println("DAO에 받은 데이터 크기:"+ dao.eventlist(dto).size()); return
	 * dao.eventlist(dto); }
	 */

}
