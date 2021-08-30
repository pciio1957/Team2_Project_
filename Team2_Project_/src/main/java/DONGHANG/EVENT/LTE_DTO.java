package DONGHANG.EVENT;

public class LTE_DTO {
	private String evname;
	private String evdate;
	private String annodate;
	private String explan;
	
	public LTE_DTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LTE_DTO(String evname, String evdate, String annodate, String explan) {
		super();
		this.evname = evname;
		this.evdate = evdate;
		this.annodate = annodate;
		this.explan = explan;
	}
	
public void showInfo() {				
		System.out.println("이벤트 명 : " + evname);
		System.out.println("이벤트 기간 : " + evdate);
		System.out.println("당첨자 발표: " + annodate);
		System.out.println("이벤트 설명: " + explan);		
	}

	public String getEvname() {
		return evname;
	}
	public void setEvname(String evname) {
		this.evname = evname;
	}
	public String getEvdate() {
		return evdate;
	}
	public void setEvdate(String evdate) {
		this.evdate = evdate;
	}
	public String getAnnodate() {
		return annodate;
	}
	public void setAnnodate(String annodate) {
		this.annodate = annodate;
	}
	public String getExplan() {
		return explan;
	}
	public void setExplan(String explan) {
		this.explan = explan;
	}


	}

