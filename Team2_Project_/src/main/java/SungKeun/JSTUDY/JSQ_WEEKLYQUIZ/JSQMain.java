package SungKeun.JSTUDY.JSQ_WEEKLYQUIZ;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import SungKeun.JSTUDY.Model;
import SungKeun.JSTUDY.JSC_COMMUNITY.JSCController;
import SungKeun.JSTUDY.JSC_COMMUNITY.JSCDTO;

public class JSQMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JSQMain qin = new JSQMain();
//		qin.main(args); // 처음으로 이동
		Scanner sc = new Scanner(System.in);
		
		int questNum; // 정답을 맞춘 문제 번호 (오답이면 0)
		String quest; // 문제
		String usrAns; // 유저 정답
		String answer; // 문제 정답
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		int weekly = 7; // 문제 초기화 주기
		String user; // 설정할 유저 이름
		String Admin = "ysk2388"; // 관리자 ID
		
		
		// JSTUDY 커뮤니티 - Weekly Quiz
		System.out.println("\n===============================================");
        System.out.println("\n## JSTUDY 커뮤니티 - Weekly Quiz ## \n");
        String quizMenu; // 커뮤니티 - Weekly Quiz 메뉴 선택
        System.out.println("[1] QUIZ 시작 [2] (관리자) 문제 및 정답 설정 [0] 커뮤니티 \n");
        System.out.print(" -> [Weekly Quiz] 메뉴를 선택하세요 : ");
        quizMenu = sc.nextLine();
        
        if(quizMenu.equals("1")) {
            // JSTUDY 커뮤니티 - Weekly Quiz 메뉴 -> QUIZ 시작
        	System.out.println("\n===============================================");
    		System.out.println("## JSTUDY 커뮤니티 [Weekly Quiz] -> QUIZ 시작 ## \n");
    		System.out.println("## JSTUDY 커뮤니티 [Weekly Quiz] 에 오신 것을 환영 합니다! ## \n");
    		System.out.println("## JSTUDY 커뮤니티 [Weekly Quiz] 초기화까지 남은 시간 : " + dateFormat.format(cal.getTime()));
    		
        } else if(quizMenu.equals("2")) {
    		// JSTUDY 커뮤니티 - 자유 게시판 메뉴 -> 게시물 글쓰기
    		
        } else if(quizMenu.equals("0")) {
        	System.out.println("\n커뮤니티 메인으로 이동합니다.");
        	qin.main(args);
        } else {
        	System.out.println("\n잘못 입력 하셨습니다, 처음으로 이동합니다.");
        	qin.main(args);
        }
		
		JSQDTO jcwq1 = new JSQDTO();
		// Controller만 호출.
		JSQController jsqctrl = new JSQController();
		System.out.println("\n# 호출된 화면 #\n");
		System.out.println(jsqctrl.JSQList2(jcwq1, new Model()));
	}

}
