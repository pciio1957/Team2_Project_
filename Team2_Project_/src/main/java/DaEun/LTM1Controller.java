package DaEun;


public class LTM1Controller {
	private LTM1Dao dao = new LTM1Dao();
	public String login(LTM1Member m, LTM1Member d) {
		d.addAB("로그인결과", dao.login(m));
		System.out.println("모델 결과값:"+dao.login(m));
		
		return "호출할 화면";
	}
	public void login(LTM1Member m, LTM1Model ltm1Model) {
		// TODO Auto-generated method stub
		
	}
	
}
