package PICMAGINE.ARTISTREQUEST;

import JiEun.Picmagine.vo.Artist;
import JiEun.Picmagine.vo.Member;

public class ACI01_Service {
	ACI01_DAO dao = new ACI01_DAO();
	
	public String getMemInfo(String memno) {
		dao.getMemInfo(memno);
		return "완료";
	}

	public String setArtist(Member mem, Artist atis) {
		dao.setArtist(mem, atis);
		return "완료";
	}
}
