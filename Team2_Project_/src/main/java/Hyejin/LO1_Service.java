package Hyejin;

import java.util.ArrayList;


public class LO1_Service {

	
	//service : [DB처리가 필요없고], [입력]을 통해서 [반복이나 조건처리]가 필요한 부분 
	
	ArrayList<LO1_List> winlist;
	
	LO1_Dao dao = new LO1_Dao(); 
	
	public String list(SearchNumber s) { //DAO와 같은 기능메서드 호출
	
		
		//ArrayList<LO1_List> winlist; //new ArrayList<LO1_List>();
		
		System.out.println("# 검색리스트 #");
		System.out.println(" - " +"["+ s.getNum01() +"]"+"["+s.num02+"]"+"["+s.num03+"]"+
				"["+s.num04+"]"+"["+s.num05+"]"+"["+s.num06+"]"+": 검색 결과 ");
		
		
		winlist = dao.list(s); 
		
		for(LO1_List l:winlist) { //arraylist반복 
			// 사용자가 입력한 6자리 입력값이 [당첨번호]에 있으면 출력 
			if(l.wincode.contains(s.getNum01())||l.wincode.contains(s.getNum02())
					||l.wincode.contains(s.getNum03())||l.wincode.contains(s.getNum04())
					||l.wincode.contains(s.getNum05())||l.wincode.contains(s.getNum06())) {
				l.showInfo(s);
				
			//반복문  contain(); 
			//이중함수
			//갯수 =>
			
			
		
		
		System.out.println("회차번호"+"\t"+ "날짜"+"\t"+"\t"+"당첨번호"+"\t"+"\t"+"\t"+"보너스번호"+"\t"+"갯수");
		System.out.println("DAO에 전송 데이터: " + s.getNum01());
		//System.out.println("DAO에서 받은 크기:" + dao.list(s).size());//
			
	

	
				
			}
	
		}
		return "완료";
	}

}
	
