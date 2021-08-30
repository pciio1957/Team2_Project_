package PICMAGINE.ARTISTREQUEST;

import JiEun.Picmagine.vo.*;

public class ACI01_controller {
	
	ACI01_Service service = new ACI01_Service();
	
	public String getMemInfo(String memno, ACI01_Model m) {
		m.addAttribute("회원 정보 불러오기", service.getMemInfo(memno));
		return "완료";
	}

	public String setArtist(Member mem, Artist atis, ACI01_Model m) {
		m.addAttribute("작가신청", service.setArtist(mem, atis));
		return "완료";
	}
}
