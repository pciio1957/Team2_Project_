package JiEun.Picmagine.vo;

/*

Table : Follow
팔로우번호
작가번호
회원번호 

*/
public class Follow {
	private String flwno; 
	private String artno;
	private String memno;
	
	public Follow() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Follow(String flwno, String artno, String memno) {
		super();
		this.flwno = flwno;
		this.artno = artno;
		this.memno = memno;
	}

	public String getFlwno() {
		return flwno;
	}

	public void setFlwno(String flwno) {
		this.flwno = flwno;
	}

	public String getArtno() {
		return artno;
	}

	public void setArtno(String artno) {
		this.artno = artno;
	}

	public String getMemno() {
		return memno;
	}

	public void setMemno(String memno) {
		this.memno = memno;
	}
}
