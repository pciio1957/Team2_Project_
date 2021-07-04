package DaEun.FAQ;

import java.util.Scanner;



public class FAQ {
// 메인기능
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		FAQ_DTO dto = new FAQ_DTO("구매내역 확인하기(메인에서 입력한 내용)",
							" 구매내역은 마이페이지로 이동하여 확인");		
		Controller con = new Controller();
		System.out.println("-------------------------------------");
		System.out.println("	  ** FAQ 작성하기 **");
		System.out.println(con.flist1(dto,new Model()));
	}

}
