package SungKeun.JSTUDY.JSC_COMMUNITY;

import SungKeun.JSTUDY.Model;

public class JSCController {

	private JSCService jscservice = new JSCService();
	
	public String JSCList2(JSCDTO jco1, Model d) {
				
		System.out.println("===============================================\n");
		System.out.println("# Controller에서 받은 복권 입력 데이터 #\n");
//		Main에서 입력받은 정보를 Controller로 불러온다.
//		게시물 번호, 제목, 작성자, 작성일, 작성 내용
		System.out.println("게시물 번호 : " + jco1.getWriteNum());
		System.out.println("게시물 제목 : " + jco1.getHeadLine());
		System.out.println("게시물 작성자 : " + jco1.getWriter());
		System.out.println("게시물 작성일 : " + jco1.getWriteDate());
		System.out.println("게시물 작성 내용 : " + jco1.getWrite());
		
		d.addAttribute("jsclist", jscservice.JSCList(jco1));
		return "JSTUDY 커뮤니티 게시물 정보.jsp";
	}
}
