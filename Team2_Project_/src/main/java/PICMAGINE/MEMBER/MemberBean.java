package PICMAGINE.MEMBER;

public class MemberBean {
	private String id, pass, name, phone, mail;
	
	

	public MemberBean(String id, String pass, String phone, String mail) {
		super();
		this.id = id;
		this.pass = pass;
		this.phone = phone;
		this.mail = mail;
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

	public String getName() {

		return name;

	}

	public void setName(String name) {

		this.name = name;

	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {

		return mail;

	}

	public void setMail(String mail) {

		this.mail = mail;

	}

}
