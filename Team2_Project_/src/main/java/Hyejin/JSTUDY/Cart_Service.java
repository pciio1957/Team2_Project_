package Hyejin.JSTUDY;

import java.util.ArrayList;

import DeokJae.Lotto.DPR1Account;

public class Cart_Service {
	private ArrayList<Account> alist = new ArrayList<Account>();
	private ArrayList<Cart> cartlist = new ArrayList<Cart>(); // 객체배열생성
	private ArrayList<Lecture> wishlist = new ArrayList<Lecture>();
	public ArrayList<Order> orderlist = new ArrayList<Order>();
	Cart_Dao dao = new Cart_Dao();

//===============================================================================================================	
	//0. 장바구니조회
	public String cartlist2() {
		
		cartlist = dao.cartlist();
		System.out.println("[번호]" + "\t" + "[이미지]" + "\t" + "[강의명]" + "\t" + "\t" + "\t" + "[금액]" + "\t" + "[적립포인트]"
		+ "\t" + "[강의코드]" + "\t");

		int listIDX = 1; // 리스트 순서번호

			for (Cart c : cartlist) {
				c.Showinfo(listIDX);
				listIDX++;
			}return "전체호출완료";

	}
	
	
	//0-2
		public String wishlist2() {
		
		wishlist = dao.wishlist();
		System.out.println("[번호]" + "\t" + "[이미지]" + "\t" + "[강의명]" + "\t" + "\t" + "\t" + "[금액]" + "\t" + "[적립포인트]"
		+ "\t" + "[강의코드]" + "\t");

		int listIDX = 1; // 리스트 순서번호

			for (Lecture c : wishlist) {
				c.Showwish(listIDX);
				listIDX++;
			}return "전체호출완료";

	}
	
	
	// 1. 장바구니 리스트
	public String cartlist(String ch) {
		System.out.println("[service단확인]사용자 입력값:" + ch);

		// 장바구니리스트
		cartlist = dao.cartlist();
		System.out.println("[번호]" + "\t" + "[이미지]" + "\t" + "[강의명]" + "\t" + "\t" + "\t" + "[금액]" + "\t" + "[적립포인트]"
		+ "\t" + "[강의코드]" + "\t");

		int listIDX = 1; // 리스트 순서번호
		if (ch.equals("1")) {

			for (Cart c : cartlist) {
				c.Showinfo(listIDX);
				listIDX++;
			}

		}
		return "전체호출완료";
	}

	// 2.포인트조회
	public String mypoint(String name) {
		System.out.println("[서비스확인]");

		alist = dao.accountinfor1();

		// indx로 리스트 다뽑아주고, 입력한 코드가 cartlist의 코드와 일치하면
		for (int idx = 0; idx < alist.size(); idx++) {
			if (name.equals(alist.get(idx).getUname())) {
				System.out.println("내 포인트:" + alist.get(idx).getMypoint());

				// cartlist.remove(idx);
			}
		}

		return "포인트조회완료";

	}

//===============================================================================================================

	// 3.장바구니삭제
	public String removelec(String code) {

		// 장바구니(cnt)의 코드와 넘어온 상품코드 일치 시, 그 인덱스 삭제(장바구니 삭제)
		cartlist = dao.cartlist();
		System.out.println("[Service단]:확인");

		// indx로 리스트 다뽑아주고, 입력한 코드가 cartlist의 코드와 일치하면

		for (int idx = 0; idx < cartlist.size(); idx++) {
			if (code.equals(cartlist.get(idx).getCode())) {
				System.out.println("삭제할 제품:" + cartlist.get(idx).getCode());

				cartlist.remove(idx);
			}
		}
		return "호출완료";
	}

	// 4. 위시리스트조회
	public String wishlist(String ch) {
		System.out.println("[service단확인]사용자 입력값:" + ch);

		// 장바구니리스트
		wishlist = dao.wishlist();

		System.out.println("[번호]" + "\t" + "[이미지]" + "\t" + "[강의명]" + "\t" + "\t" + "\t" + "[금액]" + "\t" + "[적립포인트]"
				+ "\t" + "[강의코드]" + "\t");

		int listIDX = 1; // 리스트 순서번호
		if (ch.equals("2")) {

			for (Lecture w : wishlist) {
				w.Showwish(listIDX);
				listIDX++;
			}

		}
		return "전체호출완료";
	}

