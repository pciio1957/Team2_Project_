package DaEun;
// 인증 서비스
public class LTM2Controller {
	
	    private LTM2MemberService memberService;
	    private MailSendService mss;


	    @RequestMapping("/member/signUp")
	     public void signUp(@ModelAttribute MemberDTO memberDTO){
	        // DB에 기본정보 insert
	        memberService.signUp(memberDTO);

	        //임의의 authKey 생성 & 이메일 발송
	        String authKey = mss.sendAuthMail(memberDTO.getEmail());
	        memberDTO.setAuthKey(authKey);

	        Map<String, String> map = new HashMap<String, String>();
	        map.put("email", memberDTO.getEmail());
	        map.put("authKey", memberDTO.getAuthKey());
	        System.out.println(map);

	      //DB에 authKey 업데이트
	      memberService.updateAuthKey(map);

	  	}
}
