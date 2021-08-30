package JSTUDY.MEMBER;

import java.util.ArrayList;

public class JSM01DAO {
	private ArrayList<JSM01User> userList = new ArrayList<JSM01User>();
	
	public JSM01DAO() {
		super();
		
		userList.add(new JSM01User("himan01", "qw7777", "himan@naver.com", "1999.09.09"));
		userList.add(new JSM01User("goodgirl", "as1234", "good1@naver.com", "2000.04.20"));
		userList.add(new JSM01User("hismile", "as1234", "smile@naver.com", "2021.06.28"));
			
	}

	// 회원리스트 보내기 
	public ArrayList<JSM01User> userSelect() {
		System.out.println(" [DAO] 회원리스트 호출\n");
		return userList;
	}
	
	// 회원가입 등록
	public void userJoin(JSM01User user) {
		System.out.println(" [DAO] 회원가입 호출\n");
		userList.add(user);
		
		System.out.println("\n# 등록 회원정보 출력 #");
		System.out.println(" ID : " + user.userID);
		System.out.println(" PW : " + user.userPW);
		System.out.println(" Email : " + user.userEmail);
		System.out.println(" Birth : " +user.userBirth);
	}
	
	public String userExit(int userIdx) {
		System.out.println(" [DAO] 회원탈퇴 호출\n");
		userList.remove(userIdx);
		return "완료";
	}
	

}
