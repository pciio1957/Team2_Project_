package PICMAGINE.AUTH;

import JiEun.Picmagine.vo.Artist;
import JiEun.Picmagine.vo.Member;

public class ACI01_main {
	static ACI01_controller controller = new ACI01_controller();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 확인용~!
		int checkNum = 10;
		
		// 사용권한(회원:1, 작가:2)이 1인 회원의 작가 신청 정보 확인
		controller.getMemInfo("mb1003", new ACI01_Model());
		
		// 작가 신청하기 - 입력한 데이터를 데이터베이스에 넣기
		controller.setArtist(new Member("heygirl02", "as1234"),
				new Artist("굿밤", "night", "night.jpg", "night", "night@naver.com", "mb"+checkNum++), 
				new ACI01_Model());
		
	}

}
