package DaEun.FAQ;

import java.util.Scanner;

public class Service {
	
	Scanner sc = new Scanner(System.in);
	FAQ_DAO dao = new FAQ_DAO();
	
	public Object method;
	public String FAQS() {
		System.out.println("     FAQ 작성하기");
		System.out.println("---------------------");
		FAQ_DTO dto = new FAQ_DTO();
		System.out.println("FAQ 제목 : ");
		dto.setFtitle(sc.nextLine());
		System.out.println("FAQ 내용 : ");
		dto.setFwrite(sc.nextLine());
		return "서비스 전송";
	}
}
