package PICMAGIN_ART_SEARCH;

import java.util.ArrayList;
import java.util.Scanner;

public class Service_Art {

	private ArrayList<Comment> commentlist = new ArrayList<Comment>();
	private ArrayList<Comment> commentlist2 = new ArrayList<Comment>();
	private ArrayList<Search> searchlist = new ArrayList<Search>();
	private ArrayList<Art> Artlist2 = new ArrayList<Art>();
	private ArrayList<Like> likelist = new ArrayList<Like>();

	Dao_Art dao = new Dao_Art();

//댓글조회 	
	public String commentlist(String sh) {
		commentlist = dao.Alllist(sh);
		System.out.println("[인덱스번호]" + "[댓글번호]" + "[날짜]" + "\t" + "[내용]" + "\t" + "\t" + "[이미지]" + "\t" + "[상위댓글]"
				+ "\t" + "[작가번호]" + "\t" + "[작품번호]" + "/n");

		int listIDX = 1; // 리스트 순서번호
		if (sh.equals("1")) {

			for (Comment c : commentlist) {
				c.Showinfo(listIDX);
				listIDX++;
			}
		}
		return "전체호출완료";
	}

//댓글입력
	public ArrayList<Comment> Comment(Comment com) {

		commentlist2 = dao.Comment(com);

		int listIDX = 1; // 리스트 순서번호
		if (com.equals("")) {

			for (Comment c : commentlist2) {
				c.Showinfo(listIDX);
				listIDX++;
			}

		}
		return Dao_Art.Comment(com);
	}

//검색조건입력 

	public String Artlist(Art search) {
		// System.out.println("[인덱스]"+"번호"+"카테고리"+"작품이미지"+""+"제목"+"소개"+"날짜"+"권한"+"작품번호"+"시리즈번호");

		Artlist2 = dao.ArtList(search);

		for (Art a : Artlist2) {
			a.ShowInfo();
		}

		return "검색관련호출완료";

	}
//좋아요 증가처리 

	public String likeup(Like likecheck2) {
		likelist = dao.likeadd(likecheck2);
		System.out.println("좋아요를 클릭했습니다.");
		int listIDX = 1; // 리스트 순서번호
		for (Like l : likelist) {
			l.Tostring(listIDX);
			listIDX++;
		}
		return "";
	}

//좋아요 감소처리 
	public String likedown(Like likecheck2) {

		System.out.println("좋아요를 취소했습니다.");
		System.out.println("좋아요 수:");
		likelist = dao.likedown(likecheck2);
		int listIDX = 1; // 리스트 순서번호
		for (Like l : likelist) {
			l.Tostring(listIDX);
			listIDX++;
		}
		return "";
	}

//좋아요 조회
	public String likelist(String artwork) {
		dao.likeList(artwork);

		return "";
	}
}