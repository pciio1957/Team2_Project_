package DaEun.FAQ;

import java.util.ArrayList;

public class FAQ_DAO {
	public ArrayList<FAQ_DTO> flist= new ArrayList<FAQ_DTO>();
	public ArrayList<FAQ_DTO> flist(FAQ_DTO dto1){
		flist.add(new FAQ_DTO("강의 담기", "강의를 담는 방법 : 강의 목록을 간다"));
		flist.add(new FAQ_DTO("강의 구매하기", "강의를 편하게 구매하는 방법"));
		return flist;
		
	}
}
