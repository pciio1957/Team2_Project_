package DeokJae;

public class DPR1Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		DPR1Recharge dr1 = new DPR1Recharge("복권 예치금","5000원","동행복권_홍길동");
		DPR1Controller dpr1ctrl = new DPR1Controller();
		System.out.println("#호출된 화면#");
		System.out.println(dpr1ctrl.DPR1List2(dr1, new Model()));
		
		
		
		
//		System.out.println("예치금 잔액");
//		prCon.showDeposit(mp, m);
//		
//		System.out.println("예치금 사용내역");
//		prCon.showDepositUsed(mp, m);
//		
//		System.out.println("예치금 구매");
//		prCon.buyDeposit(mp, m);
//		System.out.println(예치금 환불);
//		prCon.refunDeposit(mp, m);
		
		// showDeposit showDepositUsed: 예치금 잔액조회, 예치금 사용내역
		// buyDeposit, refundDeposit : 예치금 구매, 예치금 환불
		
	}

}
