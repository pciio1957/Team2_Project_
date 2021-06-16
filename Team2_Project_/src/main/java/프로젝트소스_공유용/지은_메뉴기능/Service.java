package 프로젝트소스_공유용.지은_메뉴기능;

import java.util.ArrayList;

public class Service {
	MenuDAO dao = new MenuDAO();
	private ArrayList<Menu> menuList;
	private ArrayList<Cart> cartList;
	private ArrayList<SetMenu> setList;
	static int cartExist; // 장바구니에 메뉴가 담겼는지 확인하기 위한 변수 
	
	// 1) 메뉴 선택
	public String menuSelect(ArrayList<Cart> clist) {
		int menuCount = 0;

		String inName = clist.get(0).getName();
		String inSize = clist.get(0).getSize();
		int inCount = clist.get(0).getCount();
		
		// 수량제한 
		if(inCount > 11) {
			System.out.println(" - 수량은 10개까지만 구입 가능합니다 - ");
		} else {
			menuList = dao.menuList();
		
			for(Menu m:menuList) {
				if(m.name.equals(inName) && m.size.equals(inSize)) {
					menuCount++;
					System.out.println("\n# 장바구니 추가목록#");
					System.out.println(" 메뉴 : " + m.kind);
					System.out.println(" 메뉴명 : " + m.name);
					System.out.println(" 사이즈 : " + m.size);
					System.out.println(" 가격 : " + m.price);
					System.out.println(" 수량 : " + inCount + "\n");
				
					dao.cartAdd(new Cart(m.getKind(), inName, m.getPrice(), inSize, inCount));

				}
			}
			menuLope(menuCount);
		}
		return "완료";	
	}
		
	// 2) 메뉴리스트
	public String menuList(String choice) {
		System.out.println(" Service : 메뉴리스트 접근 ");
		
		String saveMenu = "";
		int menuCount = 0;
		
		// 찾으려는 메뉴의 구분
		switch(choice) {
			case "1": saveMenu = "전체"; break;
			case "2": saveMenu = "피자"; break;
			case "3": saveMenu = "세트"; break;
			case "4": saveMenu = "사이드"; break;
			case "5" : saveMenu = "음료"; break;
			default: 
				System.out.println(" --잘못된 번호를 입력했습니다. "
					+ "번호는 1~4만 입력하세요-- ");
		}
		
		// dao에서 메뉴리스트를 불러옴
		menuList = dao.menuList();
		

		System.out.println("\n# 조회 목록 #");
		System.out.println(" 번호\t종류\t메뉴명\t사이즈\t가격");
		if(saveMenu.equals("전체")) {
			for(Menu menu:menuList) {
				menu.showMenu(menuCount);
				menuCount++;
			} menuLope(menuCount);
			
		} else {
			for(Menu menu:menuList) {
				if(menu.kind.equals(saveMenu)) {
					menu.showMenu(menuCount);
					menuCount++;
				} 
			} menuLope(menuCount);
		}

		return "완료";
	}
	
	// 3) 수량변경
	public String cartUpdate(String name, String size, String count) {
		System.out.println(" Service : 수량변경 접근 ");
		System.out.println("\n# 변경메뉴 정보 #");
		System.out.println(" 메뉴명 : " + name);
		System.out.println(" 사이즈 : " + size);
		System.out.println(" 수량 : " + count);
		
		// 수량 제한
		if(Integer.parseInt(count) > 11) {
			System.out.println(" - 수량은 10개까지만 구입 가능합니다 - ");
			
		} else {
			int uCount = Integer.parseInt(count);
			int cidx = 0;

			// static int cartExist; main에서 구분을 위한 공유변수
			if(cartExist == 1) {
				cartList = dao.cartList();
			
				System.out.println("\n - 장바구니리스트가 있습니다 - ");
				for(Cart c:cartList) {
					
					if(c.getName().equals(name) && c.getSize().equals(size)) { // 사이즈..
						System.out.println(" - 장바구니 수량변경이 완료되었습니다 - \n");
						c.setCount(uCount);
						dao.cartUpdate(c, cidx);
						System.out.println("# 변경메뉴 정보확인 #");
						System.out.println(" 메뉴명 확인 : " + c.getName());
						System.out.println(" 수량 확인 : " + c.getCount());
						System.out.println(" 사이즈 확인 : " + c.getSize());
					} 
					cidx++;
				}
			
			} else {
				System.out.println(" - 장바구니리스트가 없습니다 - \n");
			}
		}

		return "완료";
	}

	// 4) 장바구니 확인
	public String cartList() {
		System.out.println(" Service : 장바구니리스트 접근 ");
		int cartCount = 0;
		cartExist = 0;
		
		cartList = dao.cartList();
		
		System.out.println("\n# 조회 목록 #");
		System.out.println(" 번호\t세트명\t수령방법\t종류\t메뉴명\t사이즈\t가격\t수량");
		
		// 장바구니에 담겨있는 상품이 있는지 확인
		if(cartList != null) {
			for(Cart c:cartList) {
				c.showCart(cartCount);
				cartCount++;
				cartExist = 1;
			}	
		} 
		menuLope(cartCount);
		return "완료";
	}
	
	// 4) 세트메뉴 리스트 불러오기 
	public String setList() {
		System.out.println(" Service : 세트메뉴리스트 접근 ");
		int setCount = 0;
		
		setList = dao.setList();
		
		System.out.println("\n# 조회 목록 #");
		for(SetMenu set:setList) {
			set.showMenu(setCount);
			setCount++;
		}
		
		return "완료";
	}
	
	// 5) 세트메뉴 선택
	public String setSelect(ArrayList<Cart> clist) {
		System.out.println(" Service : 세트메뉴선택 접근 ");
		int setCount = 0;
		
		String event = clist.get(0).getEvent();
		int count = clist.get(0).getCount();
		
		if(count > 11) {
			System.out.println(" - 수량은 10개까지만 구입 가능합니다 - ");
		} else {
			setList = dao.setList();
			
			for(SetMenu s:setList) {
				if(s.sEvent.equals(event)) {
					setCount++;
					System.out.println("\n# 장바구니 추가목록#");
					System.out.println(" 세트명 : " + s.sEvent);
					System.out.println(" 수령방법 : " + s.sReceive);
					System.out.println(" 메뉴 : " + s.sKind);
					System.out.println(" 메뉴명 : " + s.sName);
					System.out.println(" 사이즈 : " + s.sSize);
					System.out.println(" 가격 : " + s.sPrice);
					System.out.println(" 수량 : " + count + "\n");
					

					dao.cartAdd(new Cart(s.getsKind(), s.getsName(), s.getsPrice(), s.getsSize(), count, s.getsEvent(), s.getsReceive()));

				}
			}
			menuLope(setCount);
			
			
			
		}
		
		
		return "완료";
	}
	
	// 조회 결과 출력 메소드
	public void menuLope(int count) {
		if(count == 0) {
			System.out.println("-----------------");
			System.out.println(" - 조회 결과 없음 -\n");
		} else {
			System.out.println("-----------------");
			System.out.println(" - 조회 완료 -\n");
		}
	}	
}
