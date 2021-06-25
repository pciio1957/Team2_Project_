package SungKeun.JSTUDY.JSC_COMMUNITY;

public class JSCDTO {
	private int writeNum; // 게시물 번호
	private String headLine; // 제목
	private String writer; // 작성자
	private int writeDate; // 작성일
	private String write; // 작성 내용
	
	public JSCDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public JSCDTO(int writeNum, String headLine, String writer, int writeDate, String write) {
		super();
		this.writeNum = writeNum;
		this.headLine = headLine;
		this.writer = writer;
		this.writeDate = writeDate;
		this.write = write;
	}
	
	public int getWriteNum() {
		return writeNum;
	}

	public void setWriteNum(int writeNum) {
		this.writeNum = writeNum;
	}

	public String getHeadLine() {
		return headLine;
	}

	public void setHeadLine(String headLine) {
		this.headLine = headLine;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(int writeDate) {
		this.writeDate = writeDate;
	}

	public String getWrite() {
		return write;
	}

	public void setWrite(String write) {
		this.write = write;
	}

	@Override
    public String toString() {
        return " \n # 게시물 번호 : " + writeNum + "\n" +
        		" # 제목 : " + headLine + "\n" +
        		" # 작성자 : " + writer + "\n" +
        		" # 작성일 : " + writeDate + "\n" +
        		" # 작성 내용 : " + write + "\n" + "\n";
    }
	
}
