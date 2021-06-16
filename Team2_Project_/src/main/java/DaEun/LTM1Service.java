package DaEun;

import java.util.ArrayList;

public class LTM1Service {
	LTM1Dao dao = new LTM1Dao();
	public LTM1Member loginlist(LTM1Member ltm1M){
		System.out.println("\n# 서비스 단 #");
		System.out.println("회원정보");
		System.out.println("아이디 :"+ltm1M.getId());
		System.out.println("비밀번호 :"+ltm1M.getPass());
		return ltm1M;
		
	}
}
