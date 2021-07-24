package DaEun.Jstudy;
// faq VO
public class FAQ_DTO {
 private String fname; // FAQ게시물 제목
 private String fwrite;// FAQ 게시물 내용
public FAQ_DTO(String fname, String fwrite) {
	super();
	this.fname = fname;
	this.fwrite = fwrite;
}
public FAQ_DTO() {
	// TODO Auto-generated constructor stub
}
public void showInfo() {				
	System.out.println("FAQ 제목 : " + fname);
	System.out.println("FAQ 게시글 내용 : " + fwrite);	
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getFwrite() {
	return fwrite;
}
public void setFwrite(String fwrite) {
	this.fwrite = fwrite;
}
}
