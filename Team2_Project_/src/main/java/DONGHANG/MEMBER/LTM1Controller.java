package DONGHANG.MEMBER;
import java.util.regex.Pattern;
public class LTM1Controller {
	public void idFormat(String str) throws AuthenException {
		if (str.length() < 5 || str.length() > 15) {
			throw new AuthenException("5~15자 이내의 아이디만 가능합니다");
		}
		int cnt1 = 0;
		int cnt2 = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
				cnt1++;
			else if (ch >= '0' && ch <= '9')
				cnt2++;
		}
		if (cnt1 == 0 || cnt2 == 0)
			throw new AuthenException("아이디는 영문자와 숫자를 혼용해서 만들어주세요");
	}
	// 비밀번호 확인

	public void pwCheck(String pass, String pw2) throws AuthenException {

		int cnt1 = 0;
		int cnt2 = 0;
		for (int i = 0; i < pass.length(); i++) {
			char ch = pass.charAt(i);
			if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
				cnt1++;
			else if (ch >= '0' && ch <= '9')
				cnt2++;
		}

		if (cnt1 == 0 || cnt2 == 0)
			throw new AuthenException("비밀번호는 영문자와 숫자를 혼용해서 만들어주세요");
		if (!pass.equals(pw2))
			throw new AuthenException("비밀번호가 다릅니다");
	}
	
	// 생일 형식
	public void birthCheck(String birth) throws AuthenException {
		boolean check = Pattern.matches(
				"[1-9][0-9][0-9][0-9]-[1-9][0-9]-[1-9][0-9]",birth);
		
		if(!check)
			throw new AuthenException("※생년월일 입력 형식은 [1990-01-01]입니다");
		
	}
	
	
	// 전화번호 형식
	public void phoneCheck(String phone) throws AuthenException {
		boolean check = Pattern.matches(
				"(010|011|016|017|018?019)-(\\d{3,4})-(\\d{4})", phone);
		if (!check)
			throw new AuthenException("※전화번호 입력 형식은 [XXX-XXXX-XXXX]입니다");
	}
	// 이메일 형식
	public void emailCheck(String email) throws AuthenException{
		boolean check = Pattern.matches(
				"[a-zA-z][a-zA-z][0-9][0-9]+@naver.com", email);	
		if(!check)
			throw new AuthenException("※이메일 입력 형식은 [영어1영어2숫자1숫자2@naver.com]입니다");
	}
	//주소 형식
	public void locCheck(String loc) throws AuthenException{
		boolean check = Pattern.matches(
				"@@시",loc);		
		if(!check)
			throw new AuthenException("※주소 입력 형식은 [@@시]입니다");
	}

}
