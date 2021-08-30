package DONGHANG.EVENT;

import java.util.Scanner;

public class LTE_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		LTE_DTO dto = new LTE_DTO("6월 공감 퀴즈 이벤트","2021-06-01",
				"2021-06-16","복권기금 퀴즈 풀고,스마트탭 선물하세요!");
				
		LTE_CONTROLLER ob = new LTE_CONTROLLER();
		System.out.println("** 동행복권 - 이벤트 **");
		System.out.println(ob.schList2(dto,new LTE_Model()));
	}
}
