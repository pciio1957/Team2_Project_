package javaexp.PizzaHut;

import java.util.ArrayList;
import java.util.Scanner;

// main() : 실행 및 입력
public class PizzaHut {
	public static Scanner scan = new Scanner(System.in);
	public static ArrayList<Menu> mList = new ArrayList<Menu>();
	public static ArrayList<Cart> cList;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Controller controller = new Controller();
		
		
		while(true) {	
			// 인덱스메뉴 고르기 1,2,3,4,5
			String index = indexChoice2(); 

			// 선택한 인덱스메뉴에 맞는 화면 출력 
			if(index != null) {
				if(index.equals("1")) { 
					// 주문을 하기전 전체 상품리스트를 확인함
					controller.menuList(new Model(), "1");		
					cList = new ArrayList<Cart>();
					
					// 상품리스트를 보고 주문할 정보를 입력받음
					System.out.println("주문하실 메뉴의 정보를 입력하세요");
					String cName = inputStr(" 메뉴명 : " );
					String cSize = inputStr(" 사이즈 : ");
					String cCount = inputStr(" 수량 : ");	

					// 사용자가 입력한 메뉴명, 사이즈, 수량을 clist에 넣고 컨트롤러로 넘어감
					cList.add(new Cart(cName, cSize, Integer.parseInt(cCount)));
					controller.menuSelect(cList, new Model());

				} else if(index.equals("2")) {
					// 전체/특정 메뉴리스트 확인
					String menuchoice = menuChoice(); 
					controller.menuList(new Model(), menuchoice);					

				} else if(index.equals("3")) {
					// 수량 변경 : 장바구니에 있는 데이터를 가져와서 수량변경
					controller.cartList(new Model());	
  
					// static형식 사용, 클래스명.속성형식으로 가져와서 사용
					if(Service.cartExist == 0) {
						System.out.println(" - 장바구니에 상품이 없습니다 - ");
					} else {
						System.out.println("변경하실 메뉴의 정보를 입력하세요");
						String cName = inputStr(" 메뉴명 : " );
						String cSize = inputStr(" 사이즈 : " );
						String cCount = inputStr(" 수량 : ");	
						controller.cartUpdate(new Model(), cName, cSize, cCount);
					}
						
				} else if(index.equals("4")) {

					controller.setList(new Model());
					cList = new ArrayList<Cart>();
					
					// 상품리스트를 보고 주문할 정보를 입력받음
					System.out.println("주문하실 세트의 정보를 입력하세요");	
					String cEvent = inputStr(" 세트명 : " );
					String cCount = inputStr(" 수량 : ");	
					
					cList.add(new Cart(cEvent, Integer.parseInt(cCount)));
					controller.setSelect(cList, new Model());
					
				} else if(index.equals("5")) {
					System.out.println("# 주문이 종료됩니다 #"); 
					break;
				} else {
					System.out.println("\n - 메뉴 입력은 [1]~[5]만 가능합니다 - "); 
				}
			}
		}
	}

	static public String inputStr(String msg) {
		System.out.print(msg);
		return scan.nextLine();	
	}
	
	public int inputInt(String msg) {
		System.out.print(msg);
		return scan.nextInt();
	}
	
	// 얘를 호출을 컨트롤러에서 하고 서비스에 메뉴에 대한 구별 dao에서 데이터를 
	static public String menuChoice() {
		System.out.println("\n# 주문 메뉴 선택 #");
		System.out.println("[1] 전체 [2] 피자 [3] 세트 [4] 사이드 [5] 음료");
		System.out.println("(주의 : 입력은 숫자만 가능합니다)");
		return inputStr("메뉴 입력 : ");	// 메인
	}
	

	// 오류때문에 숫자를 String형으로 입력받음
	static public String indexChoice2() {
		System.out.println("\n# 피자헛 홈페이지 #");
		System.out.println("[1] 메뉴선택 [2] 메뉴리스트 [3] 수량변경 [4] 세트선택 [5] 종료");
		System.out.println(" (주의 : 입력은 숫자만 가능합니다)");
		String index = inputStr(" 인덱스 입력 : "); 
		return index;
	}
	

}
