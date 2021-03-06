package 프로젝트소스_공유용.성근_구매기능.장바구니;

import java.util.ArrayList;

public class CartService {
	CartDAO cdao = new CartDAO();
	public ArrayList<CartDTO> cartList(CartDTO ca) {
		System.out.println("===============================================\n");
		System.out.println("# Service #\n");
//		DAO로 데이터를 넘기기 위한 확인 과정
		System.out.println("CartDAO에 전송 할 장바구니 데이터 1 (상품 번호) : " + ca.getProdkey());
		System.out.println("CartDAO에 전송 할 장바구니 데이터 2 (상품명) : " + ca.getProdName());
		System.out.println("CartDAO에 전송 할 장바구니 데이터 3 (가격) : " + ca.getPrice());
		System.out.println("CartDAO에 전송 할 장바구니 데이터 4 (수량) : " + ca.getCnt());
		System.out.println("CartDAO에 전송 할 장바구니 데이터 5 (상품 총 가격) : " + ca.getTot1());
		System.out.println("CartDAO에 전송 할 장바구니 데이터 6 (배송비) : " + ca.getDelivery());
		System.out.println("CartDAO에 전송 할 장바구니 데이터 7 (총 가격) : " + ca.getTot2());
		System.out.println("CartDAO에서 받을 장바구니 데이터 크기 : " + cdao.cartList(ca).size() + "\n");
		return cdao.cartList(ca);
	}

}
