package SungKeun.DHLOTTO.LOTTO720;

import SungKeun.DHLOTTO.Model;

public class LT1Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		int[] ltNum = null;
		int[] ltType = null;
		// Scanner이나 직접 입력 처리
		// 입력 값으로 처리된 객체 생성
		LT1DTO lto1 = new LT1DTO(ltType, ltNum);
		// Controller만 호출.
		LT1Controller lt1ctrl = new LT1Controller();
		System.out.println("\n# 호출된 화면 #\n");
		System.out.println(lt1ctrl.LT1List2(lto1, new Model()));
		
	}	

}
