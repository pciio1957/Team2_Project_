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
	private String memtel;
	private String mememail;
	private String memauth;
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Member(String memid, String mempw) {
		super();
		this.memid = memid;
		this.mempw = mempw;
	}

	public Member(String memno, String memid, String mempw, String memtel, String mememail, String memauth) {
		super();
		this.memno = memno;
		this.memid = memid;
		this.mempw = mempw;
		this.memtel = memtel;
		this.mememail = mememail;
		this.memauth = memauth;
	}
	
	public void memInfo() {
		System.out.println("회원번호 : " + memno);
		System.out.println("회원아이디 : " + memid);
		System.out.println("회원비번 : " + mempw);
		System.out.println("회원이메일 : " + mememail + "\n");
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
	
	public String getMemtel() {
		return memtel;
	}

	public void setMemtel(String memtel) {
		this.memtel = memtel;
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
