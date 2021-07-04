package 프로젝트소스_공유용.성근_시간기능;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;

public class timer {
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		SimpleDateFormat f = new SimpleDateFormat("HH:mm:ss", Locale.KOREA);
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date d1 = f.parse("01:05:10");
		Date d2 = f.parse("01:05:07");
		long diff = d1.getTime() - d2.getTime();
		long sec = diff / 1000;
		System.out.println("현재 남은 시간 : " + sec + "초");
	}
}