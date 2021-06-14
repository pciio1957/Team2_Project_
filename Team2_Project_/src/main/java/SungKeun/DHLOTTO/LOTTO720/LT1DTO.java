package SungKeun.DHLOTTO.LOTTO720;

public class LT1DTO {
	
	private int ltType; // 조 선택 (자동, 1~5조)
	private int ltNum; // 0~9까지 6자리 고를 번호
	
	public LT1DTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public LT1DTO(int ltType, int ltNum) {
		super();
		this.ltType = ltType;
		this.ltNum = ltNum;
	}
	
	public int getLtType() {
		return ltType;
	}
	
	public void setLtType(int ltType) {
		this.ltType = ltType;
	}
	
	public int getLtNum() {
		return ltNum;
	}

	public void setLtNum(int ltNum) {
		this.ltNum = ltNum;
	}
	
}
