package DaEun.FAQ;

public class FAQ_DTO {

	private String ftitle;
	private String fwrite;
	public FAQ_DTO(String ftitle, String fwrite) {
		super();
		this.ftitle = ftitle;
		this.fwrite = fwrite;
	}
	public FAQ_DTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getFtitle() {
		return ftitle;
	}
	public void setFtitle(String ftitle) {
		this.ftitle = ftitle;
	}
	public String getFwrite() {
		return fwrite;
	}
	public void setFwrite(String fwrite) {
		this.fwrite = fwrite;
	}
}
