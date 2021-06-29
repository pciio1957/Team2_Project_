package SungKeun.JSTUDY.JSQ_WEEKLYQUIZ;

public class JSQUDTO {
	private int questNum; // 문제 번호
	private String quest; // 문제
	private String usrAns; // 유저 정답
	private String answer; // 문제 정답
	
	public JSQUDTO() {
		super();
		
	}

	public JSQUDTO(int questNum, String quest, String usrAns, String answer) {
		super();
		this.questNum = questNum;
		this.quest = quest;
		this.usrAns = usrAns;
		this.answer = answer;
	}

	public int getQuestNum() {
		return questNum;
	}

	public void setQuestNum(int questNum) {
		this.questNum = questNum;
	}

	public String getQuest() {
		return quest;
	}

	public void setQuest(String quest) {
		this.quest = quest;
	}
	
	public String getUsrAns() {
		return usrAns;
	}

	public void setUsrAns(String usrAns) {
		this.usrAns = usrAns;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
    public String toString() {
        return " \n # 문제 번호 : " + questNum + "\n" +
        		" # 문제 : " + quest + "\n" +
        		" # 유저 정답 : " + usrAns + "\n" +
        		" # 문제 정답 : " + answer + "\n" + "\n";
    }
	
}
