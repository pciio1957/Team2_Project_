package JiEun.Picmagine.vo;

/*

Table : 작가소개(WriterIntro)
작가번호
한줄소개
활동분야
상세소개
웹사이트 

*/

public class WriterIntro {
	private String wrtno;
	private String wrtactivity;
	private String wrtsmallline; // 한줄소개
	private String wrtbigline; // 상세소개 
	private String wrtwebsite;
	
	public WriterIntro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WriterIntro(String wrtno, String wrtactivity, String wrtsmallline, String wrtbigline, String wrtwebsite) {
		super();
		this.wrtno = wrtno;
		this.wrtactivity = wrtactivity;
		this.wrtsmallline = wrtsmallline;
		this.wrtbigline = wrtbigline;
		this.wrtwebsite = wrtwebsite;
	}

	public String getWrtno() {
		return wrtno;
	}

	public void setWrtno(String wrtno) {
		this.wrtno = wrtno;
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
