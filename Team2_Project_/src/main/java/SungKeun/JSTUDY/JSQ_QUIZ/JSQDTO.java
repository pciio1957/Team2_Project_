package SungKeun.JSTUDY.JSQ_QUIZ;

public class JSQDTO {
	private int questNum; // 문제 번호
	private String quest; // 문제
	private String answer; // 문제 정답
	
	public JSQDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JSQDTO(int questNum, String quest, String answer) {
		super();
		this.questNum = questNum;
		this.quest = quest;
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
        		" # 문제 정답 : " + answer + "\n" + "\n";
    }
	
}
