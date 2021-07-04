package SungKeun.JSTUDY.JSQ_QUIZ;

import java.util.ArrayList;
import java.util.Scanner;

import SungKeun.JSTUDY.Model;

public class JSQMain {
	
	static JSQDTO jq = new JSQDTO(); // 퀴즈 문제에 대한 객체를 전역 변수로 선언
	static JSQDTO ja = new JSQDTO(); // 퀴즈 정답에 대한 객체를 전역 변수로 선언
		
	public static void main(String[] args) {
		
		JSQMain qin = new JSQMain();
//		qin.main(args); // 처음으로 이동
		Scanner sc = new Scanner(System.in);
		
		String quest; // 문제
		String usrAns; // 유저 정답
		String answer; // 정답
		
		String admin; // 관리자 ID
		String adminPw; // 관리자 PW
		
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
//        		jsqlist.add(new JSQDTO(jq.getQuest(), ja.getAnswer()));
        		System.out.print(" | 문제 | " + jq.getQuest() + "\t");
				System.out.print(" | 정답 | " + ja.getAnswer() + "\n");
        		System.out.println("\n");
        		
        	} else {
        		// 관리자 정보가 일치하지 않을 때
        		System.out.println(" -> 관리자 정보가 일치하지 않습니다.\n");
        	}

        	qin.main(args);
    		
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

    		qin.main(args);
	
        } else if(quizMenu.equals("0")) {
        	
        	System.out.println("\n커뮤니티 메인으로 이동합니다.");
        
        	qin.main(args);
        	
        } else {
        	
        	System.out.println("\n잘못 입력 하셨습니다, 처음으로 이동합니다.");
        	
        	qin.main(args);
        	
        }
		
//    	JSQDTO jcq1 = new JSQDTO();
//		// Controller만 호출.
//		JSQController jsqctrl = new JSQController();
//		System.out.println("\n# Program On #\n");
//		System.out.println(jsqctrl.JSQList2(jcq1, new Model()));
	}

}