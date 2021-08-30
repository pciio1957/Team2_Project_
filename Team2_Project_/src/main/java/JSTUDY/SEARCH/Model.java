package JSTUDY.SEARCH;

// 값과 기능을 가지고 있는 객체, 비즈니스 로직 수행
// 화면에 넘겨줄 임시 모델 객체
public class Model {
	public void addAttribute(String key, Object ob) {
		System.out.println("# 모델 데이터 처리(화면에 전달할 데이터)#");
		System.out.println("Key:"+key);
		System.out.println("객체:"+ob);
		// key 값으로 데이터 넘겨준다.
	}
}
