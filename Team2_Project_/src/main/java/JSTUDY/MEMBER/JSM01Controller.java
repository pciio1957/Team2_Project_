package JSTUDY.MEMBER;

public class JSM01Controller {
	JSM01Service service = new JSM01Service();
	
	// 전체 리스트 조회
	public String userSelect() {
		System.out.println("\n [Controller] 회원리스트 조회");
		service.userSelect();
		return "조회 완료";
	}

	// 로그인 - 연결
	public String userLogin(JSM01User user, JSM01Model m) {
		System.out.println("\n [Controller] 로그인");
		m.addAttribute("로그인", service.userLogin(user));
		return "성공";
	}
	
	// ID 유효성체크 - 회원가입시 입력한 ID가 중복되는지 확인
	public boolean useIdCheck(String id, JSM01Model m) {
		System.out.println("\n [Controller] 회원아이디 유효성체크");
		m.addAttribute("회원ID 유효성체크", service.useIdCheck(id));
		return m.modelValue=="true"?true:false;
	}
	
	// PW 유효성체크 - 입력한 두 비밀번호가 동일한지 확인
	public boolean samePwCheck(String pw, String rePw, JSM01Model m) {
		System.out.println("\n [Controller] 회원비번 일치확인");
		m.addAttribute("회원PW 일치확인", service.samePwCheck(pw, rePw));
		return m.modelValue=="true"?true:false;
	}
	
	// Email 유효성체크 - Email이 형식에 맞는지 확인
	public boolean useEmailCheck(String email, JSM01Model m) {
		System.out.println("\n [Controller] 회원이메일 유효성체크");
		m.addAttribute("회원Email 형식확인", service.useEmailCheck(email));
		return m.modelValue=="true"?true:false;
	}
	
	// 생일 유효성체크 - 생년월일을 형식에 맞게 작성하는지 확인
	public boolean useBirthCheck(String birth, JSM01Model m) {
		System.out.println("\n [Controller] 회원생일 유효성체크");
		m.addAttribute("회원생일 형식확인", service.useBirthCheck(birth));
		return m.modelValue=="true"?true:false;
	}
	
	// 회원가입 - 정보 입력이 완료되었으면 회원등록
	public String userJoin(JSM01User user, JSM01Model m) {
		System.out.println("\n [Controller] 회원가입");
		m.addAttribute("회원가입", service.userJoin(user));
		return "완료";
	}
	
	// 아이디 찾기 - 이메일을 통해서 아이디 찾기
	public String userIdFind(String inMail, JSM01Model m) {
		System.out.println("\n [Controller] 아이디 찾기");
		m.addAttribute("아이디 찾기", service.userIdFind(inMail));
		return "완료";
	}
	
	// 비밀번호 찾기 - 아이디, 이메일을 통해서 아이디 찾기
	public String userPassFind(String inId, String inMail, JSM01Model m) {
		System.out.println("\n [Controller] 비밀번호 찾기");
		m.addAttribute("비밀번호 찾기", service.userPassFind(inId, inMail));
		return "완료";
	}
	
	// 개인정보 수정 전 비밀번호 확인 - 아이디, 비밀번호, 확인 비밀번호 전달 
	public boolean userPwCheck(String inId, String inPw, String inRePw, JSM01Model m) {
		System.out.println("\n [Controller] 개인정보 수정 전 비밀번호 확인 ");
		m.addAttribute("비밀번호 확인", service.userPwCheck(inId, inPw, inRePw));
		return m.modelValue=="true"?true:false;
	}
	
	// 개인정보 수정 - 부분과 내용을 입력받고 수정
	public String userDataUpdate(String part, String content, JSM01User u, JSM01Model m) {
		System.out.println("\n [Controller] 개인정보 수정");
		m.addAttribute("개인정보 수정", service.userDataUpdate(part, content, u));
		return "완료";
	}
	
	// 회원탈퇴 - 아이디, 비밀번호, 확인비밀번호 확인 후 탈퇴사유 작성 후 탈퇴 처리
	public String userDataDrop(JSM01User user, String exit, JSM01Model m) {
		System.out.println("\n [Controller] 회원 탈퇴");
		m.addAttribute("회원탈퇴", service.userDataDrop(user, exit));
		return "";
	}
}
