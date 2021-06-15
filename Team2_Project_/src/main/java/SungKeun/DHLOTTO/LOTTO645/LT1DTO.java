package SungKeun.DHLOTTO.LOTTO645;

public class LT1DTO {
	
	private int myLotto[] = new int[6];
	private int result[] = new int[6];
	
	public LT1DTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LT1DTO(int[] myLotto, int[] result) {
		super();
		this.myLotto = myLotto;
		this.result = result;
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
