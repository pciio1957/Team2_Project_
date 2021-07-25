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
public class Artist {
	private String artno;
	private String artkorname;
	private String artengname;
	private String artimgtitle;
	private String arturl;
	private String artoutemail;
	private String memno;
	
	// 작가소개 테이블 컬럼
	private String artactivity;
	private String artsmallline; // 한줄소개
	private String artbigline; // 상세소개 
	private String artwebsite;
	
	public Artist() {
		super();
		// TODO Auto-generated constructor stub
	}

	// 작가정보 정보 중에 필수요소 
	public Artist(String artno, String artkorname, String memno) {
		super();
		this.artno = artno;
		this.artkorname = artkorname;
		this.memno = memno;
	}

	
	// 작가홈에 나타낼 정보 (Writer + WriterIntro를 join)
	public Artist(String artno, String artkorname, String artengname, String artimgtitle,
			String artactivity, String artsmallline, String artwebsite) {
		super();
		this.artno = artno;
		this.artkorname = artkorname;
		this.artengname = artengname;
		this.artimgtitle = artimgtitle;
		this.artactivity = artactivity;
		this.artsmallline = artsmallline;
		this.artwebsite = artwebsite;
	}
	
	// 작가홈 내용 출력
	public void ArtistInfo() {
		System.out.println("\n <작가 정보> ");
		System.out.println(" 작가번호 : " + artno);
		System.out.println(" 작가명 : " + artkorname);
		System.out.println(" 작가영어이름 : " + artengname);
		System.out.println(" 작가대표이미지명 : " + artimgtitle);		
		System.out.println(" 활동분야 : " + artactivity);
		System.out.println(" 작가소개 : " + artsmallline);
		System.out.println(" 웹사이트 : " + artwebsite + "\n");
	
	}

	public String getArtno() {
		return artno;
	}

	public void setArtno(String artno) {
		this.artno = artno;
	}

	public String getArtkorname() {
		return artkorname;
	}

	public void setArtkorname(String artkorname) {
		this.artkorname = artkorname;
	}

	public String getArtengname() {
		return artengname;
	}

	public void setArtengname(String artengname) {
		this.artengname = artengname;
	}

	public String getArtimgtitle() {
		return artimgtitle;
	}

	public void setArtimgtitle(String artimgtitle) {
		this.artimgtitle = artimgtitle;
	}

	public String getArturl() {
		return arturl;
	}

	public void setArturl(String arturl) {
		this.arturl = arturl;
	}

	public String getArtoutemail() {
		return artoutemail;
	}

	public void setArtoutemail(String artoutemail) {
		this.artoutemail = artoutemail;
	}

	public String getMemno() {
		return memno;
	}

	public void setMemno(String memno) {
		this.memno = memno;
	}

	public String getArtactivity() {
		return artactivity;
	}

	public void setArtactivity(String artactivity) {
		this.artactivity = artactivity;
	}

	public String getArtsmallline() {
		return artsmallline;
	}

	public void setArtsmallline(String artsmallline) {
		this.artsmallline = artsmallline;
	}

	public String getArtbigline() {
		return artbigline;
	}

	public void setArtbigline(String artbigline) {
		this.artbigline = artbigline;
	}

	public String getArtwebsite() {
		return artwebsite;
	}

	public void setArtwebsite(String artwebsite) {
		this.artwebsite = artwebsite;
	}
}
