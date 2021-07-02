package SungKeun.JSTUDY.JSQ_QUIZ;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import SungKeun.JSTUDY.Model;

public class JSQMain {


	public static void main(String[] args) {
		
		ArrayList<JSQDTO> jsqlist = new ArrayList<JSQDTO>();
		ArrayList<JSQADTO> jsqalist = new ArrayList<JSQADTO>();
		
		JSQMain qin = new JSQMain();
//		qin.main(args); // 처음으로 이동
		Scanner sc = new Scanner(System.in);
		
		int questNum = 1; // 문제 번호
		String quest; // 문제
		String answer; // 정답
		String usrAns; // 유저 정답
	
		String admin; // 관리자 ID
		String adminPw; // 관리자 PW
		
		// JSTUDY 커뮤니티 - JSTUDY Quiz!
		System.out.println("\n===============================================");
        System.out.println("\n## JSTUDY 커뮤니티 - JSTUDY Quiz ## \n");
        String quizMenu; // 커뮤니티 - Weekly Quiz 메뉴 선택
        System.out.println("[1] 관리자 모드 [2] QUIZ 시작 [0] 커뮤니티 \n");
        System.out.print(" -> [JSTUDY Quiz] 메뉴를 선택하세요 : ");
        quizMenu = sc.nextLine();
        
        if(quizMenu.equals("1")) {
    		// JSTUDY 커뮤니티 - JSTUDY Quiz 메뉴 -> (관리자) 문제 및 정답 설정
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
        		System.out.println("## JSTUDY 커뮤니티 [JSTUDY Quiz] : 설정 할 문제를 입력하세요. ## \n");
    			System.out.print("\n 설정 할 문제 : ");
    			quest = sc.nextLine();
    			System.out.println("\n## JSTUDY 커뮤니티 [JSTUDY Quiz] : 설정 된 문제 정보 ## \n");
        		System.out.print(" -> 입력 된 문제 : " + quest + "\n");
        		
        		// 정답 설정
        		System.out.println("\n## JSTUDY 커뮤니티 [JSTUDY Quiz] : 설정 할 정답을 입력하세요. ## \n");
        		System.out.print(" -> 설정 할 정답 : ");
        		answer = sc.nextLine();
        		System.out.println("\n## JSTUDY 커뮤니티 [JSTUDY Quiz] : 설정 된 정답 정보 ## \n");
        		System.out.print(" -> 입력 된 정답 : " + answer + "\n");
        		
        		// 종합 = 문제 + 정답
        		System.out.println("\n## JSTUDY 커뮤니티 [JSTUDY Quiz] : 설정 된 퀴즈 정보 ## \n");
        		jsqlist.add(new JSQDTO(quest));
        		for(JSQDTO q:jsqlist) {
    				System.out.print(" | 문제 | " + q.getQuest() + "\t");
    			}
        		jsqalist.add(new JSQADTO(answer));
        		for(JSQADTO qa:jsqalist) {
    				System.out.print(" | 정답 | " + qa.getAnswer() + "\t");
    			}
        		System.out.println("\n");
        		
        	} else {
        		// 관리자 정보가 일치하지 않을 때
        		System.out.println(" -> 관리자 정보가 일치하지 않습니다.\n");
        	}

        	qin.main(args);
    		
        } else if(quizMenu.equals("2")) {
            // JSTUDY 커뮤니티 - JSTUDY Quiz 메뉴 -> QUIZ 시작
        	System.out.println("\n===============================================");
    		System.out.println("## JSTUDY 커뮤니티 [JSTUDY Quiz] -> QUIZ 시작 ## \n");
    		System.out.println("## JSTUDY 커뮤니티 [JSTUDY Quiz] 에 오신 것을 환영 합니다! ## \n");
    		// 문제 설정
    		System.out.println("## JSTUDY 커뮤니티 [JSTUDY Quiz] : 해당 문제를 보고 답을 입력하세요. ## \n");
    		JSQDTO jq = new JSQDTO();
    		jq.quest = "1111";
    		String quest1 = jq.getQuest();
    		System.out.println(" -> 문제 : " + quest1);
    		System.out.print("\n 유저 답안 : ");
			usrAns = sc.nextLine();
			System.out.println("\n## JSTUDY 커뮤니티 [JSTUDY Quiz] : 유저가 입력 한 답안 정보 ## \n");
    		System.out.print(" -> 유저 입력 답안 : " + usrAns + "\n");
    		System.out.println("정답을 확인 하시겠습니까? (Y/N) \n");
    		String anschk; // 정답 확정 여부
    		anschk = sc.nextLine();
    		if(anschk.equals("Y")) {
    			
    		} else {
    			
    		}
    		JSQADTO ja = new JSQADTO();
    		ja.answer = "1111";
    		String answer1 = ja.getAnswer();
    		
    		qin.main(args);
	
        } else if(quizMenu.equals("0")) {
        	System.out.println("\n커뮤니티 메인으로 이동합니다.");
        	qin.main(args);
        } else {
        	System.out.println("\n잘못 입력 하셨습니다, 처음으로 이동합니다.");
        	qin.main(args);
        }
		
//		JSQDTO jcq1 = new JSQDTO(quest);
//		// Controller만 호출.
//		JSQController jsqctrl = new JSQController();
//		System.out.println("\n# 호출된 화면 #\n");
//		System.out.println(jsqctrl.JSQList2(jcq1, new Model()));    

//		JSQADTO jcqa1 = new JSQADTO(answer);
//		// Controller만 호출.
//		JSQAController jsqactrl = new JSQAController();
//		System.out.println("\n# 호출된 화면 #\n");
//		System.out.println(jsqactrl.JSQAList2(jcqa1, new Model()));
	}

}