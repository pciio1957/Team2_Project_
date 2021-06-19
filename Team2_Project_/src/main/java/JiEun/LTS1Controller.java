package JiEun;

public class LTS1Controller {
	LTS1Service service = new LTS1Service();
	
	public String storeList(int part, LTS1Model m) {
		System.out.println("\n [Controller] 판매점리스트 조회 ");
		m.addAttribute("판매점리스트 조회", service.storeList(part));
		
		return " [Controller] 조회완료";
	}
	
	public String wordSearch(String word, LTS1Model m) {
		System.out.println("\n [Controller] 판매점 단어검색 ");
		m.addAttribute("판매점 단어검색", service.wordSearch(word));
		
		return " [Controller] 검색완료";
	}
	
	public String areaSearch(String word, LTS1Model m) {
		System.out.println("\n [Controller] 지역 검색");
		m.addAttribute("지역 검색", service.areaSearch(word));
		return " [Controller] 검색완료";
	}
	
	public String winStore(int part, String word, LTS1Model m) {
		System.out.println("\n [Controller] 당첨판매점 조회");
		m.addAttribute("당첨판매점 조회", service.winStore(part, word));
		return " [Controller] 조회완료";
	}
}

