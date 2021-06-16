package JiEun;

// Store 클래스 : 판매점을 정의한 클래스 
public class LTS1Store {
	public String storeName;  // 상호명
	public String storeAd;    // 소재지(주소)
	public String storeHp;    // 전화번호
	public String storeTicket; // 취급복권
	
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
	
	public String showInfo(int num) {
		System.out.println(" [" + num + "]  상호명 : " +storeName + "");
		System.out.println(" [" + num + "]  소재지 : " +storeAd + "");		
		System.out.println(" [" + num + "] 전화번호 : " +storeHp + "");
		System.out.println(" [" + num + "] 취급복권 : " +storeTicket + "\n");

		return "조회완료"; 
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
