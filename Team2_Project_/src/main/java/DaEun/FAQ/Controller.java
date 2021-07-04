package DaEun.FAQ;

public class Controller {
	private Service service = new Service(); // 서비스 호출 추가 및 변경

	public String flist1(FAQ_DTO dto1, Model model) {

		System.out.println("		컨트롤러");
		System.out.println("-------------------------------------");
		System.out.println("FAQ 제목 : " + dto1.getFname());
		System.out.println("FAQ 내용 :" + dto1.getFwrite());
		model.addAttribute("flist", service.FAQS());
		return " ";
	}
}
