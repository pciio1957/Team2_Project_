package JSTUDY.MEMBER;

public class JSM01User {
	public String userID; // 아이디
	public String userPW; // 비밀번호
	public String userEmail; // 이메일
	public String userBirth; // 생일
	
	public JSM01User() {
		super();
	}
	
	public JSM01User(String userEmail) {
		super();
		this.userEmail = userEmail;
	} 

	public JSM01User(String userID, String userPW) {
		super();
		this.userID = userID;
		this.userPW = userPW;
	}

	public JSM01User(String userID, String userPW, String userEmail, String userBirth) {
		super();
		this.userID = userID;
		this.userPW = userPW;
		this.userEmail = userEmail;
		this.userBirth = userBirth;
	}
	
	public void showInfo() {
		System.out.println(" ID : " + userID);
		System.out.println(" PASS : " + userPW);
		System.out.println(" EMAIL : " + userEmail);
		System.out.println(" BIRTH : " + userBirth + "\n");
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserPW() {
		return userPW;
	}

	public void setUserPass(String userPW) {
		this.userPW = userPW;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserBirth() {
		return userBirth;
	}

	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}


	
	
	
	

}
