package PICMAGIN_ART_SEARCH;

public class Art {
	
	

	String artimg;
	String title;
	String category;
	String introduce;
	String date2;
	String auth; //권한 
	int sNum; // 판매여부 
	int aNum; //작품 시리즈여부 

public Art() {
super();
// TODO Auto-generated constructor stub
}



	public Art(String artimg, String title, String category, String introduce, String date2, String auth, int sNum,
		int aNum) {
	super();
	this.artimg = artimg;
	this.title = title;
	this.category = category;
	this.introduce = introduce;
	this.date2 = date2;
	this.auth = auth;
	this.sNum = sNum;
	this.aNum = aNum;
}



	public Art(String category,int sNum, int aNum) {
		super();
		this.category = category;
		this.sNum = sNum;
		this.aNum = aNum;
	}



	public String getArtimg() {
		return artimg;
	}


	public void setArtimg(String artimg) {
		this.artimg = artimg;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
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


	public int getsNum() {
		return sNum;
	}


	public void setsNum(int sNum) {
		this.sNum = sNum;
	}


	public int getaNum() {
		return aNum;
	}


	public void setaNum(int aNum) {
		this.aNum = aNum;
	}


	public void ShowInfo() {
		
		//System.out.println("\t이미지\t제목\t카테고리명\t소개\t날짜\t권한\t판매여부\t작품시리즈여부");
		
		System.out.println(" [" + "]" +"\t"+artimg+"\t"+title+"\t"+category+""+"\t"+ introduce + "" + "  "+date2 + "" +"\t"+" "+ auth +"\t"+ "" 
		+"\t"+ sNum +""+ "\t"+aNum+"\n");
		
	}
}
