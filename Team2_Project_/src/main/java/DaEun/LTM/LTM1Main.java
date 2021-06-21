package DaEun.LTM;

import java.util.Scanner;

public class LTM1Main {
	public static void main(String[] args) throws AuthenException {

		Scanner sc = new Scanner(System.in);

		LTM1Service ob = new LTM1Service();

		int ch;
		while (true) {

			do {
				System.out.print("1.입력  2.회원정보수정  3.탈퇴  4.회원전체출력  5.종료");
				System.out.print("\n-------------------------------------\n▶");
				ch = sc.nextInt();
			} while (ch < 1 || ch > 6);

			System.out.println();
			switch (ch) {
			case 1:

				ob.insert();

				System.out.println();
				break;

		/*	case 2:

				ob.update();

				System.out.println();
				break;

			case 3:

				ob.delete();

				System.out.println();
				break;

			case 4:

				ob.selectAll();

				System.out.println();
				break; */


			case 5:

				System.exit(0);

			}

		}

	}	
}
