package JiEun.Picmagine.vo;


/*

Table : Series
시리즈번호
시리즈카테고리
시리즈제목
시리즈내용

*/
public class Series {
	private String serno;
	private String sercategory;
	private String sertitle;
	private String sercontent;
	
	public Series() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Series(String serno, String sercategory, String sertitle, String sercontent) {
		super();
		this.serno = serno;
		this.sercategory = sercategory;
		this.sertitle = sertitle;
		this.sercontent = sercontent;
	}

	public String getSerno() {
		return serno;
	}

	public void setSerno(String serno) {
		this.serno = serno;
	}

	public String getSercategory() {
		return sercategory;
	}

	public void setSercategory(String sercategory) {
		this.sercategory = sercategory;
	}

	public String getSertitle() {
		return sertitle;
	}

	public void setSertitle(String sertitle) {
		this.sertitle = sertitle;
	}

	public String getSercontent() {
		return sercontent;
	}

	public void setSercontent(String sercontent) {
		this.sercontent = sercontent;
	}
}
