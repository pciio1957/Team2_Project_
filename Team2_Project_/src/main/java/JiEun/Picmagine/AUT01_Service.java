package JiEun.Picmagine;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import JiEun.Picmagine.vo.Writer;

public class AUT01_Service {
	AUT01_Dao dao = new AUT01_Dao();
	
	
	// 작가 정보 출력
	public String WriterInfo(String wrtno) {
		// dao에서 리스트 받아와서 출력하기 
		System.out.println(" [service] 작가 정보 출력 ");
		
		Writer writer = new Writer();
		
		writer = dao.WriterInfo(wrtno);
		writer.writerInfo();
		
		return "완료";
	}
	
	// 작가 팔로우/팔로잉
	public String followCheck(String memno, String wrtno) {
		System.out.println(" [service] 팔로우 확인 ");
		
		// 팔로우 되어있는지 확인하는 변수~!! 
		boolean isFollower = dao.followCheck(memno, wrtno);
		
		// 팔로우 수 변경 - 증가/감소 
		if(isFollower) {
			// dao.followDelete();
		} else {
			// dao.followInsert();
		}
		
		return "완료";
	}
	
	// 작가의 작품리스트 출력
	public String WorkList(String wrtno) {
		System.out.println(" [service] 작품리스트 출력 ");
		
		dao.WorkList(wrtno);
		
		return "완료";
	}
	
	// 작가 시리즈 출력
	public String SeriesList() {
		System.out.println(" [service] 시리즈 출력 ");
		
		return "완료";
	}

}
