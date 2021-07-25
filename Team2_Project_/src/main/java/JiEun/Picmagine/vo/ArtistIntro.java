package JiEun.Picmagine.vo;

/*

Table : 작가소개(ArtistIntro)
작가번호
한줄소개
활동분야
상세소개
웹사이트 

*/

public class ArtistIntro {
	private String artno;
	private String artactivity;
	private String artsmallline; // 한줄소개
	private String artbigline; // 상세소개 
	private String artwebsite;
	
	public ArtistIntro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArtistIntro(String artno, String artactivity, String artsmallline, String artbigline, String artwebsite) {
		super();
		this.artno = artno;
		this.artactivity = artactivity;
		this.artsmallline = artsmallline;
		this.artbigline = artbigline;
		this.artwebsite = artwebsite;
	}

	public String getArtno() {
		return artno;
	}

	public void setArtno(String artno) {
		this.artno = artno;
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
