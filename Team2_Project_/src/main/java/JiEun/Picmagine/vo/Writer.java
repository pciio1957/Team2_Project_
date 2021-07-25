package JiEun.Picmagine.vo;

/*

Table : 작가(Writer)
작가번호
이름
영문이름
프로필이미지
프로필URL
외부공개이메일
회원번호

영문이름, 외부공개 이메일은 선택사항으로 작성
프로필 URL은 작가신청하면 만들어지는 url

*/

// 작가 + 작가소개 
public class Writer {
	private String wrtno;
	private String wrtkorname;
	private String wrtengname;
	private String wrtimgtitle;
	private String wrturl;
	private String wrtoutemail;
	private String memno;
	
	// 작가소개 테이블 컬럼
	private String wrtactivity;
	private String wrtsmallline; // 한줄소개
	private String wrtbigline; // 상세소개 
	private String wrtwebsite;
	
	public Writer() {
		super();
		// TODO Auto-generated constructor stub
	}

	// 작가정보 정보 중에 필수요소 
	public Writer(String wrtno, String wrtkorname, String memno) {
		super();
		this.wrtno = wrtno;
		this.wrtkorname = wrtkorname;
		this.memno = memno;
	}

	
	// 작가홈에 나타낼 정보 (Writer + WriterIntro를 join)
	public Writer(String wrtno, String wrtkorname, String wrtengname, String wrtimgtitle,
			String wrtactivity, String wrtsmallline, String wrtwebsite) {
		super();
		this.wrtno = wrtno;
		this.wrtkorname = wrtkorname;
		this.wrtengname = wrtengname;
		this.wrtimgtitle = wrtimgtitle;
		this.wrtactivity = wrtactivity;
		this.wrtsmallline = wrtsmallline;
		this.wrtwebsite = wrtwebsite;
	}
	
	// 작가홈 내용 출력
	public void writerInfo() {
		System.out.println("\n <작가 정보> ");
		System.out.println(" 작가번호 : " + wrtno);
		System.out.println(" 작가명 : " + wrtkorname);
		System.out.println(" 작가영어이름 : " + wrtengname);
		System.out.println(" 작가대표이미지명 : " + wrtimgtitle);		
		System.out.println(" 활동분야 : " + wrtactivity);
		System.out.println(" 작가소개 : " + wrtsmallline);
		System.out.println(" 웹사이트 : " + wrtwebsite + "\n");
	
	}

	public String getWrtno() {
		return wrtno;
	}

	public void setWrtno(String wrtno) {
		this.wrtno = wrtno;
	}

	public String getWrtkorname() {
		return wrtkorname;
	}

	public void setWrtkorname(String wrtkorname) {
		this.wrtkorname = wrtkorname;
	}

	public String getWrtengname() {
		return wrtengname;
	}

	public void setWrtengname(String wrtengname) {
		this.wrtengname = wrtengname;
	}

	public String getWrtimgtitle() {
		return wrtimgtitle;
	}

	public void setWrtimgtitle(String wrtimgtitle) {
		this.wrtimgtitle = wrtimgtitle;
	}

	public String getWrturl() {
		return wrturl;
	}

	public void setWrturl(String wrturl) {
		this.wrturl = wrturl;
	}

	public String getWrtoutemail() {
		return wrtoutemail;
	}

	public void setWrtoutemail(String wrtoutemail) {
		this.wrtoutemail = wrtoutemail;
	}

	public String getMemno() {
		return memno;
	}

	public void setMemno(String memno) {
		this.memno = memno;
	}

	public String getWrtactivity() {
		return wrtactivity;
	}

	public void setWrtactivity(String wrtactivity) {
		this.wrtactivity = wrtactivity;
	}

	public String getWrtsmallline() {
		return wrtsmallline;
	}

	public void setWrtsmallline(String wrtsmallline) {
		this.wrtsmallline = wrtsmallline;
	}

	public String getWrtbigline() {
		return wrtbigline;
	}

	public void setWrtbigline(String wrtbigline) {
		this.wrtbigline = wrtbigline;
	}

	public String getWrtwebsite() {
		return wrtwebsite;
	}

	public void setWrtwebsite(String wrtwebsite) {
		this.wrtwebsite = wrtwebsite;
	}
}
