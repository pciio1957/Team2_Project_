package wish;

import java.util.ArrayList;
import java.util.Scanner;

import PG5.Wishlist2;


public class Main {

	public static void main(String[] args) {
		

		Controller controller = new Controller(); //컨트롤 객체로 묶어서 넘겨주기 위함 
		
		//사용자에게서 입력받기 위한 [입력함수 선언]
		Scanner scan = new Scanner(System.in);
		
		//장바구니 목록 호출기능 
		//controller.cartlist(new Cart(), new Model ());
		//controller.pointlist(new Cart(), new Model ());
		
		
		//선택 
		while (true) {
			System.out.println("##JSTUDY 장바구니페이지##");
			System.out.println("[1] 포인트조회 및 사용 [2]장바구니리스트 삭제 [3]위시리스토조회 [4] 결제하기");
			String choice = scan.nextLine();
			
			
			
		
		//1. 포인트조회 및 사용 금액입력 
			if(choice.equals("1")) {
			
				System.out.println("현재까지의 포인트 적립금액입니다.");
				controller.pointlist(new Cart(), new Model()); //총적립금액을 보여주기위한 메소드
				
				System.out.println("포인트를사용하시겠습니까? ");
				choice = scan.nextLine();
				boolean Y = true;
				if(choice.equals("Y")) {
				System.out.println("사용할금액을 입력하세요");
				choice = scan.nextLine();
				}
			
			
				/* = scan.nextInt();
				
				} if (pointuse != 0) {
				System.out.println(pointuse+"원을 입력하셨습니다.");
				System.out.println("차감금액:"+ );*/
			}
		
		//2. 장바구니 리스트 삭제 
		 else if (choice.equals("2")) {
			 
			 controller.cartlist(new Cart(), new Model ()); //장바구니 목록 호출 
		 
			System.out.println("삭제할 장바구니 리스트 코드를 입력하세요");
			String code = scan.nextLine(); //O1AA 
		}
			
			
		//3. 위시리스트 조회 및 추가 
		 else if (choice.equals("3")) {
			 System.out.println("위시리스트를 조회");
			 
			 controller.wishlistcome(new Lecture(), new Model());
			 
		
				 System.out.println("추가할 제품코드를 입력하세요");
				 String code = scan.nextLine();
			 } 
					
			 
	
			 else if (choice.equals("4")) {
				 System.out.println("결제페이지로 이동합니다.");
					 
				 } break;
			
		}
	}
}
