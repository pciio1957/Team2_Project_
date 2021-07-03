package SungKeun.JSTUDY.JSC_COMMUNITY;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import SungKeun.JSTUDY.Model;
import SungKeun.JSTUDY.JSQ_QUIZ.JSQController;
import SungKeun.JSTUDY.JSQ_QUIZ.JSQDTO;

public class JSCMain {
		
	static JSQDTO jq = new JSQDTO(); // 퀴즈 문제에 대한 객체를 전역 변수로 선언
	static JSQDTO ja = new JSQDTO(); // 퀴즈 정답에 대한 객체를 전역 변수로 선언
	
	static ArrayList<JSCDTO> jscflist = new ArrayList<JSCDTO>();
	static ArrayList<JSCDTO> jscslist = new ArrayList<JSCDTO>();
	static ArrayList<JSCDTO> jscqlist = new ArrayList<JSCDTO>();
	static ArrayList<JSQDTO> jsqlist = new ArrayList<JSQDTO>();
	
	public static void main(String[] args) {
		
		JSCMain cin = new JSCMain();
//		cin.main(args); // 처음으로 이동
		Scanner sc = new Scanner(System.in);
		
		String writer; // 작성자
		String headLine; // 게시물 제목
		String write; // 게시물 작성 내용
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); // 작성일
//		System.out.println("프로그램 구동 시간 : " + dateFormat.format(cal.getTime()));
		
		String quest; // 문제
		String usrAns; // 유저 정답
		String answer; // 정답
		
		String admin; // 관리자 ID
		String adminPw; // 관리자 PW
		
		// JSTUDY 커뮤니티 - 메인 메뉴
		System.out.println("\n===============================================");
        System.out.println("\n## JSTUDY 커뮤니티 ## \n");
        String mainMenu; // 커뮤니티 - 메인 메뉴 선택
        System.out.println("[1] 자유 게시판 [2] 스터디 [3] 질문 답변 [4] QUIZ [0] 커뮤니티 \n");
        System.out.print(" -> [메인] 메뉴를 선택하세요 : ");
        mainMenu = sc.nextLine();
        
