package 프로젝트소스_공유용.지은_메뉴기능;

// 메뉴의 속성을 가진 클래스
public class Menu {
	public String kind;  // 메뉴의 구분
	public String name;  // 메뉴의 이름
	public int price;    // 메뉴의 가격
	public String size;  // 메뉴의 사이즈/용량
	public int count; 	 // 메뉴의 수량 

	public Menu() {
		super();
	}

	public Menu(String k, String n, int p, String s) {
		super();
		this.kind = k;
		this.name = n;
		this.price = p;
		this.size = s;
	}
	
	public void showMenu(int idx) {
		System.out.println(" [" + (idx+1) + "] " + "\t" + kind + "\t" 
				+ name + "\t" + size + "\t" + price);
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
}
