package JiEun.Picmagine;

public class AUT01_controller {
	AUT01_Service service = new AUT01_Service();

	
	
	// 작가 정보 출력
	public String WriterInfo(String wrtno, AUT01_Model m) {
		m.addAttribute("작가정보 출력 ", service.WriterInfo(wrtno));
		
		return "완료";
	}
	
	// 작가 팔로우/팔로잉
	public String followCheck(String memno, String wrtno, AUT01_Model m) {
		m.addAttribute("팔로워/팔로잉 확인 ", service.followCheck(memno, wrtno));
		
		return "완료";
	}
	
	// 작가의 작품리스트 출력
	public String WorkList(String wrtno, AUT01_Model m) {
		m.addAttribute("작품리스트 출력", service.WorkList(wrtno));
		
		return "완료";
	}
	
	// 작가 시리즈 출력
	public void SeriesList() {
		
	}

}
