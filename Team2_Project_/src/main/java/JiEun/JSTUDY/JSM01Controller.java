package JiEun.JSTUDY;

public class JSM01Controller {
	JSM01Service service = new JSM01Service();
	
	// 리스트 조회
	public String UserSelect() {
		System.out.println("\n [Controller] 회원리스트 조회");
		service.UserSelect();
		return "조회 완료";
	}

	
	
	
	
	
	
	
	
	// 로그인
	public String UserLogin(JSM01User user, JSM01Model m) {
		System.out.println("\n [Controller] 로그인");
		m.addAttribute("로그인", service.UserLogin(user));
		return "성공";
	}
	
	// ID 유효성체크 - 회원가입시 입력한 ID가 중복되는지 확인
	public boolean UseIdCheck(String id, JSM01Model m) {
		System.out.println("\n [Controller] 회원아이디 유효성체크");
		m.addAttribute("회원ID 유효성체크", service.UseIdCheck(id));
		return m.modelValue=="true"?true:false;
	}
	
	// PW 유효성체크 - 입력한 두 비밀번호가 동일한지 확인
	public boolean SamePwCheck(String pw, String rePw, JSM01Model m) {
		System.out.println("\n [Controller] 회원비번 일치확인");
		m.addAttribute("회원PW 일치확인", service.SamePwCheck(pw, rePw));
		return m.modelValue=="true"?true:false;
	}
	
	// Email 유효성체크 - Email이 형식에 맞는지 확인
	public boolean UseEmailCheck(String email, JSM01Model m) {
		System.out.println("\n [Controller] 회원이메일 유효성체크");
		m.addAttribute("회원Email 형식확인", service.USeEmailCheck(email));
		return m.modelValue=="true"?true:false;
	}
	
	// 생일 유효성체크 - 생년월일을 형식에 맞게 작성하는지 확인
	public boolean UseBirthCheck(String birth, JSM01Model m) {
		System.out.println("\n [Controller] 회원생일 유효성체크");
		m.addAttribute("회원생일 형식확인", service.UseBirthCheck(birth));
		return m.modelValue=="true"?true:false;
	}
	
	// 회원가입 - 정보 입력이 완료되었으면 회원등록
	public String UserJoin(JSM01User user, JSM01Model m) {
		System.out.println("\n [Controller] 회원가입");
		m.addAttribute("회원가입", service.UserJoin(user));
		return "";
	}
	
	public String UserIdFind(String inMail, JSM01Model m) {
		System.out.println("\n [Controller] 아이디 찾기");
		m.addAttribute("아이디 찾기", service.UserIdFind(inMail));
		return "";
	}
	
	public String UserPassFind(String inId, String inMail, JSM01Model m) {
		System.out.println("\n [Controller] 비밀번호 찾기");
		m.addAttribute("비밀번호 찾기", service.UserPassFind(inId, inMail));
		return "";
	}
	
	public String userDataUpdate() {
		System.out.println("\n [Controller] 개인정보 수정");
		return "";
	}
	
	public String userDataDrop() {
		System.out.println("\n [Controller] 회원 탈퇴");
		return "";
	}
}
