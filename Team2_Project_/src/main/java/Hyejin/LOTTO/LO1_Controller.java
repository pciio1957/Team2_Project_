package Hyejin.LOTTO;

class LO1_Controller { //loto 
	//[화면단]에서 오는 [data]를 받아서 
	//[화면단]에 전달할 데이터를 설정하는 기능 
	
	//화면에서 [입력할데이터]는 무엇인가? controll단에서 받아서 service로 넘겨준다. 
	
	//1.게시판 검색 처리 
	//ex) 받을 물건명: 물건명[  ], 가격 [   ] 검색 
	//ex) 입력받을 번호: 숫자 6자리 [], [], [], [], [], []  [String]  // controller의 매서드 매개변수로 설정 
	
	//입력: 물건명, 가격
	//출력: 물건명리스트
	
	//입력: 검색번호 //[controller] 단의 메서드에 매개변수로 설정해준다. 
	//출력: [회차별], [날짜], [당첨번호], [보너스번호] // 출력할 [model]데이터 객체에 할당 , 마지막 매개변수로 선언 
	
	
	private LO1_Service service = new LO1_Service();
	
	public String lotoSearch(SearchNumber s,LO1_Model d) { //[화면에 넘겨줄] [모델데이터]를 [마지막 매개변수]로 반드시 선언
		System.out.print("#컨트롤에서 받은 데이터#");
		System.out.print(s.getNum01());
		System.out.print(s.getNum02());
		System.out.print(s.getNum03());
		System.out.print(s.getNum04());
		System.out.print(s.getNum05());
		System.out.println(s.getNum06());
	
		
		
		//view 단에서 넘겨줄 데이터 key, object 
		d.addAttribute1("slist", service.list(s));
		
		return "경로/@@@.jsp.";
	}
	}
	


