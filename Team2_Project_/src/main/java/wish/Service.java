package wish;

import java.util.ArrayList;

import PG5.Wishlist2;


public class Service {
	
	Cart_Dao dao = new Cart_Dao();
	/*public ArrayList<Lecture> product_infor(Lecture inf){
		System.out.println("# 화면에서 넘어온 데이터:"+inf.getCode() +" #");
		return dao.cartlist(inf);
	}*/

	// 장바구니 리스트
	public ArrayList<Cart> cartlist(Cart bs){
		return dao.cartlist(bs);
	}
	public ArrayList<Cart> addlec(Cart bs){
		System.out.println("( 추가할 제품 코드:"+bs.getCode() +" ) ");
			
		return dao.addlec(bs);
	}
	public ArrayList<Cart> removelec(Cart bs){
		System.out.println("( 삭제할 제품 코드:"+bs.getCode() +" ) ");
		return dao.removelec(bs);
	}
	
	public ArrayList<Lecture> wishlistcome(Lecture bs) {
		System.out.println("");
		
		return dao.wishlistcome();
	}	
	
	
	//포인트적립금액 
	public int pointlist(Cart pd) {
		int pointtot = 30000;
		int user = 	choice;
		//기존누적값 
		//int a = (pointtot - choice);
		//point1 = pd.getGetpoint(); //구매내역에서 지급받는포인트를 누적시킨 값 
		//System.out.println(pointtot - point1);
		System.out.println("남은금액:" +);
		return dao.pointlist(pd);
		}
	/*
	public int pointlist(Cart pd) {
		return dao.pointlist(pd);
		}
	
	//포인트사용후금액 
	public int pointuse(Cart pd) {
		int totpoint = pd.getGetpoint();
		int pointpast =  totpoint++;
	
			return dao.pointlist(pd);
		}
	public Object wishlistcome(Lecture bs) {
		// TODO Auto-generated method stub
		return null;
	}
	*/
	
	
}
