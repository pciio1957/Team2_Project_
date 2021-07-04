package Hyejin.JSTUDY;

public class Cart_Controller {
	private Cart_Service ser = new Cart_Service();

	//1. 장바구니호출(입력값없이) - 확인용
	public String cartlist2(Model d) {
		d.addAttribute("장바구니 호출", ser.cartlist2());
		return "";
	}
	
	
	// 2.위시리스트호출(입력값없이) - 확인용
	public String wishlist2(Model d) {
		d.addAttribute("위시리스트호출", ser.wishlist2());
		return "";
	}
	
	// 1. 장바구니 호출
	public String cartlist(String ch, Model d) {
		System.out.println("[controll확인]사용자 입력값:" + ch);
		d.addAttribute("장바구니 호출", ser.cartlist(ch));
		return "";
	}
	
	

	// 2. 위시리스트호출
	public String wishlist(String ch, Model d) {
		d.addAttribute("위시리스트호출", ser.wishlist(ch));
		return "";
	}

	// 3. 위시리스트 - 장바구니 이동메서드

	public String movecart(String code4, Model d) {
		d.addAttribute("장바구니이동", ser.movecart(code4));
		return "";
	}
	
	//3-1. 장바구니 - 위시리스트 이동메서드 
	public String movewish(String code5, Model d) {
		d.addAttribute("위시리스트이동", ser.movewish(code5));
		return "";
	}
	

	// 4. 포인트조회

	public String mypoint(String name, Model d) {
		System.out.println("[controll확인]사용자 입력값:" + name);
		d.addAttribute("장바구니 호출", ser.mypoint(name));
		return "";

	}

	// 5. 장바구니삭제
	public String removelec(String code, Model d) {
		d.addAttribute("장바구니 삭제", ser.removelec(code));
		return "";
	}

	// 6. 포인트 사용 및 잔액확인

	public String afterpoint(int usem, Model d) {
		d.addAttribute("포인트사용잔액확인", ser.afterpoint(usem));
		return "";
	}

	// 7. 구매액 확인

	public String buy(String ch, Model d) {
		d.addAttribute("구매액확인", ser.buy(ch));
		return "";
	}

	// 8. 주문

	public String order(String code5, Model d) {
		d.addAttribute("주문결제", ser.order(code5));
		return "";
	}
	
	//9. 구매내역 확인 
	public String orderlist(String code6, Model d) {
		d.addAttribute("구매내역", ser.orderlist(code6));
		return "";
	}
}
