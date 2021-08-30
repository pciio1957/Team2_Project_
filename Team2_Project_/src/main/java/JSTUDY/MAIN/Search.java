package JSTUDY.MAIN;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Search {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("검색어를 입력하세요:");
		sc.nextInt();
		
		 String data;
		   data = sc.toString();

		   if (Pattern.matches("[0-9]", data))
		    System.out.printf("숫자");
		   else if (Pattern.matches("[A-Z]",data))
		    System.out.printf("대문자");
		   else if (Pattern.matches("[a-z]", data))
		    System.out.printf("소문자");
		   else if (Pattern.matches("[가-힣]", data))
		    System.out.println("한글");
		   else
		    System.out.printf("기타");

	}
}

/*
^[0-9]*$    : 숫자
^[z-zA-Z]*$ : 영문자
^[가-힣]*$  : 한글
^[a-zA-Z0-9]: 영어/숫자 

 

boolean a = Pattern.matches("[a-z]", "a");
boolean b = Pattern.matches("[A-Z]", "a");
boolean c = Pattern.matches("[0-9]", "0");
boolean d = Pattern.matches("[가-힝]", "락");

*/

/*
public class JavaTest
{
 public static void main(String [] args)
  throws IOException
 {
   BufferedReader br =
    new BufferedReader(
    new InputStreamReader(System.in));
   
   String data;
   char ch;

   System.out.print("입력 : ");
   data = br.readLine();
    
   ch = data.charAt(0);

   if (ch>='0' && ch<='9')
   {
    System.out.printf("[%c] 숫자", ch);
   }
   else if (ch>='a' && ch<='z')
   {
    System.out.printf("[%c] 대문자", ch);
   }
   else if (ch>='A' && ch<='Z')
   {
    System.out.printf("[%c] 소문자", ch);
   }
   else if (ch>='가' && ch<='힣')
   {
    System.out.printf("[%c] 한글", ch);
   }
   else
   {
    System.out.printf("[%c] 기타", ch);
   }
 } // main()
} // JavaTest

*/
/*
public class JavaTest
{
 public static void main(String[] args)
  throws IOException
 {
  BufferedReader br =
   new BufferedReader(
   new InputStreamReader(System.in));
  
   String data;

   System.out.print("입력 : ");
   data = br.readLine();

   if (Pattern.matches("[0-9]", data))
    System.out.printf("숫자");
   else if (Pattern.matches("[A-Z]",data))
    System.out.printf("대문자");
   else if (Pattern.matches("[a-z]", data))
    System.out.printf("소문자");
   else if (Pattern.matches("[가-힣]", data))
    System.out.println("한글");
   else
    System.out.printf("기타");
 }
}
 */
