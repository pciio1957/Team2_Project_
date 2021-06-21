package DaEun.LTM;

import java.util.Scanner;

public class LTM1Service {
	Scanner sc = new Scanner(System.in);
	LTM1Dao dao = new LTM1Dao();

	LTM1Controller ltc = new LTM1Controller();

	public void insert() throws AuthenException {

		String pw2 = null;
		boolean id = true;
		boolean pw = true;
		boolean brith = true;
		boolean tel = true;
		boolean email = true;
		boolean loc = true;
		System.out.println("                 회원가입");
		System.out.println("-------------------------------------");
		try {
			LTM1Dto dto = new LTM1Dto();
			LTM1Controller ne = new LTM1Controller();
			do {
				try {
					System.out.print("아이디:");
					dto.setId(sc.next());
					;
					ne.idFormat(dto.getId());
					id = false;
				} catch (AuthenException e) {
					System.out.println(e.toString());
				}
			} while (id);
			do {
				try {
					System.out.print("비밀번호:");
					dto.setPass(sc.next());
					System.out.print("비밀번호 확인:");
					pw2 = sc.next();
					ne.pwCheck(dto.getPass(), pw2);
					pw = false;
				} catch (AuthenException e) {
					System.out.println(e.toString());
				}
			} while (pw);
			System.out.print("생일[xxxx-xx-xx]:");
			dto.setBrith(sc.next());
			do {
				try {
					System.out.print("전화번호[xxx-xxxx-xxxx]:");
					dto.setTel(sc.next());
					ne.phoneCheck(dto.getTel());
					tel = false;
				} catch (AuthenException e) {
					System.out.println(e.toString());
				}
			} while (tel);
			System.out.print("이메일[xxxxx@naver.net]:");
			dto.setEmail(sc.next());
			System.out.print("주소[@@시]:");
			dto.setLoc(sc.next());
			int result = dao.insertData(dto);
			if (result != 0) {
				System.out.println();
				System.out.println("****성공적으로 가입이 되었습니다!****");
				System.out.println();
				System.out.println("-----------[회원가입 확인]-----------");
				System.out.println(dto.toString());
			} else
				System.out.println("회원가입에 실패했습니다");

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public void update() {

		try {

			LTM1Dto dto = new LTM1Dto();

			System.out.print("수정 할 아이디:");
			dto.setId(sc.next());
			System.out.print("비밀번호:");
			dto.setPass(sc.next());	
			System.out.println("생일:");
			dto.setBrith(sc.next());
			System.out.print("전화번호[xxx-xxxx-xxxx]:");
			dto.setTel(sc.next());
			System.out.print("이메일[xxxxx@daum.net]:");
			dto.setEmail(sc.next());
			
			System.out.println("주소:");
			dto.setLoc(sc.next());
			int result = dao.updateData(dto);
			if (result != 0) 
				System.out.println("회원정보가 수정되었습니다");

			else 
				System.out.println("회원정보수정에 실패했습니다");

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}