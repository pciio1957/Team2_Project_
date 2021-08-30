package JSTUDY.MEMBER;

import java.util.Scanner;

public class JSM01Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JSM01Controller controller = new JSM01Controller();
		String menuSelect = "";
		

		while(true) {
			
			System.out.println("\n *** JSTUDY 사용자 기능입니다 ***");
			System.out.println(" 사용하실 기능을 숫자로 입력하세요 ");
			System.out.println(" [1] 로그인 [2] 회원가입 [3] 아이디/비밀번호 찾기 [4] 개인정보 수정 [5] 회원탈퇴 [6] 회원목록확인(테스트)");
			menuSelect = inputStr(" ▶ 입력: ");
			
			// 로그인이 세션정보로 알고 있는데,, 어떻게 연결시킬지 고민 
			// 1: 로그인 - select로 검색(있는지/없는지)
			// 2: 회원가입 - insert로 등록(id유효성체크/비밀번호체크/이메일양식)
			// 3: 아이디/비번찾기 - select로 검색(이메일로 찾기)
			// 4: 개인정보 수정 - select로 검색 후 update
			// 5: 회원탈퇴 - select로 검색 후 update
			if(menuSelect.equals("1")) {
				
				// 로그인
				// 아이디, 비밀번호 입력 받은 후 
				System.out.println("\n ▶ 로그인 ");
				
				String inID = inputStr(" ▶ ID 입력 : ");
				String inPW = inputStr(" ▶ PW 입력 : ");
				
				JSM01User loginInfo = new JSM01User(inID, inPW);
				controller.userLogin(loginInfo, new JSM01Model());

				
			} else if(menuSelect.equals("2")) {
				
				// 회원가입
				// 아이디, 비밀번호, 비밀번호 확인, 이메일, 생년월일 입력
				// 입력값의 유효성 체크 후 회원 추가 
				System.out.println("\n ▶ [2] 회원가입 ");
				
				String inID = inputStr(" ▶ ID 입력 : ");
				boolean idCk = controller.useIdCheck(inID, new JSM01Model());
				
				// return으로 false로 왔을때 다음 입력 진행
				if(idCk) {
					String inPW = inputStr(" ▶ PW 입력 : "); 
					String inRePW = inputStr(" ▶ 입력한 PW 확인 : "); 
					boolean pwCk = controller.samePwCheck(inPW, inRePW, new JSM01Model()); 
				
					if(pwCk) {
						String inEmail = inputStr(" ▶ E-mail 입력 : "); 
						boolean emailCk = controller.useEmailCheck(inEmail, new JSM01Model());
				
						if(emailCk) {
							String inBirth = inputStr(" ▶ Birth 입력 : "); 
							boolean birthCk = controller.useBirthCheck(inBirth, new JSM01Model());
							
							if(birthCk) {
								JSM01User joinUser = new JSM01User(inID, inPW, inEmail, inBirth);
								controller.userJoin(joinUser, new JSM01Model());
							}
						}
					}
				}
				
				
				
			} else if(menuSelect.equals("3")) {
				
				// 아이디/비번찾기 
				// 아이디를 찾을지 비밀번호를 찾을지 선택 후 각각 다르게 찾아야함
				System.out.println("\n ▶ [3] 아이디/비밀번호 찾기 ");
				String inPart = inputStr(" ▶ 입력(아이디/비밀번호) : ");
				
				if(inPart.equals("아이디")) {
					System.out.println("\n 아이디 찾기 ");	
					String inEmail = inputStr(" ▶ 이메일 입력 : ");
					
					 controller.userIdFind(inEmail, new JSM01Model());
					
				} else if(inPart.equals("비밀번호")) {
					System.out.println("\n 비밀번호 찾기 ");	
					String inId = inputStr(" ▶ 아이디 입력 : ");
					String inEmail = inputStr(" ▶ 이메일 입력 : ");
					
					controller.userPassFind(inId, inEmail, new JSM01Model());
				}
			
				
			} else if(menuSelect.equals("4")) {

				// 개인정보 수정
				// 현재 비밀번호 확인을 통해 정보를 출력하고 수정할 데이터 입력받은 후 수정
				System.out.println("\n ▶ [4] 개인정보 수정 ");
				String inId = inputStr(" ▶ 아이디 입력 : ");
				String inPw = inputStr(" ▶ 비밀번호 입력 : ");
				String inRePw = inputStr(" ▶ 비밀번호 확인 : ");
				
				// 아이디와 비밀번호 확인 후 정보 출력
				boolean pwCk = controller.userPwCheck(inId, inPw, inRePw, new JSM01Model());
				
				if(pwCk) {
					System.out.println("\n ▶ 수정할 정보 입력(비밀번호/이메일/생일) ");
					String inPart = inputStr(" ▶ 입력 : ");
					String inContent = inputStr(" ▶ 수정내용 : ");

					JSM01User modifyUser = new JSM01User(inId, inPw);
					controller.userDataUpdate(inPart, inContent, modifyUser, new JSM01Model());
				}
				
				
				
			} else if(menuSelect.equals("5")) {
				
				// 회원탈퇴
				// 아이디, 비밀번호 확인 후 탈퇴사유 작성 후 탈퇴처리 
				System.out.println("\n ▶ [5] 회원탈퇴 ");
				String inId = inputStr(" ▶ 아이디 입력 : ");
				String inPw = inputStr(" ▶ 비밀번호 입력 : ");
				String inRePw = inputStr(" ▶ 비밀번호 확인 : ");
				
				// 아이디와 비밀번호 확인 후 정보 출력
				boolean pwCk = controller.userPwCheck(inId, inPw, inRePw, new JSM01Model());
				
				if(pwCk) {
					JSM01User exitUser = new JSM01User(inId, inPw);
					String inExit = inputStr(" ▶ 탈퇴사유 입력 : ");
					
					controller.userDataDrop(exitUser, inExit, new JSM01Model());
				}
				
			} else if(menuSelect.equals("6")) {
				
				System.out.println("6번 호출");
				// 회원목록확인
				controller.userSelect();
			}
		}	
	}
	
	public static String inputStr(String msg) {
		
		System.out.print(msg);
		return sc.nextLine();
	}

}
