package wish;

import java.util.ArrayList;


public class Cart_Dao {
	
		ArrayList<Lecture> list = new ArrayList<Lecture>(); //Vo에 저장된 <Lecture> raw를 어레이리스트로 저장 생성자선언 
		
			//1. 위시리스트 조회 (전체상품내역조회)
			public ArrayList<Lecture> wishlistcome(){
			// DB에 저장되있는 데이터..
			list.add(new Lecture("img", "react로 시작하는 sns만들기", 50000, 500,"01AA",1));
			list.add(new Lecture("img", "Spring으로 시작하는 sns만들기", 50000, 500,"01BB",1));
			list.add(new Lecture("img", "파이썬로 시작하는 sns만들기", 50000, 500,"01CC",1));
			list.add(new Lecture("img", "ajax로 시작하는 sns만들기", 50000, 500,"01DD",1));
			list.add(new Lecture("img", "jsp로 시작하는 sns만들기", 50000, 500,"01EE",1));
		
			System.out.println("# DB에서 일치하는 데이터 전송 #");
			for(Lecture pro:list) {
			System.out.println("상품코드:"+pro.getCode()+" ]");
			System.out.println("적립포인트:"+pro.getGetpoint());
			System.out.println("강의명:"+pro.getTitle());
			System.out.println("가격:"+pro.getPrice());	
		}
			return list;
			}
			/*	
			System.out.println("# DB에서 일치하는 데이터 전송 #");
			for(Lecture pro:list) {
			if(ws.getCode() == pro.getCode()) {
			System.out.println("상품코드:"+pro.getCode()+" ]");
			System.out.println("적립포인트:"+pro.getGetpoint());
			System.out.println("강의명:"+pro.getTitle());
			System.out.println("가격:"+pro.getPrice());
			*/
		
		//--------------------------------------------------------------------
		
		
		// 장바구니 추가 ( 이미 추가된 상품일 경우, 상품 갯수 +1 )
			
			
			//2. 장바구니추가 
			ArrayList<Cart> clist = new ArrayList<Cart>();
			public ArrayList<Cart> addlec(Cart pd){
			// DB에 저장되있는 데이터
			clist.add(new Cart("img", "react로 시작하는 sns만들기1", 50000, 500,"03AA",1));
			clist.add(new Cart("img", "react로 시작하는 sns만들기2", 50000, 500,"03BB",1));
			clist.add(new Cart("img", "react로 시작하는 sns만들기3", 50000, 500,"03CC",1));
			clist.add(new Cart("img", "react로 시작하는 sns만들기4", 50000, 500,"03DD",1));
			clist.add(new Cart("img", "react로 시작하는 sns만들기5", 50000, 500,"03EE",1));
			
		
			System.out.println("( DB에서 일치하는 데이터 전송 )");
			// check를 통해서 1이면 장바구니에 추가 0이면 장바구니에 존재상품 => 상품수량+1
			int check =1 ;
			for(Cart pro:clist) {
					if(pro.getCode()==pd.getCode()) {
						for(Cart bs:clist) {
							// 0으로 초기화
							check =0 ;
							if(pd.getCode() == bs.getCode()) {
							// 추가하는 상품이 장바구니에 존재하면 상품수량 +1
							bs.cntPlus();
							}else {
							// 장바구니에 존재하지 않을 시 check +1
								check+=1;
							}
						}
						// check가 1일 시 장바구니에 존재하지 않는 상품.
						// IkeaProduct 상품 테이블에서 코드로 정보호출 한 뒤 장바구니에 추가
						if(check==1) {
							System.out.println("( 추가 할 제품 :"+pro.getTitle()+" )");
							clist.add(new Cart(pro.getCode(),pro.getTitle(),pro.getPrice(),1, pro.getImg(),pro.getGetpoint()));
							
								
						}
				}
			}
			return clist;
		}
		
		//3. 장바구니 삭제
			
		public ArrayList<Cart> removelec(Cart pd){
			System.out.println("( DB에서 일치하는 데이터 전송 )");
			// 장바구니(cnt)의 코드와 넘어온 상품코드 일치 시, 그 인덱스 삭제(장바구니 삭제)
			for(int cnt=0;cnt<clist.size();cnt++) {
				if(pd.getCode() == clist.get(cnt).getCode()) {
					System.out.println("( 삭제 할 제품 :"+list.get(cnt).getTitle()+" )");
					clist.remove(cnt);
				}
			}
			return clist;
			
			
			
		}
		
		// 장바구니 리스트
		
		public ArrayList<Cart> cartlist(Cart bs) { //왜 add오류 ?
			ArrayList<Cart> clist = new ArrayList<Cart>();
		//	clist.add(new Lecture("img", "react로 시작하는 sns만들기", 50000, 500,"01AA",1));
		//	clist.addAll(new Lecture("img", "Spring으로 시작하는 sns만들기", 50000, 500,"01BB",1));
			
			System.out.println("( 장바구니 목록 )");
			int totalPrice=0;
			int cnt=1;
			for(Cart bs1:clist) {
				System.out.println(cnt);
				System.out.print("[상품 이름:"+bs1.getTitle()+"]");
				System.out.println("[가격:"+bs1.getPrice()+"]");
				System.out.print("[수량:"+bs1.getCnt()+"]");
				System.out.println("[총 가격"+bs1.getPrice()*bs1.getCnt()+"]");
				totalPrice+=bs1.getPrice()*bs1.getCnt();
				cnt++;
				System.out.println("전체 가격:"+totalPrice);
			
			}
			return clist;
		}
		

		
		//포인트적립
		/*
		public int [] pointlist2 (Cart pd) {
			pro.getGetpoint[]
			return totpoint;
		}
		*/
		public int pointlist(Cart pd) {
			System.out.println("포인트 조회");
			//int totpoint = pd.getGetpoint();
			int totpoint = pd.getGetpoint();
			int pointpast =  totpoint++;
		//	System.out.println("[나의 포인트]:" + totpoint);
			System.out.println("[나의 포인트]:" + 30000);
		//	System.out.println("[포인트적립금액]:" + pointpast);
			
				return pointpast;
			}
		

}