package SungKeun.DHLOTTO.LT2_CATCHME;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import SungKeun.DHLOTTO.Model;

public class LT2Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int lotto[] = new int[7]; // 당첨 복권 번호 생성
		int myLotto[] = new int[6]; // 선택한 복권 번호 내역
		int result[] = new int[6]; // 추첨 복권 번호 (선택 복권 번호와 일치 여부 확인)
		int cnt, i, j, tmp; // cnt : 선택한 복권 번호와 당첨 복권 번호의 일치하는 갯수
		int gen_count = 0; // 선택할 복권 번호를 카운팅
		int ok_generation; // 카운팅 완료
		
		Scanner sc = new Scanner(System.in);
		
		/*
		 # CATCH ME 로직 계획
		 	1. 시작 전 1게임당 500원으로 최대 5배수까지 설정하여 구매
		 	2. 구매하면 영수증 출력 후 게임 시작.
		 	1. 11개의 랜덤 당첨 번호 선정. (당첨번호는 번호 선택 후 공개)
		 	2. 복권 번호 선택 6개 선택.
		 	3. 선택하면 당첨 번호도 같이 공개되어 3개 일치 시 선택한 배수만큼 당첨금액 지급!
		 	결론 : LOTTO 6/45의 로직의 순서를 적절히 바꾸면 가능성이 있음!
		 	
		 */
		
		// 복권 구매 페이지
		System.out.println("# CATCH ME : 복권 구매 #\n");
		System.out.println("상품명 : CATCH ME \n");
		int price = 500;
		System.out.print("예치금 : 500원" + "\n");
		System.out.print("배수 : ");
		int lt2cnt1 = sc.nextInt();
		System.out.println("선택 배수 : " + lt2cnt1 + " 배");
		int tot2 = price*lt2cnt1;
		System.out.println("상품 총 가격 : " + tot2 + "원" + "\n");
		
		System.out.println("\n# CATCH ME 구매가 완료되었습니다. #\n");
		
		// 영수증 출력
		System.out.println("[ CATCH ME 구매 영수증 ]\n");
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		System.out.println("발 행 일 : " + dateFormat.format(cal.getTime()) + "\n");
//		for(i=0; i<6; i++) {
//			System.out.print("[" + myLotto[i] + "]");
//		}
		System.out.println("배수 : " + lt2cnt1 + "배");
		System.out.println("금액 : " + tot2 + "원\n");
		System.out.println("===============================================\n");
		
		System.out.println("# CATCH ME : 같은 금액을 가진 도둑 3명을 찾아라! # \n");
		
		// 당첨번호 생성
		for(i=0; i<7; i++) {
			lotto[i] = (int)(Math.random()*50 + 1);
		}
		
		// 복권 번호 선택
		while(gen_count < 6) {
			ok_generation = 1;
			System.out.printf("[%d] [1-11] 번호 선택 : ", gen_count+1);
			tmp = sc.nextInt();
			
			for(i=0; i<6; i++) {
				if(tmp == myLotto[i]) {
					ok_generation = 0;
					break;
				}
			}
			
			if (ok_generation !=0) {
				myLotto[gen_count] = tmp;
				gen_count++;
			} else
				System.out.println("중복된 번호입니다. 다시 입력해주세요.");
		}
		
//		// 선택한 복권 번호 확인
//		System.out.println("\n# CATCH ME : 과연 결과는?! #\n");
//		
//		System.out.print("선택한 복권 번호는 [");
//		for(i=0; i<6; i++) {
//			System.out.print(myLotto[i] + " ");
//		}
//		System.out.println("] 입니다. \n");
//
//		System.out.println("===============================================\n");
		
//		// 당첨번호 생성
//		for(i=0; i<7; i++) {
//			lotto[i] = (int)(Math.random()*45 + 1);
//		}
		
		// 당첨 결과
		System.out.println("\n# CATCH ME : 당첨 결과! #\n");
		
		System.out.print("선택한 창문 번호 : [");
		for(i=0; i<6; i++) {
			System.out.print(myLotto[i] + "번 ");
		}
		System.out.println("]\n");
		
		System.out.print("CATCH ME 당첨 번호 : [");
		
		for(i=0; i<6; i++) {
			System.out.print(lotto[i] + "백만원 ");
		}
		System.out.printf("]", lotto[6]);
		
		cnt = 0;
		for(i=0; i<6; i++) {
			for(j=0; j<7; j++) {
				if(myLotto[i] == lotto[j]) {
					result[cnt] = myLotto[i];
					cnt++;
				} 
			}
		}
		
		System.out.printf("\n* 일치하는 당첨 금액 수 : %d\n", cnt);
		if(cnt>0) {
			System.out.print("* 일치하는 당첨 금액 : ");
			for(i=0; i<cnt; i++) {
				System.out.print(result[i] + "백만원 ");
			}
		}
		
		System.out.println("\n");
		
//		if(cnt == 6)
//			if(result[cnt] == lotto[5]) System.out.print("제 n 회 LOTTO 6/45 복권 추첨 결과 : 1등입니다! \n");
//			else System.out.print("제 n 회 LOTTO 6/45 복권 추첨 결과 : 2등 \n");
//		else if(cnt==5) System.out.print("제 n 회 LOTTO 6/45 복권 추첨 결과 : 3등 \n");
//		else if(cnt==4) System.out.print("제 n 회 LOTTO 6/45 복권 추첨 결과 : 4등 \n");
//		else if(cnt==3) System.out.print("제 n 회 LOTTO 6/45 복권 추첨 결과 : 5등 \n");
//		else
//			System.out.print("제 n 회 LOTTO 6/45 복권 추첨 결과 : X \n");
//			System.out.println("\n### LOTTO 6/45 당첨 조건 ###\n");
//			System.out.println("* 선택 번호, 당첨 번호 * \n 1) 3개 일치 시, 5등! \n 2) 4개 일치 시, 4등! \n 3) 5개 일치 시, 3등! \n 4) 6개 일치 시, 2등! \n 5) 6개 & 보너스 번호 일치 시, 1등!");
		
		if(cnt == 3)
			if(result[cnt] == lotto[5]) {
//			if(result[cnt] == lotto[6]) {
				System.out.print("CATCH ME 당첨 결과 : 당첨입니다! \n");
			} else {
				System.out.print("CATCH ME 당첨 결과 : 아쉽네요! 다음 기회에!! \n");
				System.out.print("\n### CATCH ME 당첨 조건 ###\n");
				System.out.print("* 11개의 창문 중 6개를 열어 같은 금액을 갖고 있는 도둑 3명을 잡으면 당첨!! *");
			}

		// Scanner이나 직접 입력 처리
		// 입력 값으로 처리된 객체 생성
		LT2DTO lto2 = new LT2DTO(myLotto, result);
		// Controller만 호출.
		LT2Controller lt2ctrl = new LT2Controller();
		System.out.println("\n# 호출된 화면 #\n");
		System.out.println(lt2ctrl.LT2List2(lto2, new Model()));

	}

}