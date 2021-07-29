package JiEun.Picmagine;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import JiEun.Picmagine.vo.Artist;

public class AUT01_Service {
	AUT01_Dao dao = new AUT01_Dao();
	static boolean isFollower = false;
	
	
	// 작가 정보 출력
	public String writerInfo(String artno) {
		System.out.println(" [service] 작가 정보 출력 ");
		
		Artist artist = new Artist();
		artist = dao.writerInfo(artno);
		artist.ArtistInfo();
		
		return "완료";
	}
	
	// 작가의 팔로우 정보 확인
	public String followCheck(String artno) {
		System.out.println(" [service] 팔로잉 확인 ");
		
		dao.followCheck(artno);
		return "완료";
	}
	
	// 작가 팔로워 확인 후 증감
	public String followerCheck(String memno, String artno) {
		System.out.println(" [service] 팔로워 확인 ");
		
		// 팔로우 되어있는지 확인하는 변수~!! 
		isFollower = dao.followerCheck(memno, artno);
		
		System.out.println(" <팔로우 여부 확인> ");
		// 팔로우 수 변경 - 증가/감소 
		if(isFollower) {
			dao.followDown(memno, artno);
			System.out.println(" -> O : 팔로우 되어있습니다\n ");
		} else {
			dao.followUp(memno, artno);
			System.out.println(" -> X : 팔로우 되어있지 않습니다\n ");
		}
		
		return "완료";
	}
	
	
	// 작가의 작품리스트 출력
	public String workList(String artno) {
		System.out.println(" [service] 작품리스트 출력 ");
		
		dao.workList(artno);
		return "완료";
	}
	
	// 작가 시리즈+작품내용 출력
	public String seriesList(String artno) {
		System.out.println(" [service] 시리즈 출력 ");
		
		dao.seriesList(artno);
		return "완료";
	}

}
