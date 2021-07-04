package Hyejin.JSTUDY;

import java.util.ArrayList;


public class Cart_Dao {
	private ArrayList<Cart> cartlist = new ArrayList<Cart>();
	public ArrayList<Lecture> wishlist = new ArrayList<Lecture>();
	public ArrayList<Order> orderlist = new ArrayList<Order>();
	
	
			//0. DB 저장 데이터 
			public Cart_Dao() { 
			super();
			// DB에 저장되있는 데이터
		    cartlist.add(new Cart("img", "react로 시작하는 sns만들기1", 50000, 500,"AA"));
		    cartlist.add(new Cart("img", "react로 시작하는 sns만들기2", 50000, 500,"03BB"));
		    cartlist.add(new Cart("img", "react로 시작하는 sns만들기3", 50000, 500,"03CC"));
		    cartlist.add(new Cart("img", "react로 시작하는 sns만들기4", 50000, 500,"03DD"));
		    cartlist.add(new Cart("img", "react로 시작하는 sns만들기5", 50000, 500,"03EE"));	
		    
			wishlist.add(new Lecture("img", "react로 시작하는 sns만들기", 50000, 500,"01AA"));
			wishlist.add(new Lecture("img", "Spring으로 시작하는 sns만들기", 50000, 500,"01BB"));
			wishlist.add(new Lecture("img", "파이썬로 시작하는 sns만들기", 50000, 500,"01CC"));
			wishlist.add(new Lecture("img", "ajax로 시작하는 sns만들기", 50000, 500,"01DD"));
			wishlist.add(new Lecture("img", "jsp로 시작하는 sns만들기", 50000, 500,"01EE"));		
			
			
			orderlist.add(new Order(20210501, "heyjinss", "00001A","04DD", "Spring으로 시작하는 코딩", "고양시"));
			
			
}
			
			//1. 구매내역 조회 
			
			public ArrayList<Order> orderlist() { //왜 add오류 ?
				System.out.println("[DAO단 확인]: 사용자 구매내역");
				
				 return orderlist;
				}
			
			
			//2. 장바구니 조회
			public ArrayList<Cart> cartlist() { //왜 add오류 ?
			System.out.println("[DAO단 확인]: 사용자의 장바구니 목록");
			
			 return cartlist;
			}

			//3. 위시리스트조회 
			public ArrayList<Lecture> wishlist() { //왜 add오류 ?
			System.out.println("[DAO단 확인]: 사용자의 장바구니 목록");
			
			 return wishlist;
			}
						
			//4. 계과계정조회  
			ArrayList<Account> alist = new ArrayList<Account>();
			public ArrayList<Account> accountinfor1() {
				alist.add(new Account(0001, "유혜진", "3333-3333-333", 30000, "카카오뱅크", 10000));
				alist.add(new Account(0002, "유수진", "3333-3333-333", 30000, "카카오뱅크",5000));
				alist.add(new Account(0003, "김지은", "3333-3333-333", 30000, "카카오뱅크",6000));
				alist.add(new Account(0004, "유희열", "3333-3333-333", 30000, "카카오뱅크",100));
	
			return alist;
			}
}

		