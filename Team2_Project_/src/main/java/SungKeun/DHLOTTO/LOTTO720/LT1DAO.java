package SungKeun.DHLOTTO.LOTTO720;

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
		
		lt1list.add(new LT1DTO(lto.getLtType(), lto.getLtNum()));
		
	    // 전체 회원을 확인하기 위한 메소드
		System.out.println("===============================================\n");
		System.out.println("# DB 서버에 넘겨 줄 회원 정보 데이터 #\n");
		System.out.println("선택 조 : " + lto.getLtType());
		System.out.println("복권 번호 (6자리) : " + lto.getLtNum() + "\n");
		System.out.println("===============================================\n");
		System.out.println("# DB 서버에서 온 회원 정보 데이터 리스트 #\n");
		lt1list.add(new LT1DTO(1, 4)); // (선택 조, 복권 번호 6자리 {배열로 선언 예정})
		lt1list.add(new LT1DTO(3, 5));
		lt1list.add(new LT1DTO(6, 6));
//		System.out.println("===============================================\n");
		for(LT1DTO lto1:lt1list) {
			System.out.print("선택 조 : " + lto1.getLtType() + "\n");
			System.out.print("복권 번호 (6자리) : " + lto1.getLtNum() + "\n");
		}

		return lt1list;
	}
}
