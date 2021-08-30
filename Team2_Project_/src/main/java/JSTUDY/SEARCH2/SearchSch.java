package JSTUDY.SEARCH2;

import java.awt.Image;

public class SearchSch {

	String keyword; //검색어
	String detailSearch; //기술검색
	public SearchSch() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SearchSch(String keyword) {
		super();
		this.keyword = keyword;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	
}
	
		
/*
 	private String search; //강의 검색어
		private String name; //강의 제목
		private	String 	mentor; // 강사 이름
		private String countOfStar; //별점
		private int price, price_origin; //가격, 할인된 가격
		private String etc; //기타정보
		*/
