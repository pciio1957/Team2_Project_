package JiEun;

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
		System.out.println(" - " + word + ": 검색 결과 ");
		for(LTS1Store s:storeList) {
			// 사용자가 입력한 단어가 상호명이나 소재지에 포함되어있으면 정보출력
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
		System.out.println(" - " + word + ": 검색 결과 ");
		for(LTS1Store s:storeList) {
			if(s.stAd.contains(word)) {
				s.showInfo(num++);
			}
		}
		
		
		return "검색완료";
	}
	
	
	// 4. 당첨판매점 조회 - 1등, 2등이 당첨되었던 판매점 조회하기 
	public String winStore(int part, String word) {
		System.out.println(" [Service] 판매점리스트 지역검색 ");
		//winList = dao.winList();
		storeList = dao.storeList();
		
		if(part == 1) {
			// 회차검색
			// 회차를 먼저 검색하고서 있으면 해당 판매점명을 가져오고 해당 판매점명으로 storeList에서 검색 후 정보 출력? 
			ArrayList<LTS1Lotto> winStore = new ArrayList<LTS1Lotto>();
			
			// 로또 판매점 조회 - 1등 / 2등 나눠서 출력하기 위해서 for문을 두번?돌리는게 나을것같음 
			// 		그리고 나서 안에서 해당 회차에 해당하는 걸 출력~ 
			for(LTS1Lotto lt:winList) {
				
				
				if(lt.ltrank == 1) { // 1등 조회
					
				} else if (lt.ltrank == 2) { // 2등 조회
					
				}
				
				
				if(lt.lttaxis.contains(word)) { // 해당 회차에 해당되는 판매점리스트 가져오는것
					System.out.println(" 회차 : " + lt.lttaxis);
					
				}
			}
			
			
			
			
			
			
		} else if(part == 2) {
			// 단어/지역 검색이라서 소재지검색을 미리하고서 해당 데이터가 있으면 해당 내용이 있으면 storeList에서 출력하기 
			
		} 
		
		
		for(LTS1Store st:storeList) {
			
		}
		
		
		
		for(LTS1Lotto lt:winList) {
			
		}
		
		
		return "조회완료";
	}
	
	
	// 당첨판매점의 회차검색
	public String winTaxis(String inTaxis) {
		System.out.println(" [Service] 당첨판매점리스트 회차검색 ");
		winList = dao.winList();
		
		System.out.println("회차 : " + inTaxis);
		// 
		System.out.println("1등 판매점입니다 --");
		for(LTS1Lotto lt:winList) {
			if(lt.ltrank == 1) {
				if(lt.lttaxis.equals(inTaxis)) {
					System.out.println("1등의 당첨판매점");
					lt.showInfo();
				}
				
			}
			
		}
		
		
		
		return "검색완료";
	}
	
	// 당첨판매점의 단어검색 
	public String winWord(String inWord) {
		System.out.println(" [Service] 당첨판매점리스트 단어검색 ");
		winList = dao.winList();
		
		
		for(LTS1Lotto lt:winList) {
			
		}
		
		return "검색완료";
	}


}
