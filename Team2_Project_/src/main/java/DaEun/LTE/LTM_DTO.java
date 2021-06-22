package DaEun.LTE;

public class LTM_DTO {
	private String evname;
	private String evdate;
	private String annodate;
	private String explan;
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
	public LTM_DTO(String evname, String evdate, String annodate, String explan) {
		super();
		this.evname = evname;
		this.evdate = evdate;
		this.annodate = annodate;
		this.explan = explan;
	}
	public LTM_DTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str = String.format("이벤트 이름:%s \n이벤트시작기간:%s \n당첨자 발표:%s \n설명:%s \n",
							evname, evdate, annodate, explan);
		return super.toString();
	}
}
