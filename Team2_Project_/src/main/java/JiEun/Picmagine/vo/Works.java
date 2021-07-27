package JiEun.Picmagine.vo;

import java.util.Date;

/*

Table : 작품(Works)
작품번호
카테고리
작품이미지
작품제목
작품소개
업로드시간
저작권권한
작가번호
시리즈번호

Table : 시리즈(Series)
시리즈번호
시리즈카테고리
시리즈명
시리즈내용

*/


public class Works {
	private String wrkno;
	private String wrkcategory;
	private String wrkimgtitle;
	private String wrktitle;
	private String wrkcontent;
	private Date wrkdate;
	private String wrkpicauth;
	private String artno;
	
	private String serno;
	private String sercategory;
	private String sertitle;
	private String sercontent;
	
	public Works() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Works(String wrkno, String wrkcategory, String wrkimgtitle, String wrktitle, String wrkcontent,
			Date wrkdate, String wrkpicauth, String serno, String artno) {
		super();
		this.wrkno = wrkno;
		this.wrkcategory = wrkcategory;
		this.wrkimgtitle = wrkimgtitle;
		this.wrktitle = wrktitle;
		this.wrkcontent = wrkcontent;
		this.wrkdate = wrkdate;
		this.wrkpicauth = wrkpicauth;
		this.artno = artno;
		this.serno = serno;
	}
	
	public Works(String wrkno, String wrkcategory, String wrkimgtitle, String wrktitle, 
			String wrkcontent, Date wrkdate, String wrkpicauth, String serno, String artno,  
			String sercategory, String sertitle, String sercontent) {
		super();
		this.wrkno = wrkno;
		this.wrkcategory = wrkcategory;
		this.wrkimgtitle = wrkimgtitle;
		this.wrktitle = wrktitle;
		this.wrkcontent = wrkcontent;
		this.wrkdate = wrkdate;
		this.wrkpicauth = wrkpicauth;
		this.artno = artno;		
		this.serno = serno;
		this.sercategory = sercategory;
		this.sertitle = sertitle;
		this.sercontent = sercontent;
	}

	public void workInfo() {
		System.out.println(" <작품정보>");
		System.out.println(" 작품번호 : " + wrkno);
		System.out.println(" 작품카테고리 : " + wrkcategory);
		System.out.println(" 작품이미지명 : " + wrkimgtitle);
		System.out.println(" 작품명 : " + wrktitle);
		System.out.println(" 작품소개 : " + wrkcontent);
		System.out.println(" 작품게시일 : " + wrkdate);
		System.out.println(" 작품사용권한 : " + wrkpicauth);
		System.out.println(" 작가번호 : " + artno);
		System.out.println(" 시리즈번호 : " + serno + "\n");
	}
	
	public void seriesInfo() {
		System.out.println(" <시리즈정보> ");
		System.out.println(" 시리즈번호 : " + serno);
		System.out.println(" 시리즈카테고리 : " + sercategory);
		System.out.println(" 시리즈명 : " + sertitle);
		System.out.println(" 시리즈내용 : " + sercontent + "\n");		
		
		System.out.println(" <작품정보>");
		System.out.println(" 작품번호 : " + wrkno);
		System.out.println(" 작품카테고리 : " + wrkcategory);
		System.out.println(" 작품이미지명 : " + wrkimgtitle);
		System.out.println(" 작품명 : " + wrktitle);
		System.out.println(" 작품소개 : " + wrkcontent);
		System.out.println(" 작품게시일 : " + wrkdate);
		System.out.println(" 작품사용권한 : " + wrkpicauth);
		System.out.println(" 작가번호 : " + artno);
	}
	
	

	public String getWrkno() {
		return wrkno;
	}

	public void setWrkno(String wrkno) {
		this.wrkno = wrkno;
	}

	public String getWrkcategory() {
		return wrkcategory;
	}

	public void setWrkcategory(String wrkcategory) {
		this.wrkcategory = wrkcategory;
	}

	public String getWrkimgtitle() {
		return wrkimgtitle;
	}

	public void setWrkimgtitle(String wrkimgtitle) {
		this.wrkimgtitle = wrkimgtitle;
	}

	public String getWrktitle() {
		return wrktitle;
	}

	public void setWrktitle(String wrktitle) {
		this.wrktitle = wrktitle;
	}

	public String getWrkcontent() {
		return wrkcontent;
	}

	public void setWrkcontent(String wrkcontent) {
		this.wrkcontent = wrkcontent;
	}

	public Date getWrkdate() {
		return wrkdate;
	}

	public void setWrkdate(Date wrkdate) {
		this.wrkdate = wrkdate;
	}

	public String getWrkpicauth() {
		return wrkpicauth;
	}

	public void setWrkpicauth(String wrkpicauth) {
		this.wrkpicauth = wrkpicauth;
	}

	public String getArtno() {
		return artno;
	}

	public void setArtno(String artno) {
		this.artno = artno;
	}

	public String getSerno() {
		return serno;
	}

	public void setSerno(String serno) {
		this.serno = serno;
	}
}
