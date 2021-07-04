package Hyejin.JSTUDY;

public class Cart {
	
	String img; //1. 강의사진 
	String title; // 2. 강의명 
	int price; //3. 강의금액
	int getpoint; //4. 적립예정 포인트 
	String code;
	
	
	public Cart() {
	
		// TODO Auto-generated constructor stub
	}
	
	public void Showinfo(int idx) {
		
		System.out.println(" [" + idx + "]" +"\t"+img +""+"\t"+ title + "" + "  "+price + "" +"\t"+"   "+ getpoint +"\t"+ "" +"\t"+ code +"  "+ "\n");
		
		
		
		
	}
	public Cart(String img, String title, int price, int getpoint, String code) {
		super();
		this.img = img;
		this.title = title;
		this.price = price;
		this.getpoint = getpoint;
		this.code = code;
	}
	public Cart(String code) {
		super();
		this.code = code;
	}
	
	
	public int getpoint() {
		getpoint = (int)(price * 0.1);// 0.1곱하면 double이니깐!!!
		return getpoint;
	}
	

	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getGetpoint() {
		return getpoint;
	}
	public void setGetpoint(int getpoint) {
		this.getpoint = getpoint;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	}
	

	

