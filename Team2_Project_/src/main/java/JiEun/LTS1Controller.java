package JiEun;

public class LTS1Controller {
	LTS1Service service = new LTS1Service();
	
	public void storeList(LTS1Model m) {
		System.out.println(" [Controller] 판매점리스트 조회 ");
		m.addAttribute("판매점리스트 조회", service.storeList());
	}
}
