package JiEun.Picmagine.vo;

import java.util.Date;

/*

Table : 작품(Artworks)
작품번호
카테고리
작품이미지
작품제목
작품소개
업로드시간
저작권권한
작가번호
시리즈번호
*/

public class Artworks {
	private String artno;
	private String artcategory;
	private String artimgtitle;
	private String arttitle;
	private String artcontent;
	private Date artdate;
	private String artpicauth;
	private String wrtno;
	private String serno;
	
	public Artworks() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Artworks(String artno, String artcategory, String artimgtitle, String arttitle, String artcontent,
			Date artdate, String artpicauth, String wrtno, String serno) {
		super();
		this.artno = artno;
		this.artcategory = artcategory;
		this.artimgtitle = artimgtitle;
		this.arttitle = arttitle;
		this.artcontent = artcontent;
		this.artdate = artdate;
		this.artpicauth = artpicauth;
		this.wrtno = wrtno;
		this.serno = serno;
	}
	
	public void workInfo() {
		System.out.println(" <작품정보>");
		System.out.println(" 작품번호 : " + artno);
		System.out.println(" 작품카테고리 : " + artcategory);
		System.out.println(" 작품이미지명 : " + artimgtitle);
		System.out.println(" 작품명 : " + arttitle);
		System.out.println(" 작품소개 : " + artcontent);
		System.out.println(" 작품게시일 : " + artdate);
		System.out.println(" 작품사용권한 : " + artpicauth);
		System.out.println(" 작가번호 : " + wrtno);
		System.out.println(" 시리즈명 : " + serno + "\n");

	}

	public String getArtno() {
		return artno;
	}

	public void setArtno(String artno) {
		this.artno = artno;
	}

	public String getArtcategory() {
		return artcategory;
	}

	public void setArtcategory(String artcategory) {
		this.artcategory = artcategory;
	}

	public String getArtimgtitle() {
		return artimgtitle;
	}

	public void setArtimgtitle(String artimgtitle) {
		this.artimgtitle = artimgtitle;
	}

	public String getArttitle() {
		return arttitle;
	}

	public void setArttitle(String arttitle) {
		this.arttitle = arttitle;
	}

	public String getArtcontent() {
		return artcontent;
	}

	public void setArtcontent(String artcontent) {
		this.artcontent = artcontent;
	}

	public Date getArtdate() {
		return artdate;
	}

	public void setArtdate(Date artdate) {
		this.artdate = artdate;
	}

	public String getArtpicauth() {
		return artpicauth;
	}

	public void setArtpicauth(String artpicauth) {
		this.artpicauth = artpicauth;
	}

	public String getWrtno() {
		return wrtno;
	}

	public void setWrtno(String wrtno) {
		this.wrtno = wrtno;
	}

	public String getSerno() {
		return serno;
	}

	public void setSerno(String serno) {
		this.serno = serno;
	}
}
