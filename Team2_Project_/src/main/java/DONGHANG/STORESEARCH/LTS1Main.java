package DONGHANG.STORESEARCH;

import java.util.Scanner;

public class LTS1Main {
	static LTS1Controller controller = new LTS1Controller();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// DB - Store(가게테이블), Lotto(로또당첨판매점테이블)
		
		while(true) {
			System.out.println("# 판매점 #");
			String ser = indexSearch(); // 검색방법 입력받기
			
			if(ser.equals("1")) {
				// 1. 전체리스트 불러오기 - 조회용 
				controller.storeList(1, new LTS1Model());
				
			} else if (ser.equals("2")) {
				
				// 2. 단어검색 - 단어필터, 상호명/지역명이 포함되는 판매점 출력
				System.out.println("# 판매점 단어검색 #");
				String inName = inputStr(" 검색할 상호명이나 지역 입력 : ");
				System.out.println();
				controller.wordSearch(inName, new LTS1Model());
				
			} else if (ser.equals("3")) {
				
				// 3. 지역검색 - 지역필터, 시/도나 구/군의 검색시 포함되는 판매점 출력
				System.out.println("# 판매점 지역검색 #");
				System.out.println(" 지역 리스트 ");
				controller.storeList(2, new LTS1Model());
				
				// 리스트 출력 후 그 리스트에서 지역 선택
				String inarea = inputStr("검색할 지역 입력 : "); 
				controller.areaSearch(inarea, new LTS1Model());
				

			} else if (ser.equals("4")) {
				
				// 4. 당첨 판매점 조회 - 회차필터, 회차검색시 해당 회차에 맞는 당첨 판매점 출력 
				System.out.println("# 당첨판매점 회차검색 #");
				String inTaxis = inputStr(" 당첨회차 입력 : ");

				controller.winTaxis(inTaxis, new LTS1Model());
				
				
			} else if (ser.equals("5")) {
				
				// 5. 당첨 판매점 조회 - 단어필터, 단어검색시 상호명/지역명이 포함되는 당첨 판매점 출력
				System.out.println("# 당첨판매점 단어검색 #");
				String inWord = inputStr(" 단어 입력 : ");

				controller.winWord(inWord, new LTS1Model()); 
				
				
			} else if (ser.equals("6")) {

				// 종료 
				System.out.println("종료를 선택하셨습니다");
				System.out.println("종료됩니다 .......   ");
				break;
				
			} else {
				
				System.out.println(" - 입력범위는 1~6입니다 - ");
				System.out.println(" - 다시 입력해주세요 - ");

			}
		}
	}
	
	// 검색방법 선택
	public static String indexSearch() {
		System.out.println(" (검색방법은 숫자로만 입력가능합니다) \n");
	
		System.out.println(" * 판매점 조회------- ");
		System.out.println(" [1] 판매점 - 전체조회 ");
		System.out.println(" [2] 판매점 - 단어검색 ");
		System.out.println(" [3] 판매점 - 지역검색 \n");
		
		System.out.println(" * 당첨판매점 조회------- ");
		System.out.println(" [4] 당첨판매점 - 회차검색 ");
		System.out.println(" [5] 당첨판매점 - 단어검색 ");
		System.out.println(" [6] 종료\n");
		
		
		String inString = inputStr(" -> 입력 : ");
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
