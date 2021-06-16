package 프로젝트소스_공유용.지은_메뉴기능;

public class Cart {
	public String kind;    // 메뉴의 구분
	public String name;    // 메뉴의 이름
	public int price;      // 메뉴의 가격
	public String size;    // 메뉴의 사이즈/용량
	public int count; 	   // 메뉴의 수량 
	public String event;   // 세트일경우 세트명 입력(추가)
	public String receive; // 세트메뉴의 수령방법(추가)
	
	
	public Cart() {
		super();
	}

	// 1) 메뉴선택 - 메뉴 고를때 입력받는 생성자
	public Cart(String n, String s, int c) {
		super();
		this.name = n;
		this.size = s;
		this.count = c;
	}
	
	// 1) 메뉴선택 - 장바구니에 넣을때 사용할 생성자
	public Cart(String k, String n, int p, String s, int c) {
		super();
		this.kind = k;
		this.name = n;
		this.price = p;
		this.size = s;
		this.count = c;
	}
	
	// 4) 세트메뉴 - 세트 고를때 입력받을 생성자
	public Cart(String e, String n, String s, int c) {
		super();
		this.event = e;
		this.name = n;
		this.size = s;
		this.count = c;
	}
	
	// 4) 세트메뉴 - 세트 메뉴에 넣을 때 사용할 생성자
	public Cart(String event, int count) {
		super();
		this.event = event;
		this.count = count;
	}
	
	
	// 세트메뉴를 장바구니에 넣을라면 다 있어야함
	public Cart(String kind, String name, int price, String size, int count, String event, String receive) {
		super();
		this.kind = kind;
		this.name = name;
		this.price = price;
		this.size = size;
		this.count = count;
		this.event = event;
		this.receive = receive;
	}

	public void showCart(int idx) {
		if(event != null && receive != null) {
			System.out.println(" [" + (idx+1) + "]" + "\t" + event + "\t" + 
					receive + "\t" + kind + "\t" + name + "\t" 
					+ size + "\t" + price + "\t" + count);
		} else {
			System.out.println(" [" + (idx+1) + "]" + "\t\t\t" + kind 
					+ "\t" + name + "\t" + size + "\t" + price + "\t" + count);
		}
		
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getReceive() {
		return receive;
	}

	public void setReceive(String receive) {
		this.receive = receive;
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
	
	
	
	
	
	
}
