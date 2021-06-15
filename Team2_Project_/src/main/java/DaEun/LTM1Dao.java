package DaEun;

public class LTM1Dao {
	public String login(LTM1Member lm) {
		System.out.println("# DB 처리(로그인) #");
		System.out.println(lm.getId());
		System.out.println(lm.getPass());
		return lm.getId().equals("himan")&&
				lm.getPass().equals("7777")?
				"성공":"실패";
		
	}
}
