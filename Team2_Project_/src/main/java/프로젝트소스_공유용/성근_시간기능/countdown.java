package 프로젝트소스_공유용.성근_시간기능;

import java.util.Timer;
import java.util.TimerTask;

public class countdown {
	
	//카운트다운을 수행할 변수 선언 실시
	static int count = 1;

	public static void main(String[] args) {

		System.out.println("[타이머 Timer,TimerTask 사용해 실시간 카운트다운(countdown) 및 자동종료 실시]");		

		/*[설 명]
		 * 1. Timer, TimerTast를 사용해서 카운트다운 기능을 구현할 수 있습니다
		 * 2. timer.schedule - 타이머 스케줄러 작업 실행 및 반복 시간을 정의합니다
		 * 3. timer.cancle - 타이머 실행을 종료합니다
		 */
		Timer timer=new Timer();
		TimerTask task=new TimerTask() {
		    @Override
		    public void run() {
		    //TODO Auto-generated method stub
				if(count <= 5) { //count값이 3보다 작거나 같을때까지 수행
					System.out.println("[카운트다운 : "+count+"]");
					count++; //실행횟수 증가 
				} else {
					timer.cancel(); //타이머 종료
					System.out.println("[카운트다운 : 종료]");
				}
		    }	
		};
		timer.schedule(task, 1000, 1000); // 실행 Task, 1초뒤 실행, 1초마다 반복
		
	} //메인 종료

} //클래스 종료
