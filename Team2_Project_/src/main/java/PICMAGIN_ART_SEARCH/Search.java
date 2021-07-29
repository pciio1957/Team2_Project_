package PICMAGIN_ART_SEARCH;

public class Search {
	
	String art;
	String category;
	String artimg;
	String title;
	String introduce;
	String date2;
	String auth;
	int anum;
	String siriesnum;
	public Search() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void Showinfo(int idx) {
		
		System.out.println(" [" + idx + "]" +"\t"+art+""+"\t"+ category + "" + "  "+artimg + "" +"\t"+"   "+ title +"\t"+ "" 
		+"\t"+ introduce +""+ "\t"+date2+""+"\t"+auth+"\t"+anum+"\t"+siriesnum);
	}
	public Search(String art, String category, String artimg, String title, String introduce, String date2, String auth,
			int anum, String siriesnum) {
		super();
		this.art = art;
		this.category = category;
		this.artimg = artimg;
		this.title = title;
		this.introduce = introduce;
		this.date2 = date2;
		this.auth = auth;
		this.anum = anum;
		this.siriesnum = siriesnum;
	}
	public String getArt() {
		return art;
	}
	public void setArt(String art) {
		this.art = art;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getArimg() {
		return artimg;
	}
	public void setArimg(String arimg) {
		this.artimg = arimg;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getDate2() {
		return date2;
	}
	public void setDate2(String date2) {
		this.date2 = date2;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public int getAnum() {
		return anum;
	}
	public void setAnum(int anum) {
		this.anum = anum;
	}
	public String getSiriesnum() {
		return siriesnum;
	}
	public void setSiriesnum(String siriesnum) {
		this.siriesnum = siriesnum;
	}
}
