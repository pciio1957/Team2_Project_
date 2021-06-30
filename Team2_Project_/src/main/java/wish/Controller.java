package wish;

import PG5.Wishlist2;

public class Controller {
	private Service ser = new Service ();


	public String cartlist(Cart bs,Model d) {
		d.addAttribute("장바구니 호출", ser.cartlist(bs));
		return "";	
	}
	public String pointlist(Cart bs, Model d) {
		d.addAttribute("포인트호출", ser.pointlist(bs));
		return "";
	}
	
	public String addlec(Cart bs,Model d) {
		d.addAttribute("장바구니 추가", ser.addlec(bs));
		return "";
	}
	public String removelec(Cart bs,Model d) {
		d.addAttribute("장바구니 삭제", ser.removelec(bs));
		return "";	
	}
	
	public String wishlistcome(Lecture bs, Model d) {
		d.addAttribute("위시리스트호출", ser.wishlistcome(bs));
		return "";
	}
	
}
