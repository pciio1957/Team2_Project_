package DaEun.LTM;

public class LTM1Dao {
	public String login(LTM1Dto lm) {
		System.out.println("# DB 처리(로그인) #");
		System.out.println(lm.getId());
		System.out.println(lm.getPass());
		return lm.getId().equals("ssangyuong11")&&
				lm.getPass().equals("1234")?
				"성공":"실패";
		
	}
}
