package JSTUDY.MEMBER;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JSM01Service {
	JSM01DAO dao = new JSM01DAO();
	
	ArrayList<JSM01User> userList;

	
	// 전체 리스트 조회 (회원 확인용, 리스트 호출용)
	public String userSelect() {
		System.out.println(" [Service] 회원리스트 호출");
		
		userList = dao.userSelect(); // 리스트를 받아옴
		
		
		for(JSM01User u:userList) {
			u.showInfo();
		}
		return "조회완료";
	}

	// 로그인 - 일치하는 회원정보가 있으면 로그인 성공, 없으면 로그인실패
	public String userLogin(JSM01User user) {
		System.out.println(" [Service] 로그인 ");
		boolean userCheck = false;

		userList = dao.userSelect(); // 리스트를 받아옴
		
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
	
	public boolean useIdCheck(String inID) {
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
				userList = dao.userSelect();
				
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
	
	public boolean samePwCheck(String pw, String rePw) {
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
	
	// 위의 메소드 오버로딩 : 비밀번호 형식 확인용
	public boolean samePwCheck(String pw) {
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
				returnCheck = true;
				
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
	
	public boolean useEmailCheck(String inEmail) {
		System.out.println(" [Service] 이메일 형식 체크 ");
		
		// 이메일 형식에 맞는지 확인 (ㅁㅁ@ㅁㅁ.ㅁㅁ)
		boolean email_check = Pattern.matches("\\w+@\\w+\\.\\w+(\\.\\w+)?", inEmail);
		
		// 이메일 중복확인 추가하기
		
		if(email_check) {
			System.out.println(" - 입력 이메일이 형식에 맞습니다 - ");
		} else {
			System.out.println(" - 형식에 맞지않습니다. 이메일을 다시 입력해주세요 - ");
		}
		
		return email_check;
	}
	
	public boolean useBirthCheck(String inBirth) {
		System.out.println(" [Service] 생일 형식 체크 ");
		
		// 생일 형식에 맞는지 확인 (1~2999.00~19.00~39)  
		boolean birth_check = Pattern.matches("^(1|2)\\d{3}.(0|1)[0-9].[0-3][0-9]?", inBirth);
				
		return birth_check;
	}
	
	// 회원가입
	public String userJoin(JSM01User user) {
		System.out.println(" [Service] 회원가입 ");
		dao.userJoin(user);
		
		return "성공";
	}
	
	// 아이디 찾기 - 중복되지 않는 이메일로 진행
	public String userIdFind(String inMail) {
		System.out.println(" [Service] 아이디 찾기 ");
		boolean userCheck = false;
		String storeId = "";

		userList = dao.userSelect(); // 리스트를 받아옴
		
		for(JSM01User u:userList) {
			if(u.userEmail.equals(inMail)) {
				userCheck = true;
				storeId = u.getUserID();				
			}
		}
		
		System.out.println("\n# 로그인 찾기 결과 #");
		if(userCheck != false) {
			System.out.println(" - 일치하는 이메일이 있습니다 - ");
			System.out.println(" 회원님의 ID는 [ " + storeId + " ] 입니다");
		} else {
			System.out.println(" - 해당하는 정보가 없습니다 - ");
		}
		
		return "";
	}
	
	// 비밀번호 찾기 - 중복되지 않는 아이디와 이메일로 진행
	public String userPassFind(String inId, String inMail) {
		System.out.println(" [Service] 비밀번호 찾기");
		boolean userCheck = false;
		String storePw = "";

		userList = dao.userSelect(); // 리스트를 받아옴
		
		for(JSM01User u:userList) {
			if(u.userEmail.equals(inMail) && u.userID.equals(inId)) {
				userCheck = true;
				storePw = u.getUserPW();				
			}
		}
		
		System.out.println("\n# 비밀번호 찾기 결과 #");
		if(userCheck != false) {
			System.out.println(" - 일치하는 이메일과 아이디가 있습니다 - ");
			System.out.println(" 회원님의 비밀번호는 [ " + storePw + " ] 입니다");
		} else {
			System.out.println(" - 해당하는 정보가 없습니다 - ");
		}
		
		return "";
	}
	
	// 개인정보 수정전 비밀번호 확인 - 
	public boolean userPwCheck(String inID, String inPw, String inRePw) {
		System.out.println(" [Service] 개인정보 수정 전 비밀번호 확인 ");
		boolean userCheck = false;
		
		// 입력한 두 비밀번호가 일치하는지 확인 후 ID, PW로 정보 확인
		if(inPw.equals(inRePw)) {
			
			userList = dao.userSelect();
			
			for(JSM01User u:userList) {
				if(u.userID.equals(inID) && u.userPW.equals(inPw)) {
					userCheck = true;
					System.out.println("\n # 회원정보 #");
					u.showInfo();
				}
			}
			
		} else if (userCheck == false) {
			System.out.println(" - 일치하는 회원정보가 없습니다 - ");
		} else {
			System.out.println(" - 동일한 비밀번호를 입력해주세요 - ");
		}
		
		return userCheck;
	}
	
	// 개인정보 수정 - 
	public String userDataUpdate(String inPart, String inContent, JSM01User user) {
		System.out.println(" [Service] 개인정보 수정 ");
		
		userList = dao.userSelect();
		
		// 부분 입력받고 내용 바꾸기 
		switch(inPart) {
			case "비밀번호" : 
				
				boolean ckPw = samePwCheck(inContent);
				
				if(ckPw) {
					for(JSM01User u:userList) {
						if(u.getUserID().equals(user.userID) && u.getUserPW().equals(user.userPW)) {
							u.setUserPass(inContent);
							System.out.println(" - 비밀번호가 변경되었습니다 - ");
						}
					}
						
				} else {
					System.out.println(" - 비밀번호 변경에 실패했습니다 - ");
				}
				
				break;
				
			case "이메일" :
				
				boolean ckEmail = useEmailCheck(inContent);
				
				if(ckEmail) {
					for(JSM01User u:userList) {
						if(u.getUserID().equals(user.userID) && u.getUserPW().equals(user.userPW)) {
							u.setUserEmail(inContent);
							System.out.println(" - 이메일이 변경되었습니다 - ");
						}
					}	
					
				} else {
					System.out.println(" - 이메일 변경에 실패했습니다 - ");
				}
				
				break;
				
			case "생일" :
				
				boolean ckBirth = useBirthCheck(inContent);
				
				if(ckBirth) {
					for(JSM01User u:userList) {
						if(u.getUserID().equals(user.userID) && u.getUserPW().equals(user.userPW)) {
							u.setUserPass(inContent);
							System.out.println(" - 비밀번호가 변경되었습니다 - ");
						}
						
					}

				} else {
					System.out.println(" - 생일 변경에 실패했습니다 - ");
				}
				
				break;
				
			default : System.out.println(" - 비밀번호/이메일/생일 중 입력해주세요 - "); 
		}
	
		return "완료";
	}
	
	// 회원탈퇴 
	public String userDataDrop(JSM01User user, String inExit) {
		System.out.println(" [Service] 회원 탈퇴");
		int userIdx = 0;
		
		userList = dao.userSelect();
		
		for(JSM01User u:userList) {
			if(u.getUserID().equals(user.userID) && u.getUserPW().equals(user.userPW)) {
				userIdx = userList.indexOf(u);
			}
		}
		dao.userExit(userIdx);
		System.out.println(" - 탈퇴가 완료되었습니다 - ");
		
		return "완료";
	}
	
}
