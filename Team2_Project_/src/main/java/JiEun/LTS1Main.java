package JiEun;

import java.util.Scanner;

public class LTS1Main {
	static LTS1Controller controller = new LTS1Controller();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("# 판매점 #");
		String ser = indexSearch();
		
		if(ser.equals("1")) {
			controller.storeList(1, new LTS1Model());
		} else if (ser.equals("2")) {
			;
		} else if (ser.equals("3")) {
			// 일부 검색으로 입력받아야 해서 새로운 메소드 생성 
			controller.storeList(3, new LTS1Model());
		} else if (ser.equals("4")) {
			controller.storeList(4, new LTS1Model());
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
		System.out.println(" [1] 전체조회 [2] 지역선택 [3] 단어검색 [4] 행정구역선택");
		String inString = inputStr(" 입력 : ");
		System.out.println(" 선택 : " + inString);
		return inString;
	}
	
	public static String inputStr(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.print(msg);
		return sc.nextLine();
	}

}
