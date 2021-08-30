package DONGHANG.STORESEARCH;

import java.util.ArrayList;

// Store 클래스 : 판매점을 정의한 클래스 
public class LTS1Store {
	public String stOpen;   // 영업유무
	public String stName;   // 상호명
	public String stAd;     // 소재지
	public String stHp;     // 전화번호
	public String stTicket; // 취급복권
	
	// 지역구분을 위한 ArrayList<String>
	public ArrayList<String> areaStrList = new ArrayList<String>();
	
	public LTS1Store() {
		super();
	}

	public LTS1Store(String op, String nm, String ad, String hp, String tk) {
		super();
		this.stOpen = op;
		this.stName = nm;
		this.stAd = ad;
		this.stHp = hp;
		this.stTicket = tk;
	}
	
	public String showInfo(int idx) {
		System.out.println(" [" + idx + "]  영업유무 : " +stOpen + "");
		System.out.println(" [" + idx + "]   상호명 : " +stName + "");
		System.out.println(" [" + idx + "]   소재지 : " +stAd + "");		
		System.out.println(" [" + idx + "]  전화번호 : " +stHp + "");
		System.out.println(" [" + idx + "]  취급복권 : " +stTicket + "\n");
		return "[DTO/Store] 전체조회완료"; 
	}
	
	public void showWWW() {
		System.out.println("확인쓰");
	}
	
	public String showArea(int idx) {
		
		// 첫번째자리 
		String[] adress = stAd.split(" ");
		

		String strAd = "[" + idx + "] ";  
		int idxNum = 0; // 소재지에서 2번째까지만 추출
		
		for(String ad:adress) {
			if(idxNum == 0) {
				areaStrList.add(ad);
				strAd += ad;
				idxNum++;
			} else if (idxNum == 1) {
				areaStrList.add(ad);
				strAd += "\t" + ad;
				idxNum++;
				
			} else {
				idxNum = 0;
				System.out.println(strAd);
				break;
			}		
		}	
		return "[DTO/Store] 지역조회완료";
	}
	
//	public String showWin() {
//		
//		return "[DTO/Store] 조회완료";
//	}

	public String getStoreName() {
		return stName;
	}

	public void setStoreName(String name) {
		this.stName = name;
	}

	public String getStoreHp() {
		return stHp;
	}

	public void setStoreHp(String hp) {
		this.stHp = hp;
	}

	public String getStoreAd() {
		return stAd;
	}

	public void setStoreAd(String address) {
		this.stAd = address;
	}

	public String getStoreTrade() {
		return stTicket;
	}

	public void setStoreTrade(String ticket) {
		this.stTicket = ticket;
	}
}
