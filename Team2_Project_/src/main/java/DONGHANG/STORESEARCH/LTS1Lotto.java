package DONGHANG.STORESEARCH;

public class LTS1Lotto {
	public String lttaxis;       // 회차 
	public int ltrank;			 // 등수
	public String ltdrawMethod;  // 당첨구분(자동/수동)
	public String ltName;        // 상호명
	public String ltAd;          // 소재지

	// 생성자
	public LTS1Lotto(String lttaxis, int ltrank, 
			String ltdrawMethod, String ltName) {
		super();
		this.lttaxis = lttaxis;
		this.ltrank = ltrank;
		this.ltdrawMethod = ltdrawMethod;
		this.ltName = ltName;
	}

	// 생성자
	public LTS1Lotto(String lttaxis, int ltrank, String ltdrawMethod, String ltName, String ltAd) {
		super();
		this.lttaxis = lttaxis;
		this.ltrank = ltrank;
		this.ltdrawMethod = ltdrawMethod;
		this.ltName = ltName;
		this.ltAd = ltAd;
	}

	// 해당 DB의 정보출력 메소드
	public void showInfo(int idx) {
		
		//System.out.println(" 회차 : " + lttaxis);
		// 당첨번호 출력을 위한 for문
		
//		System.out.print("당첨번호 : ");
//		for(int x = 0; x < ltwinNums.length; x++ ) {
//			System.out.println(ltwinNums[x]);
//		}
		
		
		// --------------- 회차에 맞는 정보가 떠야하는데 1등 리스트 따로 2등리스트 따로.. 
//				
		System.out.println(" [" + idx + "] 구매구분 : " + ltdrawMethod);
		System.out.println(" [" + idx + "] 상호명 : " + ltName);
		System.out.println(" [" + idx + "] 소재지 : " + ltAd + "\n");


		
	}

	public String getLttaxis() {
		return lttaxis;
	}

	public void setLttaxis(String lttaxis) {
		this.lttaxis = lttaxis;
	}

	public int getLtrank() {
		return ltrank;
	}

	public void setLtrank(int ltrank) {
		this.ltrank = ltrank;
	}

	public String getLtdrawMethod() {
		return ltdrawMethod;
	}

	public void setLtdrawMethod(String ltdrawMethod) {
		this.ltdrawMethod = ltdrawMethod;
	}

	public String getLtName() {
		return ltName;
	}

	public void setLtName(String ltName) {
		this.ltName = ltName;
	}

	public String getLtAd() {
		return ltAd;
	}

	public void setLtAd(String ltAd) {
		this.ltAd = ltAd;
	}	
}
