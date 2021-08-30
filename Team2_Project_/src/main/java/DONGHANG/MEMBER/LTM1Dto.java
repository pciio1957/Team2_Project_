package DONGHANG.MEMBER;

public class LTM1Dto {
	private String id;
	private String pass;
	private String birth;
	private String tel;
	private String email;
	private String loc;
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
	public String getBrith() {
		return birth;
	}
	public void setBrith(String birth) {
		this.birth = birth;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str = String.format("아이디:%s \n비밀번호:%s \n생일:%s \n번호:%s \n이메일:%s \n주소:%s \n",
							id, pass, birth, tel, email, loc);
		return super.toString();
	}
	
	
}
