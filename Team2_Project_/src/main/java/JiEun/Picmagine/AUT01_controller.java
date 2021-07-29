package JiEun.Picmagine;

import javax.print.DocFlavor.SERVICE_FORMATTED;

public class AUT01_controller {
	AUT01_Service service = new AUT01_Service();
	boolean isFollower;
	
	
	// 작가 정보 출력
	public String writerInfo(String artno, AUT01_Model m) {
		m.addAttribute("작가정보 출력 ", service.writerInfo(artno));	
		return "완료";
	}
	
	// 작가 팔로우정보 확인
	public String followCheck(String artno, AUT01_Model m) {
		m.addAttribute("팔로우 정보 확인", service.followCheck(artno));
		return "완료";
	}
	
	// 회원이 작가를 팔로우했는지 확인
	public String followerCheck(String memno, String artno, AUT01_Model m) {
		m.addAttribute("팔로우 여부 확인", service.followerCheck(memno, artno));
		return "완료";
	}
	
	// 작가의 작품리스트 출력
	public String workList(String artno, AUT01_Model m) {
		m.addAttribute("작품리스트 출력", service.workList(artno));
		return "완료";
	}
	
	// 작가 시리즈 출력
	public String seriesList(String artno, AUT01_Model m) {
		m.addAttribute("시리즈리스트 출력", service.seriesList(artno));
		return "완료";
	}

}
