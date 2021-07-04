package 프로젝트소스_공유용.성근_시간기능;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class receipt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 프로그램을 구동 시간 기준 출력 (ex_영수증 출력 시 사용)
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		System.out.println("프로그램 구동 시간 기준 : " + dateFormat.format(cal.getTime()));
		
		// 현재 시스템 시간 구하기
		long systemTime = System.currentTimeMillis();
		// 출력 형태를 위한 formmater
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA);
		// format에 맞게 출력하기 위한 문자열 변환
		String dTime = formatter.format(systemTime);
		System.out.println("Today is " + dTime);
		// 'Today is 2019-08-16 12:44:42' 출력
	}

}