package JiEun;

import java.util.Scanner;

public class LTS1Main {
	static LTS1Controller controller = new LTS1Controller();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// DB - Store(가게테이블), Lotto(로또 당첨번호테이블)
		
		
		// 1. 단어입력해서 검색
		// 2. 지역 리스트를 나타내기 (DB의 주소에서 앞에 자르기..?) '서울 강남구' 니까 공백 앞뒤로 자르기 
		// 3. 당첨 판매점 보이기 - 리스트 보이는건 1등/2등으로 나눠서 보이기  showInfo도 바꾸기 
		

		
		while(true) {
			System.out.println("# 판매점 #");
			String ser = indexSearch(); // 검색방법 입력받기
			
			if(ser.equals("1")) {
				// 1. 전체리스트 불러오기 
				controller.storeList(1, new LTS1Model());
				
			} else if (ser.equals("2")) {
				
				// 2. 단어검색 - 상호명/지역명 일부 입력 후 검색시 일부리스트 조회
				System.out.println("# 판매점 단어검색 #");
				String inName = inputStr(" 검색할 상호명이나 지역 입력 : ");
				System.out.println();
				controller.wordSearch(inName, new LTS1Model());
				
			} else if (ser.equals("3")) {
				
				// 3. 지역검색 - 선택할 수 있는 지역 리스트를 출력된다. 그리고 지역 선택 후 조회 
				System.out.println("# 판매점 지역검색 #");
				System.out.println(" 지역 리스트 ");
				controller.storeList(2, new LTS1Model());
				
				// 리스트 출력 후 그 리스트에서 지역 선택
				String inarea = inputStr("검색할 지역 입력 : "); 
				controller.areaSearch(inarea, new LTS1Model());
				

			} else if (ser.equals("4")) {
				
				// 4. 당첨 판매점 조회 - 복권선택은 중복이라서 로또만 하고 로또의 회차나 단어검색 입력받기
				System.out.println("# 당첨 판매점 조회 #");
				System.out.println(" [1] 회차검색  [2] 단어검색  ");
				String inPart = inputStr(" 입력 : ");
				
				if(inPart.equals("1")) {
					String inTaxis = inputStr(" 당첨회차 입력 : ");
					controller.winStore(1, inTaxis, new LTS1Model());
					
				} else if (inPart.equals("2")) {
					String inWord = inputStr(" 단어 입력 : ");
					controller.winStore(2, inWord, new LTS1Model());
					
				} else {
					System.out.println(" - 다시 입력하세요! -");
				}
				
				
				
				
				
			} else if (ser.equals("5")) {
				
				// 종료 
				System.out.println("종료를 선택하셨습니다");
				System.out.println("종료됩니다 .......   ");
				break;
				
			}
		}

		

		
		
		/*
		
		1. 인덱스로 검색 방법 선택 
		지역선택(콤보상자), 단어검색(입력), 행정구역선택(버튼)
		지역선택은 일단 놔두고 단어검색/행정구역 선택 
		
		2. 테이블 구조
		Store - 판매점
		storeName : 상호명
		storeAd : 소재지
		storeHp : 전화번호
		storeTrade : 취급복권
		
		Win - 당첨
		Store랑 관계있.. 
		winName : 당첨 상호명
		winTrade : 당첨 복권
		winGrade : 당첨 등수 
		winSub : 구분(자동/수동)
		
		3. 위치(지도) 어떻게 표현할 것인지?
		
		
		
		
		*/	
	}
	
	// 검색방법 선택
	public static String indexSearch() {
		System.out.println("# 검색방법을 선택하세요 (숫자로만 입력가능합니다) #");
		System.out.println(" [1] 전체조회 [2] 단어검색 [3] 지역검색 [5] 종료");
		String inString = inputStr(" 입력 : ");
		System.out.println();
		return inString;
	}
	
	// 문자입력받기
	public static String inputStr(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.print(msg);
		return sc.nextLine();
	}

}
