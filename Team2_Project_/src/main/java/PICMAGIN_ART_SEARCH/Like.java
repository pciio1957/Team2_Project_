package PICMAGIN_ART_SEARCH;

public class Like {


	int likenum; ////좋아요고유번호
	String likecase; //좋아요종류
	int Mnum; //아이디
	String artwork; //작품번호 
	

	
	public Like() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Like(String likecase, String artwork) {
		super();
		this.likecase = likecase;
		this.artwork = artwork;
	}



	public Like(String artwork) {
		super();
		this.artwork = artwork;
	}



	public Like(String likecase, int mnum, String artwork) {
		super();
		this.likecase = likecase;
		this.Mnum = mnum;
		this.artwork = artwork;
	}



	public Like(int likenum, String likecase, int mnum, String artwork) {
		super();
		this.likenum = likenum;
		this.likecase = likecase;
		Mnum = mnum;
		this.artwork = artwork;
	}



	public int getLikenum() {
		return likenum;
	}



	public void setLikenum(int likenum) {
		this.likenum = likenum;
	}



	public String getLikecase() {
		return likecase;
	}



	public void setLikecase(String likecase) {
		this.likecase = likecase;
	}



	public int getMnum() {
		return Mnum;
	}



	public void setMnum(int mnum) {
		Mnum = mnum;
	}



	public String getArtwork() {
		return artwork;
	}



	public void setArtwork(String artwork) {
		this.artwork = artwork;
	}



	public void Tostring (int idx) {
		System.out.println("[" +idx+ "]" +"\t"+"작품번호"+"\t"+"좋아요수");
		System.out.print("좋아요종류:" + likecase);
		System.out.println("좋아요수:" + artwork);
	}
}
