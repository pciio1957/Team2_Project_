package Hyejin.JSTUDY;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// 컨트롤 객체로 묶어서 넘겨주기 위함
		Cart_Controller controller = new Cart_Controller();

		// 사용자에게서 입력받기 위한 [입력함수 선언]
		Scanner scan = new Scanner(System.in);

		// 0. 화면(선택기능)
		while (true) {
			System.out.println("##JSTUDY 장바구니페이지##");
			System.out.println("[1]장바구니리스트 삭제 [2] 위시리스트조회 [3] 포인트조회 및 사용 [4] 결제하기 ");

			String ch = scan.nextLine();


			// 1. 장바구니 리스트 삭제
			if (ch.equals("1")) {
				// 2-1. 장바구니 목록 화면 호출
				System.out.println("========================[고객님의 장바구니 목록]==========================");
				controller.cartlist(ch, new Model());

				System.out.println("[1] 장바구니 삭제 [2] 위시리스트 이동");
				String code3 = scan.nextLine();
				
					if(code3.equals("1")) {
						
						System.out.println("삭제할 장바구니 코드를 입력하세요");
						String code = scan.nextLine(); // O1AA
						controller.removelec(code, new Model());
						controller.cartlist(ch, new Model());
					}
			
					
					else if (code3.equals("2")) {
						System.out.println("위시리스트로 이동할 코드를 입력하세요");
						String code5 = scan.nextLine(); // O1AA
						controller.movewish(code5, new Model());
						controller.wishlist2(new Model());
						
					}
			continue;
				//강의코드에 없는 코드 입력시 제약조건 (?) 
			

				// controller.removelec(new Cart(), new Model ());
			}

			//2. 나의 위시리스트 조회 (장바구니 이동)
			else if (ch.equals("2")) {
				System.out.println("=====================[나의 위시리스트]========================");
				controller.wishlist(ch, new Model());

				System.out.println("장바구니로이동시려면 코드를 입력해주세요");
				String code4 = scan.nextLine(); // O1AA
				controller.movecart(code4, new Model());
				controller.cartlist2(new Model());
				
				continue;	
				
			}
			

			//3. 나의포인트 조회 및 사용 
			else if (ch.equals("3")) {
				System.out.println("=====================[나의 포인트]========================");
				System.out.println("이름을 입력하세요");
				String name = scan.nextLine();
				controller.mypoint(name, new Model());
			
				System.out.println("사용할금액을 입력하세요");
				int usem = scan.nextInt();
				//String code4 = scan.nextLine();
				controller.afterpoint(usem, new Model());
				
				continue;
			}

			//4. 결제 및 구매내역 확인 
			else if (ch.equals("4")) {
				System.out.println("===============[총 결제금액]=====================");
				controller.buy(ch, new Model());
				
				
				String name;
				System.out.println("회원이름을 입력하세요");
				name = scan.nextLine();
				
				
				String address;
				System.out.println("주소를 입력하세요:");
				address = scan.nextLine();
			
				System.out.println("구매방법을 선택해주세요");
				System.out.println("1[무통장입금]   2[카드결제]   3[신용카드]   4[가상계좌]   5[휴대폰결제] ");
				String code5 = scan.nextLine();

				//===============================
				if (code5.equals("1") | code5.equals("2") | code5.equals("3") | code5.equals("4") | code5.equals("5")) {
					System.out.println("주문 완료되었습니다.");
					System.out.println("구매내역을 조회하시겠습니까?");
					
					
					
					String code6 = scan.nextLine();
					if(code6.equals("1")) {
						
						controller.orderlist(code6,new Model());
					}
				}

			} break;
		
		}

	}
}

