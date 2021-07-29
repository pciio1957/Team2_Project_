package PICMAGIN_ART_SEARCH;


public class Comment {
	String ccomentcode; //댓글
	String date1; //날짜
	String content;//내용
	String cimg;//이미지
	String ccomentcode2;//상위댓글
	int anum; //작가번호
	String art; //작품번호 
	
	
	
	public Comment(String ccomentcode, String date1, String content, String cimg, String ccomentcode2, int anum, //입력 생성자2 
			String art) {
		super();
		this.ccomentcode = ccomentcode;
		this.date1 = date1;
		this.content = content;
		this.cimg = cimg;
		this.ccomentcode2 = ccomentcode2;
		this.anum = anum;
		this.art = art;
	}
	public String toString() {
		
		return "[날짜]" + "\t" + "[내용]" + "\t" + "\t" +"[작품번호]" +"\n"+""+ date1 + "\t" + content + " " + art +"\t";
	}


	public void Showinfo(int idx) {
			
		System.out.println(" [" + idx + "]" +"\t"+ccomentcode+""+"\t"+ date1 + "" + "  "+content + "" +"\t"+"   "+ cimg +"\t"+ "" 
		+"\t"+ ccomentcode2 +""+ "\t"+anum+""+"\t"+art+"\n");
	}
	
	
	public String getCcomentcode() {
		return ccomentcode;
	}
	public void setCcomentcode(String ccomentcode) {
		this.ccomentcode = ccomentcode;
	}
	public String getDate1() {
		return date1;
	}
	public void setDate1(String date1) {
		this.date1 = date1;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCimg() {
		return cimg;
	}
	public void setCimg(String cimg) {
		this.cimg = cimg;
	}
	public String getCcomentcode2() {
		return ccomentcode2;
	}
	public void setCcomentcode2(String ccomentcode2) {
		this.ccomentcode2 = ccomentcode2;
	}
	public int getAnum() {
		return anum;
	}
	public void setAnum(int anum) {
		this.anum = anum;
	}
	public String getArt() {
		return art;
	}
	public void setArt(String art) {
		this.art = art;
	}
}
