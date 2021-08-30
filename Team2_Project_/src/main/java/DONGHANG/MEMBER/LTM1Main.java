package DONGHANG.MEMBER;

import java.util.Scanner;
import DaEun.DongHaeng.AuthenException;

public class LTM1Main {
	public static void main(String[] args) throws AuthenException, DONGHANG.MEMBER.AuthenException {
		Scanner sc = new Scanner(System.in);
		LTM1Service ob = new LTM1Service();
		int ch;
		while (true) {
			do {
				System.out.print("1.입력  2.회원정보수정  3.탈퇴  4.종료");
				System.out.print("\n-------------------------------------\n▶");
				ch = sc.nextInt();
			} while (ch < 1 || ch > 4);
			System.out.println();
			switch (ch) {
			case 1:
				ob.insert();
				System.out.println();
				break;
		
			case 2:
				ob.update();
				System.out.println();
				break;

			case 3:
				ob.delete();
				System.out.println();
				break; 

			case 4:
				DBConn.close();
				System.exit(0);

			}

		}

	}	
}
