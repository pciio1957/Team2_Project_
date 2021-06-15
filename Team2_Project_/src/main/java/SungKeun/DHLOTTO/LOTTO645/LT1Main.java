package SungKeun.DHLOTTO.LOTTO645;

import java.util.Scanner;

import SungKeun.DHLOTTO.Model;

public class LT1Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int gen_count = 0;
		int[] myLotto = null;
		int[] result = null;
		int[] lotto = null;
		
		while(gen_count < 6) {
			int ok_generation = 1;
			System.out.printf("[%d] [1-45] 복권 번호 선택 : ", gen_count+1);
			
			int tmp = sc.nextInt();
			
			for(int i = 0; i<6; i++) {
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
		
		// Scanner이나 직접 입력 처리
		// 입력 값으로 처리된 객체 생성
		LT1DTO lto1 = new LT1DTO(lotto, myLotto, result);
		// Controller만 호출.
		LT1Controller lt1ctrl = new LT1Controller();
		System.out.println("\n# 호출된 화면 #\n");
		System.out.println(lt1ctrl.LT1List2(lto1, new Model()));
		
	}	

}
