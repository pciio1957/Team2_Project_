package JiEun;

import java.util.ArrayList;

public class LTS1DAO {
	private ArrayList<LTS1Store> storeList = new ArrayList<LTS1Store>();  // 판매점 리스트
	private ArrayList<LTS1Lotto> winList = new ArrayList<LTS1Lotto>();    // 당첨판매점 리스트

	public LTS1DAO() {
		super();

		storeList.add(new LTS1Store("강남상회", "서울 강남구 봉은사로 179 H타워 지층 1호 CU 편의점","02-3448-3500", "로또6/45"));
		storeList.add(new LTS1Store("로또복권방", "서울 강남구 강남대로122길 50 상명빌딩 103호", "02-3444-7240", "로또6/45"));
		storeList.add(new LTS1Store("프로토 포이점", "서울 강남구 논현로 36 태양빌딩103호", "02-578-9377	", "로또6/45"));
		storeList.add(new LTS1Store("CU역삼점", "서울 강남구 테헤란로51길 10 1층", "02-539-0456", "현금복권,스피또"));
		storeList.add(new LTS1Store("신사우리가판", "서울 강남구 강남대로 620-2 강남신사현대우편취급소 앞", "02-516-7234", "로또6/45,현금복권,스피또"));
		storeList.add(new LTS1Store("로또복권판매점", "경기 여주시 세종로 59", "031-885-3337", "로또6/45"));
		storeList.add(new LTS1Store("복권나라", "강원 춘천시 퇴계로145번길 11-15 1층", "033-257-0153", "로또6/45"));
		storeList.add(new LTS1Store("돌하르방복권", "제주 서귀포시 태평로353번길 9 나눔로또", "064-762-5735", "로또6/45"));
		
		int[] winNums1 = {1, 6, 13, 37, 38, 40, 9};
		int[] winNums2 = {1, 21, 25, 29, 34, 37, 36};
		int[] winNums3 = {2, 13, 25, 28, 29, 36, 34};
		int[] winNums4 = {6, 21, 36, 38, 39, 43, 30};
//		int[] winNums5 = {6, 12, 19, 23, 34, 42, 35};
//		int[] winNums6 = {1, 18, 28, 31, 34, 43, 40};
//		int[] winNums7 = {11, 20, 29, 31, 33, 42, 43};
//		int[] winNums8 = {2, 18, 24, 30, 32, 45, 14};
		
		// 회차, 당첨번호들, 판매점명, 1등여부, 2등여부
		winList.add(new LTS1Lotto("967회", winNums1, "강남상회", true, false));
		winList.add(new LTS1Lotto("967회", winNums1, "로또복권판매점", false, true));
		winList.add(new LTS1Lotto("967회", winNums1, "복권나라", true, true));	
		winList.add(new LTS1Lotto("966회", winNums2, "신사우리가판", false, true));
		winList.add(new LTS1Lotto("966회", winNums2, "CU역삼점", true, true));
		winList.add(new LTS1Lotto("965회", winNums3, "로또복권방", false, true));
		winList.add(new LTS1Lotto("964회", winNums4, "돌하르방복권", false, true));
		winList.add(new LTS1Lotto("964회", winNums4, "프로토 포이점", false, true));
		
	}
	
	public ArrayList<LTS1Store> storeList() {
		System.out.println(" [DAO] 판매점 조회 \n");
		return storeList;
	}
	
	public ArrayList<LTS1Lotto> winList() {
		System.out.println(" [DAO] 당첨판매점 조회 \n");
		return winList;
	}
	
}
