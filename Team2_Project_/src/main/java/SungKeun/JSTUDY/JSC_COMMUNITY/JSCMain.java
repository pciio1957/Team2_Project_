package SungKeun.JSTUDY.JSC_COMMUNITY;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import SungKeun.JSTUDY.Model;

public class JSCMain {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JSCMain cin = new JSCMain();
//		cin.main(args); // 처음으로 이동
		Scanner sc = new Scanner(System.in);
		
		String writer; // 작성자
		String headLine; // 게시물 제목
		String write; // 게시물 작성 내용
		Calendar cal = Calendar.getInstance(); // 작성일
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//		System.out.println("프로그램 구동 시간 : " + dateFormat.format(cal.getTime()));
		
		// JSTUDY 커뮤니티 - 메인 메뉴
		System.out.println("\n===============================================");
        System.out.println("\n## JSTUDY 커뮤니티 ## \n");
        String mainMenu; // 커뮤니티 - 메인 메뉴 선택
        System.out.println("[1] 자유 게시판 [2] 스터디 [3] 질문 답변 [4] 커뮤니티 \n");
        System.out.print(" -> [메인] 메뉴를 선택하세요 : ");
        mainMenu = sc.nextLine();
        
        if(mainMenu.equals("1")) {
            // JSTUDY 커뮤니티 - 자유 게시판 메뉴
        	System.out.println("\n===============================================");
            System.out.println("\n## JSTUDY 커뮤니티 - 자유 게시판 ## \n");
            String freeMenu; // 커뮤니티 - 자유 게시판 메뉴 선택
            System.out.println("[1] 게시물 확인 [2] 게시물 글쓰기 [0] 커뮤니티 \n");
            System.out.print(" -> [자유 게시판] 메뉴를 선택하세요 : ");
            freeMenu = sc.nextLine();
            
            if(freeMenu.equals("1")) {
            	ArrayList<JSCDTO> jscflist  = new ArrayList<JSCDTO>();
                // JSTUDY 커뮤니티 - 자유 게시판 메뉴 -> 게시물 확인
            	System.out.println("\n===============================================");
        		System.out.println("## JSTUDY 커뮤니티 [자유 게시판] -> 게시물 확인 ## \n");
        		System.out.println("전체 게시물 정보 여부 : " + jscflist.isEmpty());
        		System.out.println("전체 게시물 정보 수량 : " + jscflist.size()); // 전체 게시물 정보 수
            } else if(freeMenu.equals("2")) {
            	ArrayList<JSCDTO> jscflist  = new ArrayList<JSCDTO>();
        		// JSTUDY 커뮤니티 - 자유 게시판 메뉴 -> 게시물 글쓰기
            	System.out.println("\n===============================================");
        		System.out.println("## JSTUDY 커뮤니티 [자유 게시판] -> 게시물 글쓰기 ## \n");
        		System.out.print(" 작성자 : ");
        		writer = sc.nextLine();
        		System.out.print(" 제목 : ");
        		headLine = sc.nextLine();
        		System.out.print(" 내용 : ");
        		write = sc.nextLine();
        		System.out.println(" * 해당 게시물이 등록되었습니다! * \n");
        		System.out.println("# JSTUDY 커뮤니티 [자유 게시판] -> 게시물 등록 완료!");
        		int freewriteNum = 6; // 자유 게시판 게시물 번호
        		System.out.println(" | No." + freewriteNum++ + " | 작성자 : " + writer + " | 제목 : " + headLine + " | 작성일 : " + dateFormat.format(cal.getTime()) + "\n [ 작성 내용 ] \n" + " [ " + write + " ] ");
        		// 자유 게시판
        		JSCDTO jcof1 = new JSCDTO();
        		jscflist.add(new JSCDTO(jcof1.getWriteNum(), jcof1.getHeadLine(), jcof1.getWriter(), jcof1.getWriteDate(), jcof1.getWrite()));
        		// Controller만 호출.
        		JSCController jscfctrl = new JSCController();
        		System.out.println("\n# 호출된 화면 #\n");
        		System.out.println(jscfctrl.JSCFList2(jcof1, new Model()));
        		
            } else if(freeMenu.equals("0")) {
            	System.out.println("\n커뮤니티 메인으로 이동합니다.");
            	cin.main(args);
            } else {
            	System.out.println("\n잘못 입력 하셨습니다, 처음으로 이동합니다.");
            	cin.main(args);
            }
            
        } else if(mainMenu.equals("2")) {
            // JSTUDY 커뮤니티 - 스터디 메뉴
        	System.out.println("\n===============================================");
            System.out.println("\n## JSTUDY 커뮤니티 - 스터디 ## \n");
            String studyMenu; // 커뮤니티 - 스터디 메뉴 선택
            System.out.println("[1] 게시물 확인 [2] 게시물 글쓰기 [0] 커뮤니티 \n");
            System.out.print(" -> [스터디] 메뉴를 선택하세요 : ");
            studyMenu = sc.nextLine();
            
            if(studyMenu.equals("1")) {
            	ArrayList<JSCDTO> jscslist  = new ArrayList<JSCDTO>();
                // JSTUDY 커뮤니티 - 스터디 메뉴 -> 게시물 확인
            	System.out.println("\n===============================================");
        		System.out.println("## JSTUDY 커뮤니티 [스터디] -> 게시물 확인 ## \n");
        		System.out.println("전체 게시물 정보 여부 : " + jscslist.isEmpty());
        		System.out.println("전체 게시물 정보 수량 : " + jscslist.size()); // 전체 게시물 정보 수
            } else if(studyMenu.equals("2")) {
            	ArrayList<JSCDTO> jscslist  = new ArrayList<JSCDTO>();
        		// JSTUDY 커뮤니티 - 스터디 메뉴 -> 게시물 글쓰기
            	System.out.println("\n===============================================");
        		System.out.println("## JSTUDY 커뮤니티 [스터디] -> 게시물 글쓰기 ## \n");
        		System.out.print(" 작성자 : ");
        		writer = sc.nextLine();
        		System.out.print(" 제목 : ");
        		headLine = sc.nextLine();
        		System.out.print(" 내용 : ");
        		write = sc.nextLine();
        		System.out.println(" * 해당 게시물이 등록되었습니다! * \n");
        		System.out.println("# JSTUDY 커뮤니티 [스터디] -> 게시물 등록 완료!");
        		int studywriteNum = 3; // 스터디 게시물 번호
        		System.out.println(" | No." + studywriteNum++ + " | 작성자 : " + writer + " | 제목 : " + headLine + " | 작성일 : " + dateFormat.format(cal.getTime()) + "\n [ 작성 내용 ] \n" + " [ " + write + " ] ");
        		// 스터디
        		JSCDTO jcos1 = new JSCDTO();
        		jscslist.add(new JSCDTO(jcos1.getWriteNum(), jcos1.getHeadLine(), jcos1.getWriter(), jcos1.getWriteDate(), jcos1.getWrite()));
        		// Controller만 호출.
        		JSCController jscsctrl = new JSCController();
        		System.out.println("\n# 호출된 화면 #\n");
        		System.out.println(jscsctrl.JSCSList2(jcos1, new Model()));
        	} else if(studyMenu.equals("0")) {
        		System.out.println("\n커뮤니티 메인으로 이동합니다.");
            	cin.main(args);
            } else {
            	System.out.println("\n잘못 입력 하셨습니다, 처음으로 이동합니다.");
            	cin.main(args);
            }
                        
        } else if(mainMenu.equals("3")) {
            // JSTUDY 커뮤니티 - 질문 답변 게시판 메뉴
        	System.out.println("\n===============================================");
            System.out.println("\n## JSTUDY 커뮤니티 - 질문 답변 게시판 ## \n");
            String qnaMenu; // 커뮤니티 - 질문 답변 메뉴 선택
            System.out.println("[1] 게시물 확인 [2] 게시물 글쓰기 [0] 커뮤니티 \n");
            System.out.print(" -> [질문 답변] 메뉴를 선택하세요 : ");
            qnaMenu = sc.nextLine();
            
            if(qnaMenu.equals("1")) {
            	ArrayList<JSCDTO> jscqlist  = new ArrayList<JSCDTO>();
                // JSTUDY 커뮤니티 - 질문 답변 메뉴 -> 게시물 확인
            	System.out.println("\n===============================================");
        		System.out.println("## JSTUDY 커뮤니티 [질문 답변] -> 게시물 확인 ## \n");
        		System.out.println("전체 게시물 정보 여부 : " + jscqlist.isEmpty());
        		jscqlist.add(new JSCDTO(6, "반갑습니다!", "홍시", "2021/06/26 22:08:22" ,"홈페이지 제작 처음입니다!"));
        		jscqlist.add(new JSCDTO(5, "너무 좋은 사이트네요ㅎㅎ", "himan","2021/06/26 19:12:36", "저는 현직 개발자입니다!"));
        		jscqlist.add(new JSCDTO(4, "ㅎㅇ", "cool","2021/06/26 19:08:17", "ㅎㅇㅎㅇ"));
        		jscqlist.add(new JSCDTO(3, "여기는 뭐하는 곳이죠??", "byeman","2021/06/25 23:46:11", "처음이라 잘 부탁드려요..ㅎㅎㅎ"));
        		jscqlist.add(new JSCDTO(2, "오 드디어 오픈이네요!", "강남살아요","2021/06/25 20:18:02", "배우러 왔습니다!"));
        		jscqlist.add(new JSCDTO(1, "안녕하세요!", "홍길동","2021/06/25 17:11:53", "잘 부탁드려요~"));
        		System.out.println("전체 게시물 정보 수량 : " + jscqlist.size()); // 전체 게시물 정보 수
            } else if(qnaMenu.equals("2")) {
            	ArrayList<JSCDTO> jscqlist  = new ArrayList<JSCDTO>();
        		// JSTUDY 커뮤니티 - 질문 답변 메뉴 -> 게시물 글쓰기
            	System.out.println("\n===============================================");
        		System.out.println("## JSTUDY 커뮤니티 [질문 답변] -> 게시물 글쓰기 ## \n");
        		System.out.print(" 작성자 : ");
        		writer = sc.nextLine();
        		System.out.print(" 제목 : ");
        		headLine = sc.nextLine();
        		System.out.print(" 내용 : ");
        		write = sc.nextLine();
        		System.out.println(" * 해당 게시물이 등록되었습니다! * \n");
        		System.out.println("# JSTUDY 커뮤니티 [질문 답변] -> 게시물 등록 완료!");
        		int qnawriteNum = 3; // 질문 답변 게시물 번호
        		System.out.println(" | No." + qnawriteNum + " | 작성자 : " + writer + " | 제목 : " + headLine + " | 작성일 : " + dateFormat.format(cal.getTime()) + "\n [ 작성 내용 ] \n" + " [ " + write + " ] ");
        		// 질문 답변

        		// Controller만 호출.
        		JSCController jscqctrl = new JSCController();
        		System.out.println("\n# 호출된 화면 #\n");
        		JSCDTO jcoq1 = new JSCDTO();
        		jscqlist.add(new JSCDTO(jcoq1.getWriteNum(), jcoq1.getHeadLine(), jcoq1.getWriter(), jcoq1.getWriteDate(), jcoq1.getWrite()));
        		System.out.println(jscqctrl.JSCQList2(jcoq1, new Model()));
        	} else if(qnaMenu.equals("0")) {
            	System.out.println("\n커뮤니티 메인으로 이동합니다.");
            	cin.main(args);
            } else {
            	System.out.println("\n잘못 입력 하셨습니다, 처음으로 이동합니다.");
            	cin.main(args);
            }
            
        } else if(mainMenu.equals("4")) {
        	// JSTUDY 커뮤니티 - 메인 메뉴 복귀
        	System.out.println("\n메인 메뉴로 이동합니다.");
        	cin.main(args);
        } else {
        	System.out.println("\n잘못 입력 하셨습니다, 처음으로 이동합니다.");
        	cin.main(args);
        }
        
//      // 기존
//		JSCDTO jcoo1 = new JSCDTO();
//		// Controller만 호출.
//		JSCController jscctrl = new JSCController();
//		System.out.println("\n# 호출된 화면 #\n");
//		System.out.println(jscctrl.JSCList2(jcoo1, new Model()));
		
		cin.main(args);

	}
}
