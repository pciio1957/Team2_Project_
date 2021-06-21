package Hyejin_LO1;

import java.util.ArrayList;

public class LO1_Service {

	
	//service : [DB처리가 필요없고], [입력]을 통해서 [반복이나 조건처리]가 필요한 부분 
	
	LO1_Dao dao = new LO1_Dao();
	
	public ArrayList<LO1_List> list(SearchNumber s) { //DAO와 같은 기능메서드 호출
	
		System.out.println("#서비스단처리#");
		System.out.println("DAO에 전송 데이터: " + s.getNum01());
		System.out.println("DAO에서 받은 크기:" + dao.list(s).size());
		
	
		
	return dao.list(s);
	
	}
	
}
