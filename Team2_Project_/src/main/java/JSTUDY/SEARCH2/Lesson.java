package JSTUDY.SEARCH2;

import java.awt.Image;

public class Lesson {
	Image img; // 강의 이미지
	String name; // 강의 제목
	String mentor; // 강사 이름
	String reviewStar; // 별점
	int price; // 가격
	public Lesson() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Lesson(String name, String mentor, String reviewStar, int price) {
		super();
		this.img = img;
		this.name = name;
		this.mentor = mentor;
		this.reviewStar = reviewStar;
		this.price = price;
	}
	public Image getImg() {
		return img;
	}
	public void setImg(Image img) {
		this.img = img;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMentor() {
		return mentor;
	}
	public void setMentor(String mentor) {
		this.mentor = mentor;
	}
	public String getReviewStar() {
		return reviewStar;
	}
	public void setReviewStar(String reviewStar) {
		this.reviewStar = reviewStar;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
