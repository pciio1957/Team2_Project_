package DONGHANG.STORESEARCH;

import java.util.ArrayList;

// 디비랑 연결
public class LTS1DAO {
	private ArrayList<LTS1Store> storeList = new ArrayList<LTS1Store>();  // 판매점 리스트
	private ArrayList<LTS1Lotto> winList = new ArrayList<LTS1Lotto>();    // 당첨판매점 리스트

	public LTS1DAO() {
		super();

		storeList.add(new LTS1Store("판매점", "강남상회", "서울 강남구 봉은사로 179 H타워 지층 1호 CU 편의점","02-3448-3500", "로또6/45"));
		storeList.add(new LTS1Store("판매점", "로또복권방", "서울 강남구 강남대로122길 50 상명빌딩 103호", "02-3444-7240", "로또6/45"));
		storeList.add(new LTS1Store("판매점", "프로토 포이점", "서울 강남구 논현로 36 태양빌딩103호", "02-578-9377	", "로또6/45"));
		storeList.add(new LTS1Store("판매점", "CU역삼점", "서울 강남구 테헤란로51길 10 1층", "02-539-0456", "현금복권,스피또"));
		storeList.add(new LTS1Store("판매점", "신사우리가판", "서울 강남구 강남대로 620-2 강남신사현대우편취급소 앞", "02-516-7234", "로또6/45,현금복권,스피또"));
		storeList.add(new LTS1Store("판매점", "로또복권판매점", "경기 여주시 세종로 59", "031-885-3337", "로또6/45"));
		storeList.add(new LTS1Store("판매점", "복권나라", "강원 춘천시 퇴계로145번길 11-15 1층", "033-257-0153", "로또6/45"));
		storeList.add(new LTS1Store("판매점", "돌하르방복권", "제주 서귀포시 태평로353번길 9 나눔로또", "064-762-5735", "로또6/45,현금복권,스피또"));
		
		storeList.add(new LTS1Store("폐점", "CU(침산건영점)(X)", "대구 북구 침산동 296-1번지", "053-351-0884", "로또6/45"));
		storeList.add(new LTS1Store("폐점", "모닝글로리(X)", "전남 여수시 서교동 534-8", "061-643-6270", "로또6/45,현금복권"));
		storeList.add(new LTS1Store("폐점", "대박찬스", "인천 미추홀구 용현동 139-24", "032-874-4630", "로또6/45,스피또"));
	
		
		// 일단 제외 - 시간이 남는다면 배열로 당첨번호도 나타내기
		int[] winNums1 = {1, 6, 13, 37, 38, 40, 9};
		int[] winNums2 = {1, 21, 25, 29, 34, 37, 36};
		int[] winNums3 = {2, 13, 25, 28, 29, 36, 34};
		int[] winNums4 = {6, 21, 36, 38, 39, 43, 30};

		
		// String tax, boolean fir, boolean sec, int[] wins, String nm, String ad
		// 회차, 등수, 구분(자동/수동), 상호명, 소재지
		winList.add(new LTS1Lotto("967회", 1, "자동", "강남상회", "서울 강남구 봉은사로 179 H타워 지층 1호 CU 편의점"));
		winList.add(new LTS1Lotto("967회", 2, "수동", "로또복권판매점", "경기 여주시 세종로 59"));
		winList.add(new LTS1Lotto("967회", 2, "수동", "복권나라", "강원 춘천시 퇴계로145번길 11-15 1층"));	
		winList.add(new LTS1Lotto("966회", 2, "수동", "신사우리가판", "서울 강남구 강남대로 620-2 강남신사현대우편취급소 앞"));
		winList.add(new LTS1Lotto("966회", 1, "수동", "CU역삼점", "서울 강남구 테헤란로51길 10 1층"));
		winList.add(new LTS1Lotto("965회", 2, "자동", "로또복권방", "서울 강남구 강남대로122길 50 상명빌딩 103호"));
		winList.add(new LTS1Lotto("964회", 1, "자동", "돌하르방복권", "제주 서귀포시 태평로353번길 9 나눔로또"));
		winList.add(new LTS1Lotto("964회", 2, "수동", "프로토 포이점", "서울 강남구 논현로 36 태양빌딩103호"));
		
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
