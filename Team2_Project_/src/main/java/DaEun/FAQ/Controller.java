package DaEun.FAQ;

public class Controller {
	private Service service = new Service();
	
	public String flist1(FAQ_DTO dto1, Model model) {
		System.out.println(" 컨트롤러 ");
		System.out.println("---------------");
		System.out.println(" FAQ 제목 :"+dto1.getFtitle());
		System.out.println(" FAQ 제목 :"+dto1.getFwrite());
		model.addAttribute("flist", service.FAQS());
		
		return " ";
		
	}
}
