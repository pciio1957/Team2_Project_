package JiEun.Picmagine;

import javax.print.DocFlavor.SERVICE_FORMATTED;

public class AUT01_controller {
	AUT01_Service service = new AUT01_Service();
	boolean isFollower;
	
	
	// 작가 정보 출력
	public String WriterInfo(String artno, AUT01_Model m) {
		m.addAttribute("작가정보 출력 ", service.WriterInfo(artno));	
		return "완료";
	}
	
	// 작가 팔로우정보 확인
	public String followCheck(String artno, AUT01_Model m) {
		m.addAttribute("팔로우 정보 확인", service.followCheck(artno));
		return "완료";
	}
	
	// 작가 팔로워 확인 후 증감
	public String followerCheck(String memno, String artno, AUT01_Model m) {
		m.addAttribute("팔로우 여부 확인", service.followerCheck(memno, artno));
		return "완료";
	}
	
	// 작가의 작품리스트 출력
	public String WorkList(String artno, AUT01_Model m) {
		m.addAttribute("작품리스트 출력", service.WorkList(artno));
		return "완료";
	}
	
	// 작가 시리즈 출력
	public void SeriesList() {
		
	}

}
