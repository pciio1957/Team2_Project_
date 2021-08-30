package JSTUDY.SEARCH;

import java.awt.Image;
import java.util.Scanner;

public class SearchMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
// 화면에서 처리하는 부분을 main()을 통해
// public Lesson(Image img, String name, String mentor, String reviewStar, int price)
		Scanner sc = new Scanner(System.in);
		System.out.println("검색어를 입력하세요:");//강의명 검색 
		//String a = sc.nextLine();
		
		SearchSch sch = new SearchSch("자바");
		
		SearchController ctrl = new SearchController();
		System.out.println("#호출된 화면#");
		System.out.println(ctrl.schList(sch, new Model()));
		System.out.println();
		
	}
		
}



/*
public String[] searchInDetail(SearchSch sch) {
		//검색 조건들
		String indetail[] = {"난이도: 입문,초급,중급이상",
							"유료/무료/할인중: 유료,무료,할인중",
							"온라인/오프라인: 온라인,오프라인",
		};
			
		System.out.println("# 상세검색 #");
		for(int i=0; i<indetail.length; i++) {
			System.out.println(indetail[i]);
		}
		return indetail;
	}


		SearchSch sch = new SearchSch("자바","쉽게 배우는 ReactiveX",
				"열악한 코딩사전","★★★★★",29700,23760,"할인");
		SearchController ctrl = new SearchController();
		System.out.println("#호출된 화면#");
		System.out.println(ctrl.schList(sch, new Model()));
	}
*/