package JiEun;

public class LTS1Lotto {
	public String lttaxis;      // 회차 
	public int[] ltwinNums;  // 당첨번호들
	public String ltName;    // 판매점명
	public String itArea;    // 소재지
	public boolean isFirst;  // 1등 여부 
	public boolean isSecond; // 2등 여부 
	
	public LTS1Lotto() {
		super();
	}
	
	public LTS1Lotto(String lttaxis, int[] ltwinNums, String ltName, boolean isFirst, boolean isSecond) {
		super();
		this.lttaxis = lttaxis;
		this.ltwinNums = ltwinNums;
		this.ltName = ltName;
		this.itArea = itArea;
		this.isFirst = isFirst;
		this.isSecond = isSecond;
	}
	
	public LTS1Lotto(String lttaxis, int[] ltwinNums, String ltName, String itArea, boolean isFirst, boolean isSecond) {
		super();
		this.lttaxis = lttaxis;
		this.ltwinNums = ltwinNums;
		this.ltName = ltName;
		this.itArea = itArea;
		this.isFirst = isFirst;
		this.isSecond = isSecond;
	}

	public void showInfo() {
		
		System.out.println(" 회차 : " + lttaxis);
		// 당첨번호 출력을 위한 for문
		for(int x = 0; x < ltwinNums.length; x++ ) {
				
		}
		// --------------- 회차에 맞는 정보가 떠야하는데 1등 리스트 따로 2등리스트 따로.. 
//				
//		System.out.println(" 판매점명 : " + ltName);
//		System.out.println(" 1등여부 : " + (isFirst?"1등":" "));
//		System.out.println(" 2등여부 : " + (isSecond?"2등":" "));

		
	}


	public String getLttaxis() {
		return lttaxis;
	}



	public void setLttaxis(String lttaxis) {
		this.lttaxis = lttaxis;
	}



	public int[] getLtwinNums() {
		return ltwinNums;
	}



	public void setLtwinNums(int[] ltwinNums) {
		this.ltwinNums = ltwinNums;
	}



	public String getLtName() {
		return ltName;
	}



	public void setLtName(String ltName) {
		this.ltName = ltName;
	}



	public boolean isFirst() {
		return isFirst;
	}



	public void setFirst(boolean isFirst) {
		this.isFirst = isFirst;
	}



	public boolean isSecond() {
		return isSecond;
	}



	public void setSecond(boolean isSecond) {
		this.isSecond = isSecond;
	}
}
