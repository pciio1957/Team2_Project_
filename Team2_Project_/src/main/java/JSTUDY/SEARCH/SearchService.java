package JSTUDY.SEARCH;

import java.util.ArrayList;
import java.util.List;

public class SearchService {
	SearchDao dao = new SearchDao();
	
	public ArrayList<Lesson> schList(SearchSch sch){
		System.out.println("# 서비스 단 처리#");
		System.out.println("DAO에 전송 데이터1:"+sch.getKeyword());
		System.out.println("DAO에 받은 데이터 크기:"+
					dao.schList(sch).size());
		return dao.schList(sch);
	}

//	public List<Category> cateList();
}
//(String name, String mentor, String countOfStar, int price, int price_origin, String etc) 
//System.out.println("# 서비스 단 처리#");
//System.out.print("강의제목:"+sch.getName());
//System.out.println("별점:"+sch.getCountOfStar());
//System.out.println("가격:"+sch.getPrice());
//System.out.println("할인가격"+sch.getPrice_origin());

/*
	SearchDao dao = new SearchDao();
	
	public ArrayList<SearchSch> schList(SearchSch sch){
		System.out.println("# 서비스 단 처리#");
		System.out.println("DAO에 전송 데이터1:"+sch.getName());
		System.out.println("DAO에 받은 데이터 크기:"+
					dao.schList(sch).size());
		
		return dao.schList(sch);
	}
*/