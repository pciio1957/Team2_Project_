package wish;
//
public class Lecture {

	String img; //1. 강의사진 
	String title; // 2. 강의명 
	int price; //3. 강의금액
	int getpoint; //4. 적립예정 포인트 
	String code; //강의코드
	int cnt;
	
	public String getCode() {
		return code;
	}

	public Lecture() {
		
		// TODO Auto-generated constructor stub
	}

	public Lecture(String img, String title, int price, int getpoint, String code, int cnt) {
		super();
		this.img = img;
		this.title = title;
		this.price = price;
		this.getpoint = getpoint;
		this.code = code;
		this.cnt = cnt;
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

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
