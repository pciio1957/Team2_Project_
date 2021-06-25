package SungKeun.JSTUDY.JSC_COMMUNITY;

import java.util.ArrayList;

public class JSCDAO {
	public ArrayList<JSCDTO> JSCList(JSCDTO jcoo1) {
		ArrayList<JSCDTO> jsclist  = new ArrayList<JSCDTO>();
		jsclist.add(new JSCDTO(jcoo1.getWriteNum(), jcoo1.getHeadLine(), jcoo1.getWriter(), jcoo1.getWriteDate(), jcoo1.getWrite()));
		
	    // 전체 복권 입력 데이터를 확인하기 위한 메소드
		System.out.println("===============================================\n");
		System.out.println("# DB 서버에 넘겨 줄 게시물 정보 데이터 #\n");
		System.out.println("게시물 번호 : " + jcoo1.getWriteNum() + "\n");
		System.out.println("게시물 제목 : " + jcoo1.getHeadLine() + "\n");
		System.out.println("게시물 작성자 : " + jcoo1.getWriter() + "\n");
		System.out.println("게시물 작성일 : " + jcoo1.getWriteDate() + "\n");
		System.out.println("게시물 작성 내용 : " + jcoo1.getWrite() + "\n");
		System.out.println("===============================================\n");
		System.out.println("# DB 서버에서 온 게시물 정보 데이터 리스트 #\n");
		// 게시물 번호, 제목, 작성자, 작성일, 작성 내용
		jsclist.add(new JSCDTO(6, "반갑습니다!", "홍시", 20210626, "홈페이지 제작 처음입니다!"));
		jsclist.add(new JSCDTO(5, "너무 좋은 사이트네요ㅎㅎ", "himan", 20210626, "저는 현직 개발자입니다!"));
		jsclist.add(new JSCDTO(4, "ㅎㅇ", "cool", 20210626, "ㅎㅇㅎㅇ"));
		jsclist.add(new JSCDTO(3, "여기는 뭐하는 곳이죠??", "byeman", 20210625, "처음이라 잘 부탁드려요..ㅎㅎㅎ"));
		jsclist.add(new JSCDTO(2, "오 드디어 오픈이네요!", "강남살아요", 20210625, "배우러 왔습니다!"));
		jsclist.add(new JSCDTO(1, "안녕하세요!", "홍길동", 20210625, "잘 부탁드려요~"));
		System.out.println("===============================================\n");
		
		return jsclist;
	}
}
