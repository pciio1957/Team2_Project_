package Hyejin_LO1;

import java.util.ArrayList;

public class LO1_Dao {
//DB서버에 접속하여 데이터를 가져올 필요성이 있는때에 사용
//DATABASE ACCESS 필요한 DATA : 
	
//1. DATABASE 검색해준다. ([이 데이터들]을 *******[자바객체]******로 할당하여 전달한다.) 
/*
SELECT NO1, win, instr(win,'1,') 번호순당첨갯수, instr(BOUNUS,'1,') 보너스당첨횟수
FROM LOTO2 
where no1 like '%' || 's' || '%'// 숫자 검색 
and NO1 BETWEEN 960 AND 968 //회차의 최소 및 최대 
ORDER BY 번호순당첨횟수; 

 */
//(1) [1raw]의 객체는 VOdㅔ 담는다 ==> [calss LO1_list]에 담는다. 
//(2) 여러개의 [raw] ===> ArrayList<VO> Arraylist<list>로 만들어준다.
//(3) [리스트형 데이터]를 DAO 객체를 통해서,
//    [입력값]과 [리턴할객체]를 리턴하는 메서드를 정의해주면 된다.   
//(4) 이것들을 자바 객체로 만들어준다. (java객체로 만들어서 DAO에서 할당한다) 
	
	//1. [입력값에 의해서] [처리한 Arraylist를 리턴]해준다. 
	
	public ArrayList<LO1_List> list(SearchNumber s) { //검색내용//DB서버에 넘겨줄 검색데이터 
		ArrayList<LO1_List> winlist = new ArrayList<LO1_List>();//리턴할 Arraylist 
		
		 
		System.out.println("#DB 서버에 넘겨줄 데이터"); //입력받은 검색데이터 
		//public ArrayList<LO1_List> list(SearchNumber s) {
		System.out.println("6자리번호입력 [1]:"+s.getNum01());
		System.out.println("6자리번호입력 [2]:"+s.getNum02());
		System.out.println("6자리번호입력 [3]:"+s.getNum03());
		System.out.println("6자리번호입력 [4]:"+s.getNum04());
		System.out.println("6자리번호입력 [5]:"+s.getNum05());
		System.out.println("6자리번호입력 [6]:"+s.getNum06());

		System.out.println("#DB 서버에서 '온' 데이터리스트# "); 
		//ArrayList<LO1_List> winlist = new ArrayList<LO1_List>();
		winlist.add(new LO1_List (960,20210424,"2, 18, 24, 30, 32, 45",14,2));
		winlist.add(new LO1_List (961,20210501,"11, 20, 29, 31, 33, 42",43,2));
		winlist.add(new LO1_List (962,20210508,"1, 18, 28, 31, 34, 43",40,2));
		winlist.add(new LO1_List (963,20210515,"6, 12, 19, 23, 34, 42",45,2));
		winlist.add(new LO1_List (964,20210525,"6, 21, 36, 38, 39, 43",30,2));
		winlist.add(new LO1_List (965,20210522,"2, 13, 25, 28, 29, 36",34,2));
		winlist.add(new LO1_List (966,20210529,"1, 21, 25, 29, 34, 37",36,2));
		winlist.add(new LO1_List (967,20210612,"1, 6, 13, 37, 38, 40",9,2));

		/*
		System.out.println("회차번호"+"\t"+ "날짜"+"\t"+"\t"+"당첨번호"+"\t"+"\t"+"\t"+"보너스번호"+"\t"+"갯수");
		for(LO1_List s1:winlist) { //출력해주기 (불러온객체) //객체 raw1개씩 출력 
		
			System.out.print(s1.getNum()+"\t");
			System.out.print(s1.getDate()+"\t");
			System.out.print(s1.getWincode()+"\t");
			System.out.print(s1.getBounus()+"\t");
			System.out.print(s1.getCount()+"\n");
		}*/
		
		return winlist;  
	

}
}