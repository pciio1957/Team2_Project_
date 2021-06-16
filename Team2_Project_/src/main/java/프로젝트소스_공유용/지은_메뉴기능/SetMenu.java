package 프로젝트소스_공유용.지은_메뉴기능;

public class SetMenu {
	public String sEvent; 	 // 세트명
	public String sKind; 	 // 세트에 포함되는 종류
	public String sName;  	 // 세트에 포함되는 메뉴이름
	public String sReceive;  // 세트의 수령방법
	public int sPrice; 		 // 세트메뉴의 가격
	public String sSize; 	 // 세트메뉴의 사이즈
	
	public SetMenu() {
		super();
	}
	
	public SetMenu(String e, String n) {
		super();
		this.sEvent = e;
		this.sName = n;
	}

	public SetMenu(String e, String k, String n, String r, int p, String s) {
		super();
		this.sEvent = e;
		this.sKind = k;
		this.sName = n;
		this.sReceive = r;
		this.sPrice = p;
		this.sSize = s;
	}
	


	public void showMenu(int idx) {
		System.out.println(" [" + (idx+1) + "] " + sEvent + "\t" + sKind 
			+ "\t" + sName + "\t" + sReceive + "\t"  + sSize + "\t" + sPrice);
	}


	public String getsEvent() {
		return sEvent;
	}

	public void setsEvent(String sEvent) {
		this.sEvent = sEvent;
	}

	public String getsKind() {
		return sKind;
	}

	public void setsKind(String sKind) {
		this.sKind = sKind;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsReceive() {
		return sReceive;
	}

	public void setsReceive(String sReceive) {
		this.sReceive = sReceive;
	}

	public int getsPrice() {
		return sPrice;
	}

	public void setsPrice(int sPrice) {
		this.sPrice = sPrice;
	}

	public String getsSize() {
		return sSize;
	}

	public void setsSize(String sSize) {
		this.sSize = sSize;
	}
}