        if(mainMenu.equals("1")) {
        	while(true) {
                // JSTUDY 커뮤니티 - 자유 게시판 메뉴
            	System.out.println("\n===============================================");
                System.out.println("\n## JSTUDY 커뮤니티 - 자유 게시판 ## \n");
                String freeMenu; // 커뮤니티 - 자유 게시판 메뉴 선택
                System.out.println("[1] 게시물 확인 [2] 게시물 글쓰기 [0] 커뮤니티 \n");
                System.out.print(" -> [자유 게시판] 메뉴를 선택하세요 : ");
                freeMenu = sc.nextLine();
                
                if(freeMenu.equals("1")) {
                    // JSTUDY 커뮤니티 - 자유 게시판 메뉴 -> 게시물 확인
                	System.out.println("\n===============================================");
            		System.out.println("## JSTUDY 커뮤니티 [자유 게시판] -> 게시물 확인 ## \n");
            		System.out.println("전체 게시물 정보 여부 : " + jscflist.isEmpty());
            		jscflist.add(new JSCDTO(6, "반갑습니다!", "홍시", "2021/06/26 22:08:22" ,"홈페이지 제작 처음입니다!"));
            		jscflist.add(new JSCDTO(5, "너무 좋은 사이트네요ㅎㅎ", "himan","2021/06/26 19:12:36", "저는 현직 개발자입니다!"));
            		jscflist.add(new JSCDTO(4, "ㅎㅇ", "cool","2021/06/26 19:08:17", "ㅎㅇㅎㅇ"));
            		jscflist.add(new JSCDTO(3, "여기는 뭐하는 곳이죠??", "byeman","2021/06/25 23:46:11", "처음이라 잘 부탁드려요..ㅎㅎㅎ"));
            		jscflist.add(new JSCDTO(2, "오 드디어 오픈이네요!", "강남살아요","2021/06/25 20:18:02", "배우러 왔습니다!"));
            		jscflist.add(new JSCDTO(1, "안녕하세요!", "홍길동","2021/06/25 17:11:53", "잘 부탁드려요~"));
            		System.out.println("전체 게시물 정보 수량 : " + jscflist.size()); // 전체 게시물 정보 수
            		
                } else if(freeMenu.equals("2")) {
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
            		JSCDTO jcof1 = new JSCDTO(freewriteNum++, headLine,
            				writer, dateFormat.format(cal.getTime()), write); // 해당 클래스에서 입력한 변수를 저장
            		ArrayList<JSCDTO> jscflist  = new ArrayList<JSCDTO>();
            		jscflist.add(new JSCDTO(freewriteNum++, headLine,
            				writer, dateFormat.format(cal.getTime()), write));
            		// Controller만 호출.
            		JSCController jscfctrl = new JSCController();
            		System.out.println("\n# Program On #\n");
            		System.out.println(jscfctrl.JSCFList2(jcof1, new Model()));
            		
                } else if(freeMenu.equals("0")) {
                	System.out.println("\n커뮤니티 메인으로 이동합니다.");
                	cin.main(args);
                } else {
                	System.out.println("\n잘못 입력 하셨습니다, 처음으로 이동합니다.");
                	cin.main(args);
                }        		
        	}
            
        } else if(mainMenu.equals("2")) {
        	while(true) {
                // JSTUDY 커뮤니티 - 스터디 메뉴
            	System.out.println("\n===============================================");
                System.out.println("\n## JSTUDY 커뮤니티 - 스터디 ## \n");
                String studyMenu; // 커뮤니티 - 스터디 메뉴 선택
                System.out.println("[1] 게시물 확인 [2] 게시물 글쓰기 [0] 커뮤니티 \n");
                System.out.print(" -> [스터디] 메뉴를 선택하세요 : ");
                studyMenu = sc.nextLine();
                
                if(studyMenu.equals("1")) {
                    // JSTUDY 커뮤니티 - 스터디 메뉴 -> 게시물 확인
                	System.out.println("\n===============================================");
            		System.out.println("## JSTUDY 커뮤니티 [스터디] -> 게시물 확인 ## \n");
            		System.out.println("전체 게시물 정보 여부 : " + jscslist.isEmpty());
            		jscslist.add(new JSCDTO(3, "HTML 대망의 첫 강의", "hihihi","2021/06/26 14:46:12", "파고들면 쉽습니다!"));
            		jscslist.add(new JSCDTO(2, "오라클 설정방법", "DB를누벼라","2021/06/26 09:22:12", "깔끔하게 정리해봤습니다."));
            		jscslist.add(new JSCDTO(1, "JAVA 첫 시작! 1강입니다.", "자바를잡으러","2021/06/25 20:12:55", "첫 강의영상입니다! 도움이 되셨으면 좋겠네요~"));
            		System.out.println("전체 게시물 정보 수량 : " + jscslist.size()); // 전체 게시물 정보 수
                } else if(studyMenu.equals("2")) {
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
            		JSCDTO jcos1 = new JSCDTO(studywriteNum++, headLine, writer, dateFormat.format(cal.getTime()), write);
            		// Controller만 호출.
            		JSCController jscsctrl = new JSCController();
            		System.out.println("\n# Program On #\n");
            		System.out.println(jscsctrl.JSCSList2(jcos1, new Model()));
            	} else if(studyMenu.equals("0")) {
            		System.out.println("\n커뮤니티 메인으로 이동합니다.");
                	cin.main(args);
                } else {
                	System.out.println("\n잘못 입력 하셨습니다, 처음으로 이동합니다.");
                	cin.main(args);
                }        		
        	}
                        
        } else if(mainMenu.equals("3")) {
        	while(true) {
                // JSTUDY 커뮤니티 - 질문 답변 게시판 메뉴
            	System.out.println("\n===============================================");
                System.out.println("\n## JSTUDY 커뮤니티 - 질문 답변 게시판 ## \n");
                String qnaMenu; // 커뮤니티 - 질문 답변 메뉴 선택
                System.out.println("[1] 게시물 확인 [2] 게시물 글쓰기 [0] 커뮤니티 \n");
                System.out.print(" -> [질문 답변] 메뉴를 선택하세요 : ");
                qnaMenu = sc.nextLine();
                
                if(qnaMenu.equals("1")) {
                    // JSTUDY 커뮤니티 - 질문 답변 메뉴 -> 게시물 확인
                	System.out.println("\n===============================================");
            		System.out.println("## JSTUDY 커뮤니티 [질문 답변] -> 게시물 확인 ## \n");
            		System.out.println("전체 게시물 정보 여부 : " + jscqlist.isEmpty());
            		jscqlist.add(new JSCDTO(3, "DB 질문이요", "byeman","2021/06/26 23:55:55", "이클립스랑 오라클 연결 어떻게 해요?"));
            		jscqlist.add(new JSCDTO(2, "자바 관련 질문입니다.", "어려운취준생","2021/06/25 18:08:45", "C언어랑 연관있나요?"));
            		jscqlist.add(new JSCDTO(1, "뭐하는 사이트에요?", "여긴어디지","2021/06/25 12:16:25", "사이트 주제를 모르겠어요.."));
            		System.out.println("전체 게시물 정보 수량 : " + jscqlist.size()); // 전체 게시물 정보 수
                } else if(qnaMenu.equals("2")) {
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
            		System.out.println(" | No." + qnawriteNum++ + " | 작성자 : " + writer + " | 제목 : " + headLine + " | 작성일 : " + dateFormat.format(cal.getTime()) + "\n [ 작성 내용 ] \n" + " [ " + write + " ] ");
            		// 질문 답변

            		// Controller만 호출.
            		JSCController jscqctrl = new JSCController();
            		System.out.println("\n# Program On #\n");
            		JSCDTO jcoq1 = new JSCDTO(qnawriteNum++, headLine, writer, dateFormat.format(cal.getTime()), write);
//            		jscqlist.add(new JSCDTO(jcoq1.getWriteNum(), jcoq1.getHeadLine(), jcoq1.getWriter(), jcoq1.getWriteDate(), jcoq1.getWrite()));
            		System.out.println(jscqctrl.JSCQList2(jcoq1, new Model()));
            	} else if(qnaMenu.equals("0")) {
                	System.out.println("\n커뮤니티 메인으로 이동합니다.");
                	cin.main(args);
                } else {
                	System.out.println("\n잘못 입력 하셨습니다, 처음으로 이동합니다.");
                	cin.main(args);
                }      		
        	}

        } else if(mainMenu.equals("4")) {
        	while(true) {
        		// JSTUDY 커뮤니티 - JSTUDY Quiz
        		System.out.println("\n===============================================");
                System.out.println("\n## JSTUDY 커뮤니티 - QUIZ ## \n");
                String quizMenu; // 커뮤니티 - Weekly Quiz 메뉴 선택
                System.out.println("[1] 관리자 모드 [2] QUIZ 시작 [0] 커뮤니티 \n");
                System.out.print(" -> [JSTUDY Quiz] 메뉴를 선택하세요 : ");
                quizMenu = sc.nextLine();
               
                if(quizMenu.equals("1")) {
            		// JSTUDY 커뮤니티 - Quiz 메뉴 -> (관리자) 문제 및 정답 설정
                	System.out.println("\n===============================================");
                	System.out.println("\n## JSTUDY 커뮤니티 [JSTUDY Quiz] -> 관리자 모드 ## \n");
                	System.out.println("## JSTUDY 커뮤니티 [JSTUDY Quiz] : 관리자 정보를 입력하세요. ## \n");
                	
                	// 관리자 로그인
                	System.out.print("Admin : ");
                	admin = sc.nextLine();
                	System.out.print("AdminPw : ");
                	adminPw = sc.nextLine();
                	
                	if(admin.equals("ysk2388") && adminPw.equals("7777")) {
                		// 관리자 정보가 일치할 때
                		System.out.println(" -> [ " + admin + " ] 님 로그인 되었습니다.\n");
                		
                		// 문제 설정
                		System.out.println("## 설정 할 문제를 입력하세요. ## \n");
            			System.out.print(" -> 설정 할 문제 : ");
            			quest = sc.nextLine();
            			System.out.println("\n## 설정 된 문제 정보 ## \n");
                		System.out.print(" -> 입력 된 문제 : " + quest + "\n");
                		jq.setQuest(quest);

                		// 정답 설정
                		System.out.println("\n## 설정 할 정답을 입력하세요. ## \n");
                		System.out.print(" -> 설정 할 정답 : ");
                		answer = sc.nextLine();
                		System.out.println("\n## 설정 된 정답 정보 ## \n");
                		System.out.print(" -> 입력 된 정답 : " + answer + "\n");
                		ja.setAnswer(answer);
                		
                		// 종합 = 문제 + 정답
                		System.out.println("\n## 설정 된 퀴즈 정보 ## \n");
//                		jsqlist.add(new JSQDTO(jq.getQuest(), ja.getAnswer()));
                		System.out.print(" | 문제 | " + jq.getQuest() + "\t");
        				System.out.print(" | 정답 | " + ja.getAnswer() + "\n");
                		System.out.println("\n");
                		
                	} else {
                		// 관리자 정보가 일치하지 않을 때
                		System.out.println(" -> 관리자 정보가 일치하지 않습니다.\n");
                	}
            		
                } else if(quizMenu.equals("2")) {
                    // JSTUDY 커뮤니티 - JSTUDY Quiz 메뉴 -> QUIZ 시작
                	System.out.println("\n===============================================");
            		System.out.println("## JSTUDY 커뮤니티 [JSTUDY Quiz] 에 오신 것을 환영 합니다! ## \n");
            		
            		// 문제 출제
            		System.out.println("## 해당 문제를 보고 답을 입력하세요. ## \n");
            		System.out.println(" -> 문제 : " + jq.getQuest());
            		
            		// 정답 입력
             		System.out.print("\n -> 답안 : ");
        			usrAns = sc.nextLine();
        			System.out.println("\n## 유저가 입력 한 답안 정보 ## \n");
            		System.out.print(" -> 유저 답안 : " + usrAns + "\n");
            		
            		// 정답 판단
                	if(usrAns.equals(ja.getAnswer())) {
                		System.out.println("\n 정답은 [" + ja.getAnswer() + "] 입니다!");
                		System.out.println("\n -> 결과 : 정답!");
                	} else {
                		System.out.println("\n 정답은 [" + ja.getAnswer() + "] 입니다!");
                		System.out.println("\n -> 결과 : 오답");
                	}
                	
                	// 프로그램 구동
                	JSQDTO jcq1 = new JSQDTO(jq.getQuest(), ja.getAnswer());
            		// Controller만 호출.
            		JSQController jsqctrl = new JSQController();
            		System.out.println("\n# Program On #\n");
            		System.out.println(jsqctrl.JSQList2(jcq1, new Model()));
        	
                } else if(quizMenu.equals("0")) {
                	
                	System.out.println("\n커뮤니티 메인으로 이동합니다.");
                	cin.main(args);
                	
                } else {
                	
                	System.out.println("\n잘못 입력 하셨습니다, 처음으로 이동합니다.");
                	cin.main(args);
                	
                } 
        	}
      	
        } else if(mainMenu.equals("0")) {
        	// JSTUDY 커뮤니티 - 메인 메뉴 복귀
        	System.out.println("\n메인 메뉴로 이동합니다.");
        	cin.main(args);
        	
        } else {
        	System.out.println("\n잘못 입력 하셨습니다, 처음으로 이동합니다.");
        	cin.main(args);
        	
        }
        		
		cin.main(args);

	}
}
