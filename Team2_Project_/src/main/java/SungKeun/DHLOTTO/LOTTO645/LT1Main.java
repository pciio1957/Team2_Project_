package SungKeun.DHLOTTO.LOTTO645;

import java.util.Scanner;

import SungKeun.DHLOTTO.Model;

public class LT1Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int lotto[] = new int[7]; // 당첨 복권 번호 생성
		int myLotto[] = new int[6]; // 선택한 복권 번호 내역
		int result[] = new int[6]; // 추첨 복권 번호 (선택 복권 번호와 일치 여부 확인)
		int cnt, i, j, tmp; // cnt : 선택한 복권 번호와 당첨 복권 번호의 일치하는 갯수
		int gen_count = 0; // 선택할 복권 번호를 카운팅
		int ok_generation; // 카운팅 완료
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("# LOTTO 6/45 : 복권 구매 # \n");
		
		while(gen_count < 6) {
			ok_generation = 1;
			System.out.printf("[%d] [1-45] 번호 선택 : ", gen_count+1);
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
		
		System.out.println("\n# LOTTO 6/45 : 번호 확인 #\n");
		
		System.out.print("선택한 복권 번호는 [");
		for(i=0; i<6; i++) {
			System.out.print(myLotto[i] + " ");
		}
		System.out.println("] 입니다.");
		
		// Scanner이나 직접 입력 처리
		// 입력 값으로 처리된 객체 생성
		LT1DTO lto1 = new LT1DTO(myLotto, result);
		// Controller만 호출.
		LT1Controller lt1ctrl = new LT1Controller();
		System.out.println("\n# 호출된 화면 #\n");
		System.out.println(lt1ctrl.LT1List2(lto1, new Model()));
		
	}

}
