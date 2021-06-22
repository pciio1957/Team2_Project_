package Hyejin_LO1;

import java.util.ArrayList;

import JiEun.LTS1Store;

public class LO1_Service {

	
	//service : [DB처리가 필요없고], [입력]을 통해서 [반복이나 조건처리]가 필요한 부분 
	
	LO1_Dao dao = new LO1_Dao(); 
	
	public ArrayList<LO1_List> list(SearchNumber s) { //DAO와 같은 기능메서드 호출
	
		
		ArrayList<LO1_List> winlist = new ArrayList<LO1_List>();
		
		System.out.println("# 검색리스트 #");
		System.out.println(" - " +"["+ s.getNum01() +"]"+"["+s.num02+"]"+"["+s.num03+"]"+
				"["+s.num04+"]"+"["+s.num05+"]"+"["+s.num06+"]"+": 검색 결과 ");
		
		for(LO1_List l:winlist) {
			// 사용자가 입력한 6자리 입력값이 [당첨번호]에 있으면 출력 
			if(l.wincode.contains(s.getNum01())||l.wincode.contains(s.getNum02())
					||l.wincode.contains(s.getNum03())||l.wincode.contains(s.getNum04())
					||l.wincode.contains(s.getNum05())||l.wincode.contains(s.getNum06())) {
				l.showInfo(s);
			
			
			
		
		
		System.out.println("#서비스단처리#");
		System.out.println("DAO에 전송 데이터: " + s.getNum01());
		//System.out.println("DAO에서 받은 크기:" + dao.list(s).size());//
			
	

	
				
			}
	
		}
		return dao.list(s);
	}

}
	
