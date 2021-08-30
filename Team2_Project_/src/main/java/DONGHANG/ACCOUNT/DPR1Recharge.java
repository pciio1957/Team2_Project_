package DONGHANG.ACCOUNT;

public class DPR1Recharge {

	private String depositH; // 입금내역
	private String price; // 충전금액 
	private String bankName; // 계좌주명
	public DPR1Recharge() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DPR1Recharge(String depositH, String price, String bankName) {
		super();
		this.depositH = depositH;
		this.price = price;
		this.bankName = bankName;
	}
	public String getDepositH() {
		return depositH;
	}
	public void setDepositH(String depositH) {
		this.depositH = depositH;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
}
class DPR1Recharge2{
	private String orderNum; // 주문번호,
	private int orderPrice; // 결제금액
	private String bankId; // 계좌주명(ID)
	private String  vAccount; // 고정가상계좌
	private String payMethod; // 결제 방식
	private String issueDate; // 발급일시
	
}
