package JiEun;

import java.util.ArrayList;

// Store 클래스 : 판매점을 정의한 클래스 
public class LTS1Store {
	public String storeName;  // 상호명
	public String storeAd;    // 소재지(주소)
	public String storeHp;    // 전화번호
	public String storeTicket; // 취급복권
	public ArrayList<String> areaStrList = new ArrayList<String>();
	
	public LTS1Store() {
		super();
	}

	public LTS1Store(String name, String ad, String hp, String ticket) {
		super();
		this.storeName = name;
		this.storeAd = ad;
		this.storeHp = hp;
		this.storeTicket = ticket;
	}
	
	public String showInfo(int idx) {
		System.out.println(" [" + idx + "]  상호명 : " +storeName + "");
		System.out.println(" [" + idx + "]  소재지 : " +storeAd + "");		
		System.out.println(" [" + idx + "] 전화번호 : " +storeHp + "");
		System.out.println(" [" + idx + "] 취급복권 : " +storeTicket + "\n");
		return "[DTO/Store] 전체조회완료"; 
	}
	
	public String showArea(int idx) {
		
		// 첫번째자리 
		String[] adress = storeAd.split(" ");
		

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

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String name) {
		this.storeName = name;
	}

	public String getStoreHp() {
		return storeHp;
	}

	public void setStoreHp(String hp) {
		this.storeHp = hp;
	}

	public String getStoreAd() {
		return storeAd;
	}

	public void setStoreAd(String address) {
		this.storeAd = address;
	}

	public String getStoreTrade() {
		return storeTicket;
	}

	public void setStoreTrade(String ticket) {
		this.storeTicket = ticket;
	}
}
