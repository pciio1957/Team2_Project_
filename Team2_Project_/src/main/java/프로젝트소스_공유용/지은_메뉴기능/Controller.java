package 프로젝트소스_공유용.지은_메뉴기능;

import java.util.ArrayList;

public class Controller {
	public MenuDAO menuDAO = new MenuDAO();
	Service service = new Service();
	
	// 1) 주문을 위한 메뉴 선택
	public String menuSelect(ArrayList<Cart> clist, Model d) {
		System.out.println("\n Controller : 메뉴선택 접근 ");
		d.addAttribute("메뉴선택", service.menuSelect(clist)); 
		return "메뉴선택"; 
	}

	// 2) 피자헛 메뉴리스트 불러오기
	public String menuList(Model d, String choice) {
		System.out.println("\n Controller : 메뉴리스트 접근 ");
		d.addAttribute("메뉴불러오기", service.menuList(choice));
		return "메뉴리스트"; //메뉴리스트
	}
	
	// 3) 장바구니 리스트
	public String cartList(Model d) {
		System.out.println("\n Controller : 장바구니리스트 접근 ");
		d.addAttribute("장바구니리스트", service.cartList());
		return "장바구니리스트";
	}
	
	// 4) 장바구니 수량변경 
	public String cartUpdate(Model d, String name, String size, String count) {
		System.out.println("\n Controller : 수량변경 접근 ");
		d.addAttribute("수량변경", service.cartUpdate(name, size, count));
		return "수량변경";
	}
	
	// 5) 세트메뉴 리스트 불러오기
	public String setList(Model d) {
		System.out.println("\n Controller : 세트메뉴리스트 접근 ");
		d.addAttribute("세트메뉴 리스트", service.setList()); 
		return "세트메뉴리스트";
	}
	
	// 5) 세트메뉴 선택
	public String setSelect(ArrayList<Cart> clist, Model d) {
		System.out.println("\n Controller : 세트메뉴 선택 접근 ");
		d.addAttribute("세트메뉴 선택", service.setSelect(clist)); 
		return "세트메뉴 선택";
	}
}
