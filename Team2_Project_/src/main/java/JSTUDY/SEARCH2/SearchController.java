package JSTUDY.SEARCH2;

public class SearchController {

	private SearchService service = new SearchService();
	
	public String schList(SearchSch sch, Model d) {
		System.out.println("#컨트롤에서 받은 데이터#");
		System.out.println(sch.getKeyword());
		d.addAttribute("llist", service.schList(sch));

		return "경로/@@@.jsp";
	}
//	검색창,
//	입력 : 검색창, 
//	출력 : 검색내용, 강의정보,평점,가격
		// 화면단 호출
	//연관검색어
	public String related(SearchSch sch, Model d) {
		d.addAttribute("연관검색어", service.schList(sch));	
		return "호출화면";
	}
	//상세 검색
	public String searchInDetail(SearchSch sch, Model d) {
		d.addAttribute("상세검색", service.schList(sch));
		return "호출화면";
}
	
}



/*
	private SearchService service = new SearchService();
	
	public String schList(SearchSch s, Model d) {
		System.out.println("#컨트롤에서 받은 데이터#");
		System.out.println(s.getName());
		d.addAttribute("sclist", service.schList(s));
		
		
//	검색창,
//	입력 : 검색창, 
//	출력 : 검색내용, 강의정보,평점,가격
		// 화면단 호출
		return "경로/@@@.jsp";
		
		
*/
