package DaEun;
// 일단 휴대폰 인증 시스템을 만들지 못해
// 가정하에 만든 6자리 숫자 만들어지는 것
// 이 부분 ppt - 자바 코드 구현 다음 페이지에 질문 란으로 생성하였음
import java.util.concurrent.ThreadLocalRandom;

public class LTM2MemberService {
	public static int ltm2generateAuthNo1() {
		 return ThreadLocalRandom.current().nextInt(100000, 1000000);
		 
	}
	public static int ltm2generateAuthNo2() {
        java.util.Random generator = new java.util.Random();
        generator.setSeed(System.currentTimeMillis());
        return generator.nextInt(1000000) % 1000000;
    }
    
    public static void main(String[] args) {
        System.out.println(ltm2generateAuthNo1());
        System.out.println(ltm2generateAuthNo2());
    }
}
