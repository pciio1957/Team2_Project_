package JiEun.Picmagine.vo;

/*

Table : Member
회원번호
ID
PW
이메일
사용권한 

*/

public class Member {
	private String memno;
	private String memid;
	private String mempw;
	private String mememail;
	private String memauth;
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member(String memno, String memid, String mempw, String mememail, String memauth) {
		super();
		this.memno = memno;
		this.memid = memid;
		this.mempw = mempw;
		this.mememail = mememail;
		this.memauth = memauth;
	}

	public String getMemno() {
		return memno;
	}

	public void setMemno(String memno) {
		this.memno = memno;
	}

	public String getMemid() {
		return memid;
	}

	public void setMemid(String memid) {
		this.memid = memid;
	}

	public String getMempw() {
		return mempw;
	}

	public void setMempw(String mempw) {
		this.mempw = mempw;
	}

	public String getMememail() {
		return mememail;
	}

	public void setMememail(String mememail) {
		this.mememail = mememail;
	}

	public String getMemauth() {
		return memauth;
	}

	public void setMemauth(String memauth) {
		this.memauth = memauth;
	}
}
