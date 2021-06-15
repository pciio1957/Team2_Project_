package SungKeun.DHLOTTO.LOTTO645;

public class LT1DTO {
	
	private int lotto[] = new int[7]; // 당첨 복권 번호 생성
	private int myLotto[] = new int[6]; // 선택한 복권 번호 내역
	private int result[] = new int[6]; // 추첨 복권 번호 (선택 복권 번호와 일치 여부 확인)
	public LT1DTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LT1DTO(int[] lotto, int[] myLotto2, int[] result) {
		super();
		this.lotto = lotto;
		this.myLotto = myLotto2;
		this.result = result;
	}
	public int[] getLotto() {
		return lotto;
	}
	public void setLotto(int[] lotto) {
		this.lotto = lotto;
	}
	public int[] getMyLotto() {
		return myLotto;
	}
	public void setMyLotto(int[] myLotto) {
		this.myLotto = myLotto;
	}
	public int[] getResult() {
		return result;
	}
	public void setResult(int[] result) {
		this.result = result;
	}
	
}
