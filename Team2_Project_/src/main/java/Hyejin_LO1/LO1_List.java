package Hyejin_LO1;

import java.util.Arrays;

//당첨내역을 정의한 클래스 

public class LO1_List {
	
	int num; //회차
	int date; //날짜
	String wincode;  //당첨번호
	int bounus; //보너스번호 
	String searchNumber; //검색번호
	int count;
	
	//기본 생성자 선언 
	public LO1_List(int num, int date, String wincode, int bounus,  int count) {
		super();
		this.num = num;
		this.date = date;
		this.wincode =wincode;
		this.bounus = bounus;
		this.count = count;
		
	}
	public void showInfo(String SearchNumber) { 
		//사용자가 검색번호를 입력하면 나오는 값들.. 
		//호출 목록
		//겹치는 갯수 count 추가 
		System.out.println("회원님께서 입력하신 번호" +SearchNumber+"의 결과값은 다음과같습니다." );
		System.out.println("회차 : "+ num+ "" );
		System.out.println("날자: " + date + "");		
		System.out.println("당첨번호:" + wincode + "" );
		System.out.println("보너스번호:"+ bounus +"");
		System.out.println("겹치는 숫자 갯수:" + count + "\n");
}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}

	public String getWincode() {
		return wincode;
	}
	public void setWincode(String wincode) {
		this.wincode = wincode;
	}
	public int getBounus() {
		return bounus;
	}
	public void setBounus(int bounus) {
		this.bounus = bounus;
	}

	public String getSearchNumber() {
		return searchNumber;
	}
	public void setSearchNumber(String searchNumber) {
		this.searchNumber = searchNumber;
	}
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	public void showInfo(SearchNumber s) {
		// TODO Auto-generated method stub
		
	}

	
}