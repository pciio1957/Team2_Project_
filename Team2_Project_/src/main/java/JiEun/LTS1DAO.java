package JiEun;

import java.util.ArrayList;

public class LTS1DAO {
	private ArrayList<LTS1Store> storeList = new ArrayList<LTS1Store>();  // 판매점리스트

	public LTS1DAO() {
		super();
		//storeList.add(new LTS1Store());
		storeList.add(new LTS1Store("강남상회", "서울 강남구 봉은사로 179 H타워 지층 1호 CU 편의점","02-3448-3500", "로또6/45"));
		storeList.add(new LTS1Store("로또복권방", "서울 강남구 강남대로122길 50 상명빌딩 103호", "02-3444-7240", "로또6/45"));
		storeList.add(new LTS1Store("프로토 포이점", "서울 강남구 논현로 36 태양빌딩103호", "02-578-9377	", "로또6/45"));
		storeList.add(new LTS1Store("CU역삼점", "서울 강남구 테헤란로51길 10 1층", "02-539-0456", "현금복권,스피또"));
		storeList.add(new LTS1Store("신사우리가판", "서울 강남구 강남대로 620-2 강남신사현대우편취급소 앞", "02-516-7234", "로또6/45,현금복권,스피또"));
	}
	
	public ArrayList<LTS1Store> storeList() {
		System.out.println(" [DAO] 판매점 조회 ");
		return storeList;
	}
	
}
