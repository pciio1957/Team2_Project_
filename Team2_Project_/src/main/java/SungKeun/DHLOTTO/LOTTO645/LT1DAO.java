package SungKeun.DHLOTTO.LOTTO645;

import java.util.ArrayList;

public class LT1DAO {
/*
// select * 
// from product
// where name like '%'||'물건명'||'%'
//  and price between 가격의최소 and 가격의최대; 
==> java 객체로 할당 전달..
 */
	
	// 입력값에 의해서 처리한 ArrayList리턴해준다.
	public ArrayList<LT1DTO> LT1List(LT1DTO lto){
		ArrayList<LT1DTO> lt1list  = new ArrayList<LT1DTO>();
		
		lt1list.add(new LT1DTO(lto.getMyLotto(), lto.getLotto(), lto.getResult()));
		
	    // 전체 복권 입력 데이터를 확인하기 위한 메소드
		System.out.println("===============================================\n");
		System.out.println("# DB 서버에 넘겨 줄 복권 입력 데이터 #\n");
		System.out.println("선택한 복권 번호 (보너스 포함) : " + lto.getMyLotto());
		System.out.println("생성된 당첨 복권 번호 : " + lto.getResult() + "\n");
		System.out.println("===============================================\n");
		System.out.println("# DB 서버에서 온 복권 입력 데이터 리스트 #\n");
//		lt1list.add(new LT1DTO(1,3,4,5,6,7,4));
//		lt1list.add(new LT1DTO(3, 5));
//		lt1list.add(new LT1DTO(6, 6));
//		System.out.println("===============================================\n");
		for(LT1DTO lto1:lt1list) {
			System.out.print("선택한 복권 번호 (보너스 포함) : " + lto1.getMyLotto() + "\n");
			System.out.print("생성된 당첨 복권 번호 : " + lto1.getResult() + "\n");
		}

		return lt1list;
	}
}
