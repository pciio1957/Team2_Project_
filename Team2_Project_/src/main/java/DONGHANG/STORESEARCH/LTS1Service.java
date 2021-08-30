package DONGHANG.STORESEARCH;

import java.util.ArrayList;

public class LTS1Service {
	private ArrayList<LTS1Store> storeList = new ArrayList<LTS1Store>();
	private ArrayList<LTS1Lotto> winList = new ArrayList<LTS1Lotto>();
	LTS1DAO dao = new LTS1DAO();
	
	// [1] 전체조회(확인용) [2] 지역선택 [3] 단어검색 제외 - 행정구역선택(중복이라서 제외) 
	// [4] 당첨판매점 회차검색 [5] 당첨판매점 단어검색(중복인가..?)
	
	
	// 1-1) 전체 조회 - storeList 불러오기 
	public String storeList(int part) {
		System.out.println(" [Service] 전체 판매점리스트 조회 ");
		storeList = dao.storeList();
		int listIdx = 1;
		
		// 1은 전체리스트 조회
		if(part == 1) {
			System.out.println("\n# 판매점 조회 #");
			for(LTS1Store s:storeList) {
				s.showInfo(listIdx);
				listIdx++;
			}
		// 2는 지역조회
		} else if (part == 2) {
			System.out.println("\n# 지역 조회 #");
			System.out.println("번호 시/도\t구/군");
			for(LTS1Store s:storeList) {
				s.showArea(listIdx);
				listIdx++;
			}
		}

		System.out.println();
		
		return "조회완료";
	}
	
	// 2) 단어검색 - 지역보기 
	public String wordSearch(String word) {
		System.out.println(" [Service] 판매점리스트 단어검색 ");
		int num = 1; // 리스트 순서번호
		
		// 판매점목록 받아오기
		storeList = dao.storeList();
		
		
		System.out.println("\n# 검색리스트 #");
		System.out.println("# 단어 필터 : " + word + " #");
		for(LTS1Store s:storeList) {
			// 단어검색 - 사용자가 입력한 단어가 상호명이나 소재지에 포함되어있으면 정보출력
			if(s.stName.contains(word) || s.stAd.contains(word)) {
				s.showInfo(num++);
			} 
		}	
		return "검색완료";
	}	
	
	
	// 3) 지역선택 - 화면단(콤보상자) 연결해야함
	public String areaSearch(String word) {
		System.out.println(" [Service] 판매점리스트 지역검색 ");
		storeList = dao.storeList();
		int num = 1;
		
		System.out.println("\n# 검색리스트 #");
		System.out.println("# 지역 필터 : " + word + " #");
		for(LTS1Store s:storeList) {
			if(s.stAd.contains(word)) {
				s.showInfo(num++);
			}
		}
		
		
		return "검색완료";
	}
	
	// 당첨판매점의 회차검색
	public String winTaxis(String inTaxis) {
		System.out.println(" [Service] 당첨판매점리스트 회차검색 ");
		winList = dao.winList();
		
		// 번호관리
		int idx = 1; // 출력시 인덱스번호 
		
		System.out.println("# 회차 필터 : " + inTaxis + "#");
		System.out.println("# 1등 판매점 #");
		for(LTS1Lotto lt:winList) {
			if(lt.ltrank == 1) {
				if(lt.lttaxis.equals(inTaxis)) {
					lt.showInfo(idx++);
				}
			} 
		}
		
		if(idx == 1) {
			System.out.println(" - 해당 판매점이 없습니다 - ");
		}
		
		idx = 1;
		System.out.println("\n# 2등 판매점 #");
		for(LTS1Lotto lt:winList) {
			if(lt.ltrank == 2) {
				if(lt.getLttaxis().equals(inTaxis)) {
					lt.showInfo(idx++);
				}
			} 
		}
		
		if(idx == 1) {
			System.out.println(" - 해당 판매점이 없습니다 - ");
		}
		
		return "검색완료";
	}
	
	// 당첨판매점의 단어검색 
	public String winWord(String inWord) {
		System.out.println(" [Service] 당첨판매점리스트 단어검색 ");
		winList = dao.winList();
		
		int idx = 1;
		
		System.out.println("# 검색 필터 : " + inWord + "#");
		System.out.println("# 1등 판매점 #");
		for(LTS1Lotto lt:winList) {
			if(lt.getLtName().contains(inWord) || lt.getLtAd().contains(inWord)) {
				if(lt.getLtrank() == 1) { // 1등 판매점 조회
					lt.showInfo(idx++);
				}
			}
		}
		
		if(idx == 1) {
			System.out.println(" - 해당 판매점이 없습니다 - ");
		}
		
		idx = 1;
		for(LTS1Lotto lt:winList) {
			if(lt.getLtName().contains(inWord) || lt.getLtAd().contains(inWord)) {
				if(lt.getLtrank() == 2) { // 1등 판매점 조회
					lt.showInfo(idx++);
				}
			}
		}
		
		
		if(idx == 1) {
			System.out.println(" - 해당 판매점이 없습니다 - ");
		}
		
		
		return "검색완료";
	}


}
