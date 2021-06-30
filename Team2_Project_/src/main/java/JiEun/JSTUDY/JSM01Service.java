package JiEun.JSTUDY;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JSM01Service {
	JSM01DAO dao = new JSM01DAO();
	
	ArrayList<JSM01User> userList;

	
	// 리스트 조회?
	public String UserSelect() {
		System.out.println(" [Service] 회원리스트 호출");
		
		userList = dao.UserSelect(); // 리스트를 받아옴
		
		
		for(JSM01User u:userList) {
			u.showInfo();
		}
		return "조회완료";
	}

	// 로그인 - 일치하는 회원정보가 있으면 로그인 성공, 없으면 로그인실패
	public String UserLogin(JSM01User user) {
		System.out.println(" [Service] 로그인 ");
		boolean userCheck = false;

		userList = dao.UserSelect(); // 리스트를 받아옴
		
		for(JSM01User u:userList) {
			if(u.userID.equals(user.getUserID()) && 
					u.userPW.equals(user.getUserPW())) {
				userCheck = true;
			}
		}
		
		if(userCheck != false) {
			System.out.println("\n - 로그인되었습니다 - ");
		} else {
			System.out.println("\n - 해당하는 정보가 없습니다 - ");
		}
		
		return userCheck?"성공":"실패";
	}
	
	public boolean UseIdCheck(String inID) {
		System.out.println(" [Service] 회원ID 유효성체크 ");
		boolean returnCheck = false;
		
		boolean id_check = Pattern.matches("^\\w*?", inID);
		boolean id_size = inID.length()>=6 && inID.length()<11?true:false;
		System.out.println(" 아이디 형식 체크 : " + id_check);
		System.out.println(" 아이디 길이 체크 : " + id_size);
		
		
		System.out.println("\n# [회원가입] ID 유효성검사 결과 #");
		if(id_size) { // 아이디의 길이 체크 : 6자~10자 사이
			if(id_check) { // 아이디의 형식 체크 : 영문자+숫자
				
				// 길이 + 형식체크 통과 후 값변환
				returnCheck = true;
				
				// 입력한 아이디의 길이와 형식이 맞으면 회원리스트를 불러옴
				userList = dao.UserSelect();
				
				for(JSM01User u:userList) {
					if(u.userID.equals(inID)) {
						// 아이디가 존재하는지 확인 : 있으면 false
						returnCheck = false;  
					}
				}
				
				if(returnCheck) {
					System.out.println(" - 회원가입이 가능합니다 - ");
				} else {
					System.out.println(" - 동일한 ID가 이미 존재합니다 - ");
				}
				
			} else {
				System.out.println(" - 입력한 아이디의 형식이 맞지않습니다 - ");
				System.out.println(" - 입력형식: 영문자+숫자만 가능 - ");
			}
		} else {
			System.out.println(" - 입력한 아이디의 길이가 맞지않습니다 - ");
			System.out.println(" - 길이제한: 6~10자 사이 - ");
		}
		
		return returnCheck;
	}
	
	public boolean SamePwCheck(String pw, String rePw) {
		System.out.println(" [Service] 회원PW 유효성체크 ");
		boolean returnCheck = false;
		
		// 비밀번호 형식은 영문자+숫자만 가능
		boolean pw_check = Pattern.matches("^\\w*?", pw);
		System.out.println(" 비밀번호 형식 체크 : " + pw_check);
		
		boolean pw_size = (pw.length()>=6 && pw.length()<11)?true:false;
		System.out.println(" 비밀번호 길이 체크 : " + pw_size);
		
		
		System.out.println("\n# [회원가입] PW 유효성체크 결과 #");
		// 먼저 비밀번호의 길이 체크 : 기준 6~10자
		if(pw_size) {
			
			// 다음 비밀번호의 형식 체크 : 영문자+숫자 
			if(pw_check) {
				
				// 비밀번호와 확인비밀번호가 동일한지 체크 
				if(pw.equals(rePw)) {
					System.out.println(" - 입력한 비밀번호가 동일합니다 - ");
					returnCheck = true;
				} else {
					System.out.println(" - 입력한 비밀번호가 틀립니다 - ");
				}
				
			} else {
				System.out.println(" - 입력한 비밀번호가 형식에 맞지않습니다 - ");
				System.out.println(" - 형식: 영문자+숫자만 가능 - ");
			}
		} else {
			System.out.println(" - 입력한 비밀번호의 길이가 맞지않습니다 - ");
			System.out.println(" - 길이제한: 6~10자 사이 - ");
		}
		
		return returnCheck;
	}
	
	public boolean USeEmailCheck(String inEmail) {
		System.out.println(" [Service] 이메일 형식 체크 ");
		
		// 이메일 형식에 맞는지 확인 (ㅁㅁ@ㅁㅁ.ㅁㅁ)
		boolean email_check = Pattern.matches("\\w+@\\w+\\.\\w+(\\.\\w+)?", inEmail);
		System.out.println(" 이메일 형식 체크 : " + email_check);
		
		// 이메일 중복확인 추가하기
		
		if(email_check) {
			System.out.println(" - 입력 이메일이 형식에 맞습니다 - ");
		} else {
			System.out.println(" - 형식에 맞지않습니다. 이메일을 다시 입력해주세요 - ");
		}
		
		return email_check;
	}
	
	public boolean UseBirthCheck(String inBirth) {
		System.out.println(" [Service] 생일 형식 체크 ");
		
		// 생일 형식에 맞는지 확인 (1~2999.00~19.00~39)  
		boolean birth_check = Pattern.matches("^(1|2)\\d{3}.(0|1)[0-9].[0-3][0-9]?", inBirth);
		System.out.println("이메일 : " + birth_check);
				
		return birth_check;
	}
	
	// 회원가입
	public String UserJoin(JSM01User user) {
		System.out.println(" [Service] 회원가입 ");
		dao.UserJoin(user);
		
		return "성공";
	}
	
	// 아이디 찾기 - 중복되지 않는 이메일로 진행
	public String UserIdFind(String inMail) {
		System.out.println(" [Service] 아이디 찾기 ");
		return "";
	}
	
	// 비밀번호 찾기 - 중복되지 않는 아이디와 이메일로 진행
	public String UserPassFind(String inId, String inMail) {
		System.out.println(" [Service] 비밀번호 찾기");
		return "";
	}
	
	// 개인정보 수정 - 
	public String userDataUpdate() {
		System.out.println(" [Service] 개인정보 수정 ");
		return "";
	}
	
	// 회원탈퇴 - 
	public String userDataDrop() {
		System.out.println(" [Service] 회원 탈퇴");
		return "";
	}
	
}
