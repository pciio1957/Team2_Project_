package JiEun;

import java.util.ArrayList;

public class LTS1Service {
	private ArrayList<LTS1Store> storeList = new ArrayList<LTS1Store>();
	LTS1DAO dao = new LTS1DAO();
	
	// [1] 전체조회 [2] 지역선택 [3] 단어검색 [4] 행정구역선택
	
	
	// 1) 전체 조회 - storeList 불러오기 
	public String storeList(int inIdx) {
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
	public String wordSerch() {
		System.out.println(" [Service] 판매점리스트 단어검색 ");
		storeList = dao.storeList();
		
		for(LTS1Store s:storeList) {
			//String strName = s.getStoreName();
			//String strAd = s.getStoreAd();
			
			// 해당 상호명이나 소재지에 검색하려는 값이 있는지 확인
			if(s.storeName.contains("")) {
				
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
