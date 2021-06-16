package 프로젝트소스_공유용.지은_메뉴기능;

import java.util.ArrayList;

public class MenuDAO {
	public ArrayList<Menu> menuList = new ArrayList<Menu>();  
	public ArrayList<Cart> cartList = new ArrayList<Cart>();
	public ArrayList<SetMenu> setList = new ArrayList<SetMenu>();
	Service service;
	
	// 생성자: 메뉴와 세트메뉴 초기값 설정
	public MenuDAO() {	
		super();
		menuList.add(new Menu("피자", "고구마피자", 8000, "L"));
		menuList.add(new Menu("피자", "불고기피자", 9000, "L"));
		menuList.add(new Menu("사이드", "핫윙", 5000, "5조각"));
		menuList.add(new Menu("음료", "콜라", 1000, "500ml"));
		
		setList.add(new SetMenu("피치맥세트", "피자", "고구마피자", "포장", 22900, "L"));
		setList.add(new SetMenu("피치맥세트", "사이드", "순살치킨", "포장", 22900, "8조각"));
		setList.add(new SetMenu("피치맥세트", "음료", "제주맥주", "포장", 22900, "355ml"));
		setList.add(new SetMenu("피치콜세트", "피자", "불고기피자", "배달", 22900, "L"));
		setList.add(new SetMenu("피치콜세트", "사이드", "갈릭치킨", "배달", 22900, "4조각"));
		setList.add(new SetMenu("피치콜세트", "음료", "콜라", "배달", 22900, "1.25L"));
	}
	
	// 2) 메뉴 불러오기
	public ArrayList<Menu> menuList() {
		System.out.println(" DAO : 메뉴불러오기 접근 ");
		return menuList;
	}

	// 1) 장바구니 담기
	public String cartAdd(Cart cart) { 
		System.out.println(" DAO : 장바구니담기 접근 ");
		//cartList = new ArrayList<Cart>();
		cartList.add(cart);
		return "메뉴추가 완료";
	}
	
	// 3) 장바구니 목록 불러오기
	public ArrayList<Cart> cartList() {
		System.out.println(" DAO : 장바구니불러오기 접근 ");
		return cartList;
	}	
	
	// 3) 수량변경
	public String cartUpdate(Cart cart, int idx) {
		System.out.println(" DAO : 수량변경 접근 \n");
		cartList.set(idx, cart);
		return "수량변경 완료";
	}

	// 4) 세트메뉴 불러오기
	public ArrayList<SetMenu> setList() {
		System.out.println(" DAO : 세트메뉴리스트 접근 ");
		return setList;
	}
	
}
 