package Hyejin.JSTUDY;

public class Order {
	
	//Cart cart;
	int date; // 구매일
	String id; //회원아이디 
	String Ocode; //주문코드 
	String Lcode;// 강의코드
	String title;// 강의타이틀 
	String address;// 주소
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Order(int date, String id, String ocode, String lcode, String title, String address) {
		super();
		this.date = date;
		this.id = id;
		this.Ocode = ocode;
		this.Lcode = lcode;
		this.title = title;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOcode() {
		return Ocode;
	}
	public void setOcode(String ocode) {
		Ocode = ocode;
	}
	public String getLcode() {
		return Lcode;
	}
	public void setLcode(String lcode) {
		Lcode = lcode;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
