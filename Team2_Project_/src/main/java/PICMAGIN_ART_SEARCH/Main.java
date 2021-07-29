package PICMAGIN_ART_SEARCH;

import java.util.Scanner;


public class Main {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Controller_Art controller = new Controller_Art();
		Service_Art Service = new Service_Art();

		// 사용자에게서 입력받기 위한 [입력함수 선언]
		Scanner scan = new Scanner(System.in);

		// 0. 화면(선택기능)
		while (true) {
			System.out.println("##PICMAGIN 댓글 조회 ##");
			System.out.println("[1]댓글 전체조회 [2] 댓글작성 및 저장 [3] 작품검색 [4]좋아요/취소");
		
			String sh = scan.nextLine();

			// 1. 댓글 조회 선택 
			if (sh.equals("1")) {
				// 댓글 목록 호출 
				System.out.println("===========================[A작품의 댓글목록]==========================");
				controller.commentlist1(sh, new Model());
				
			   
			}
			
			//=================================================================================================================
		
			else if (sh.equals("2")) {
				System.out.println("===========================[댓글을 입력하세요])========================");
			
				String ccomentcode = "CO40001(자동입력)";
				System.out.println("날짜입력");
				String date1 = scan.nextLine();
				System.out.println("내용입력");
				String content = scan.nextLine();
				String cimg = "url";
				String ccomentcode2 = "CO40001(자동입력)";
				int anum = 00001;
				String art = "A00001";
			
			    controller.Comment(new Comment(ccomentcode, date1, content, cimg,ccomentcode2, anum,art), new Model());
				}
			
			
			else if(sh.equals("3")) {
				System.out.println("===========================[검색어를 입력하세요]=======================");
				System.out.println("[카테고리선택],[날짜],[시리즈여부]");
		
				Art artlist = new Art("photo", 1,1);
				controller.searchlist(artlist,new Model());
			}
		
	
			else if (sh.equals("4")) {
				//1. 좋아요조회 (작품명입력)
				String artwork="AW00001";
				controller.likelist(artwork,new Model());
				
				System.out.println("좋아요클릭[0] | 좋아요취소[1]");
				
				String likecheck1 = scan.nextLine();
				
					if(likecheck1.equals("0")) {
						Like likecheck2 = new Like("사고싶어요",0000021,"AW00001");
						controller.likeup(likecheck2, new Model());
					
					}
					else if (likecheck1.equals("1")) {
						Like likecheck2 = new Like("사고싶어요",0000021,"AW00001");
						controller.likedown(likecheck2, new Model());
					
					
					}else if (likecheck1.equals("2")) {
					
				continue;
			}
			}
		}
	}
}

	