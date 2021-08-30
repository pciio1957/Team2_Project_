package DONGHANG.EVENT;

import java.util.ArrayList;


public class LTE_DAO{
	public ArrayList<LTE_DTO> eventlist = new  ArrayList<LTE_DTO>();
	public ArrayList<LTE_DTO> eventlist(LTE_DTO sch){
	eventlist.add(new LTE_DTO("6월 공감 퀴즈 이벤트 ","2021-06-01 "," 2021-06-16","복권기금 퀴즈 풀고,스마트탭 선물하세요!"));
	eventlist.add(new LTE_DTO("건전복권문화&도박중독예방 ","2021-05-18 ","2021-05-31","건전한 복권문화로 행복한 가정의 달!"));
	eventlist.add(new LTE_DTO("5월 공감 퀴즈 이벤트 ","2021-05-03 ","2021-05-17","복권기금 퀴즈 풀고,스마트탭 선물하세요!"));
	return eventlist;
	}	
}