	// 5. 위시리스트- 장바구니 이동
	public String movecart(String code4) {
		System.out.println("[service단확인]사용자 입력값:" + code4);

		wishlist = dao.wishlist();
		cartlist = dao.cartlist();

		for (int idx = 0; idx < wishlist.size(); idx++) {
			if (code4.equals(wishlist.get(idx).getCode())) {
			//	System.out.println("장바구니로이동된 내역" + wishlist.get(idx).getTitle());
			    cartlist.add(new Cart(wishlist.get(idx).getImg(),wishlist.get(idx).getTitle(),wishlist.get(idx).getPrice(),
			    		wishlist.get(idx).getGetpoint(), wishlist.get(idx).getCode()));
			  
			   System.out.println("장바구니로이동된 내역" + wishlist.get(idx).getCode());
			}
		}
		return "장바구니이동완료";

	}

	
	
	//5-1. 장바구니 -위시리스트 이동
	
		public String movewish(String code5) {
			System.out.println("[service단확인]사용자 입력값:" + code5);

			
			cartlist = dao.cartlist();
			wishlist = dao.wishlist();

			for (int idx = 0; idx < cartlist.size(); idx++) {
				if (code5.equals(cartlist.get(idx).getCode())) {
				//	System.out.println("장바구니로이동된 내역" + wishlist.get(idx).getTitle());
				    wishlist.add(new Lecture(cartlist.get(idx).getImg(),cartlist.get(idx).getTitle(),cartlist.get(idx).getPrice(),
				    		cartlist.get(idx).getGetpoint(), cartlist.get(idx).getCode()));
					
				   System.out.println("장바구니로이동된 내역" + cartlist.get(idx).getCode());
				}
			}
			return "장바구니이동완료";

		}
	// 6. 포인트 사용 및 잔액
	public String afterpoint(int usem) {
		System.out.println("[service]" + usem);

		alist = dao.accountinfor1();

		int cnt = 0;
		for (Account a : alist) {
			if (a.getUname().contains("유혜진")) {
				System.out.println("# service : 해당되는 데이터가 있음 #");
//					System.out.println("계좌주 : " + a.getAno());
//					System.out.println("계좌번호 : " + a.getOwner());
				System.out.println("초기입금액 : " + a.getMypoint());
				System.out.println("입력한 출금액 : " + usem);
				int money1 = a.getMypoint();
				int tot = money1 - usem;
				System.out.println("잔액:" + tot);

				// Account alist = new Account(a.getKey(), a.getUname(), a.getAccountNumber(),
				// a.getImportM(),a.getBankname(), a.getMypoint();
				// dao.accountfor1(code4, cnt);
			}
		}
		return "";
	}

	// 7. 구매기능
	public String buy(String ch) {

		System.out.println("[service]" + ch);

		cartlist = dao.cartlist();

		// 총액
		int tot = 0;
		for (int idx = 0; idx < cartlist.size(); idx++) {

			tot += cartlist.get(idx).getPrice();
		}

		System.out.println("총액:" + tot);
		// System.out.println("총액 - 포인트:" + tot-usem);

		return "";
	}

	// 8. 결제방법확인
	public String order(String code5) {
		System.out.println("service단확인" + code5);
		
		orderlist = dao.orderlist();
		
		return "";
	}
	
	//9. 구매내역 확인
	public String orderlist(String code6) {
		
		orderlist = dao.orderlist();
		
		for (int idx = 0; idx < orderlist.size(); idx++) {
			if (code6.equals(cartlist.get(idx).getCode())) {
				System.out.println("삭제할 제품:" + cartlist.get(idx).getCode());

				cartlist.remove(idx);
		System.out.println("service단확인" + code6);

	
	}
	
}	return "";
	}
	}