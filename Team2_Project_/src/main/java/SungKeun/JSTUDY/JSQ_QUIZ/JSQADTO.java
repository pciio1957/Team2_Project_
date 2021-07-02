package SungKeun.JSTUDY.JSQ_QUIZ;

public class JSQADTO {
	String answer; // 정답
//	private String answer; // 정답
	
	public JSQADTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public JSQADTO(String answer) {
		super();
		this.answer = answer;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
    public String toString() {
        return " \n " +  " # 정답 : " + answer + "\n" + "\n";
    }
	
}
