package Hyejin.LOTTO;

public class LO1_Model {
	


public void addAttribute1(String key, Object ob) {
	System.out.println("#model 데이터처리#"); 
	System.out.println("#화면에 전달할 데이터"); 
	System.out.println("로또 당첨 리스트");
	
	
	//화면에 보여줄 데이터 
	//나는화면에 이 모델데이터를 넘기겠습니다. 
	// 실제화면에 넘겨줄때 처리하는 것
	
	//받아온 값을 화면에 넘겨주는 것 -> jsp화면에서 처리해주는 것.
	
	System.out.println(key+":키값:질문내역결과(회차, 당첨일, 당첨번호, 보너스번호)");
	System.out.println(ob+" : 3개");
}
}