package JSTUDY.SEARCH;

import java.awt.Image;
import java.util.ArrayList;


public class SearchDao {

	
	
	
	//Lesson(Image img, String name, String mentor, int price, String reviewStar)
	
	public ArrayList<Lesson> schList(SearchSch sch){
		ArrayList<Lesson> list = new ArrayList<Lesson>();
		System.out.println("# DB 서버에 넘겨줄 검색 데이터 #");
		System.out.println("강의 검색:"+sch.getKeyword());
		System.out.println("# DB 서버에서 온 데이터 리스트 #");
		list.add(new Lesson("쉽게 배우는 자바 ReactiveX","열악한 코딩사전","★★★★★",29700));
		list.add(new Lesson("자바 입문자를 위한 강의","TaeHyun","★★★★★",5500));
		list.add(new Lesson("자바 스프링 프레임워크","인프런","★★★★★",16500));
		for(Lesson ser:list) {
			System.out.print(ser.getName()+"\t");
			System.out.print(ser.getMentor()+"\t");
			System.out.print(ser.getReviewStar()+"\t");
			System.out.print(ser.getPrice()+"\n");
		}
		return list;
		
	}
//	public String[] searchInDetail(SearchSch sch) {
//		//검색 조건들
//		String indetail[] = {"난이도: 입문,초급,중급이상",
//							"유료/무료/할인중: 유료,무료,할인중",
//							"온라인/오프라인: 온라인,오프라인",
//		};
//		System.out.println("# 상세검색 #");
//		for(int i=0; i<indetail.length; i++) {
//			System.out.println(indetail[i]);
//		
//		}
//		return indetail;
//	}
	
}
//	Lesson l = new Lesson("쉽게 배우는 ReactiveX","열악한 코딩사전","★★★★★",29700);
//(String name, String mentor, String countOfStar, int price, int price_origin, String etc) 
/*
	public ArrayList<SearchSch> schList(SearchSch sch){
		ArrayList<SearchSch> list = new ArrayList<SearchSch>();
		System.out.println("# DB 서버에 넘겨줄 검색 데이터 #");
		System.out.println("강의검색어:"+sch.getSearch());
		System.out.println("강의제목:"+sch.getName());
		System.out.println("강사:"+sch.getMentor());
		System.out.println("별점:"+sch.getCountOfStar());
		System.out.println("가격:"+sch.getPrice());
		System.out.println("# DB 서버에서 온 데이터 리스트 #");
		System.out.print("강의검색어\t	강의제목\t  	강사\t 별점\t 가격\n");
		list.add(new SearchSch("자바","쉽게 배우는 ReactiveX","김프링","★★★★★",29700,23760,"할인중"));
		list.add(new SearchSch("자바","자바 입문자를 위한 강의","TaeHyun","★★★★★",5500,5500,"없음"));
		list.add(new SearchSch("자바","자바 스프링 프레임워크","인프런","★★★★★",16500,16500,"없음"));
		for(SearchSch ser:list) {
			System.out.print(ser.getSearch()+"\t");
			System.out.print(ser.getName()+"\t");
			System.out.print(ser.getMentor()+"\t");
			System.out.print(ser.getCountOfStar()+"\t");
			System.out.print(ser.getPrice()+"\n");
		}
		return list;
	}
	
	
	

	
	
*/