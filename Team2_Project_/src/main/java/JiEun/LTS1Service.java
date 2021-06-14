package JiEun;

import java.util.ArrayList;

public class LTS1Service {
	private ArrayList<LTS1Store> storeList = new ArrayList<LTS1Store>();
	LTS1DAO dao = new LTS1DAO();
	
	// storeList 불러오기 
	public String storeList() {
		System.out.println(" [Service] 판매점리스트 조회 ");
		storeList = dao.storeList();
		int num = 1;
		
		System.out.println("\n# 판매점 조회 #");
		for(LTS1Store s:storeList) {
			s.showInfo(num);
			num++;
		}
		System.out.println();
		
		return "완료";
	}

}
