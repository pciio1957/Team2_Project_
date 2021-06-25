package SungKeun.JSTUDY.JSC_COMMUNITY;

import java.util.ArrayList;

public class JSCService {
	JSCDAO jscdao = new JSCDAO();
	public ArrayList<JSCDTO> JSCList(JSCDTO jcoo1) {
		
		System.out.println("===============================================\n");
		System.out.println("# Service #\n");
//		DAO로 데이터를 넘기기 위한 확인 과정
//		게시물 번호, 제목, 작성자, 작성일, 작성 내용
		System.out.println("JSCDAO에 전송 할 게시물 번호 데이터 1 : " + jcoo1.getWriteNum() + "\n");
		System.out.println("JSCDAO에 전송 할 게시물 제목 데이터 2 : " + jcoo1.getHeadLine() + "\n");
		System.out.println("JSCDAO에 전송 할 게시물 작성자 데이터 3 : " + jcoo1.getWriter() + "\n");
		System.out.println("JSCDAO에 전송 할 게시물 작성일 데이터 4 : " + jcoo1.getWriteDate() + "\n");
		System.out.println("JSCDAO에 전송 할 게시물 작성 내용 데이터 5 : " + jcoo1.getWrite() + "\n");
//		System.out.println("JSCDAO에서 받을 복권 입력 데이터 크기 : " + jscdao.JSCList(jcoo1).size() + "\n");
		return jscdao.JSCList(jcoo1);
	}

}
