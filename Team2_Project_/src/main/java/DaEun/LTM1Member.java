package DaEun;

public class LTM1Member {
	private String id;
	private String pass;
	private String loc;
	private String email;
	public LTM1Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LTM1Member(String id, String pass) {
		super();
		this.id = id;
		this.pass = pass;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LTM1Member(String id, String pass, String loc, String email) {
		super();
		this.id = id;
		this.pass = pass;
		this.loc = loc;
		this.email = email;
	}
	public void addAB(String string, String login) {
		// TODO Auto-generated method stub
		
	}
	
}
