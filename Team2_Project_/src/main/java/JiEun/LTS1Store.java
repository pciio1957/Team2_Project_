package JiEun;

// Store 클래스 : 판매점을 정의한 클래스 
public class LTS1Store {
	private String storeName;  // 상호명
	private String storeHp;    // 전화번호
	private String storeAd;    // 소재지
	private String storeTrade; // 취급복권
	
	public LTS1Store() {
		super();
	}

	public LTS1Store(String name, String hp, String ad, String trade) {
		super();
		this.storeName = name;
		this.storeHp = hp;
		this.storeAd = ad;
		this.storeTrade = trade;
	}
	
	public String showInfo(int num) {
		System.out.println(" [" + num + "]  상호명 : " +storeName + "");
		System.out.println(" [" + num + "]  소재지 : " +storeAd + "");		
		System.out.println(" [" + num + "] 전화번호 : " +storeHp + "");
		System.out.println(" [" + num + "] 취급복권 : " +storeTrade + "\n");

		return "조회완료"; 
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreHp() {
		return storeHp;
	}

	public void setStoreHp(String storeHp) {
		this.storeHp = storeHp;
	}

	public String getStoreAd() {
		return storeAd;
	}

	public void setStoreAd(String storeAd) {
		this.storeAd = storeAd;
	}

	public String getStoreTrade() {
		return storeTrade;
	}

	public void setStoreTrade(String storeTrade) {
		this.storeTrade = storeTrade;
	}
}
