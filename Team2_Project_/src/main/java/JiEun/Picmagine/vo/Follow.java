package JiEun.Picmagine.vo;

/*

Table : Follow
팔로우번호
작가번호
회원번호 

*/
public class Follow {
	private String flwno; 
	private String wrtno;
	private String memno;
	
	public Follow() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Follow(String flwno, String wrtno, String memno) {
		super();
		this.flwno = flwno;
		this.wrtno = wrtno;
		this.memno = memno;
	}

	public String getFlwno() {
		return flwno;
	}

	public void setFlwno(String flwno) {
		this.flwno = flwno;
	}

	public String getWrtno() {
		return wrtno;
	}

	public void setWrtno(String wrtno) {
		this.wrtno = wrtno;
	}

	public String getMemno() {
		return memno;
	}

	public void setMemno(String memno) {
		this.memno = memno;
	}
}
