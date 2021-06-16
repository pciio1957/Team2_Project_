package JiEun;

import java.util.ArrayList;

public class LTS1Service {
	private ArrayList<LTS1Store> storeList = new ArrayList<LTS1Store>();
	LTS1DAO dao = new LTS1DAO();
	
	// [1] 전체조회 [2] 지역선택 [3] 단어검색 [4] 행정구역선택
	
	
	// 1) 전체 조회 - storeList 불러오기 
	public String storeList() {
		System.out.println(" [Service] 전체 판매점리스트 조회 ");
		storeList = dao.storeList();
		int num = 1;
		
		System.out.println("\n# 판매점 조회 #");
		for(LTS1Store s:storeList) {
			s.showInfo(num);
			num++;
		}
		System.out.println();
		
		return "조회완료";
	}
	
	// 2) 지역선택 - 화면단(콤보상자)
	public String areaSerch() {
		System.out.println(" [Service] 판매점리스트 지역검색 ");
		storeList = dao.storeList();
		
		return "검색완료";
	}
	
	// 3) 단어검색
	public String wordSerch(String part) {
		System.out.println(" [Service] 판매점리스트 단어검색 ");
		int num = 1; // 리스트 순서번호
		
		// 판매점목록 받아오기
		storeList = dao.storeList();
		
		System.out.println("\n# 검색리스트 #");
		for(LTS1Store s:storeList) {
			// 사용자가 입력한 단어가 상호명이나 소재지에 포함되어있으면 정보출력
			if(s.storeName.contains(part) || s.storeAd.contains(part)) {
				s.showInfo(num);
				num++;
			} 
		}	
		return "검색완료";
	}
	
	// 4) 행정구역선택 - 화면단(버튼)
	public String sectionSerch() {
		System.out.println(" [Service] 판매점리스트 행정구역검색 ");
		storeList = dao.storeList();
		
		return "검색완료";
	}

}
