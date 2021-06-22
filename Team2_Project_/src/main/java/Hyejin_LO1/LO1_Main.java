package Hyejin_LO1;

import java.util.Scanner;

public class LO1_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		
//화면에서 처리하는 부분을 main()을 통해서 test한다.
//Scanner를 통해서 입력받아도된다. 
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("첫째칸");
		String num01= sc.nextLine();
		
		System.out.println("둘째칸");
		String num02= sc.nextLine();
		
		System.out.println("셋째칸");
		String num03= sc.nextLine();
		
		System.out.println("넷째칸");
		String num04= sc.nextLine();
		
		System.out.println("다섯째칸");
		String num05= sc.nextLine();
		
		System.out.println("여섯째칸");
		String num06= sc.nextLine();
		
		//입력값으로 처리된 객체 생성 
		LO1_Controller ctrl1 = new LO1_Controller(); {
		SearchNumber s = new SearchNumber(num01,num02,num03,num04,num05,num06); {
		System.out.println("입력된값:"+"["+ num01+ "]" +"["+ num02+ "]" + "["+ num03+ "]" + 
		"["+ num04+ "]" + "["+ num05+ "]" + "["+ num06+ "]"+"\n");
		
		

System.out.println("#호출된화면#");
System.out.println(ctrl1.lotoSearch(s, new LO1_Model()));
		
}
}
}
}
