package SungKeun.JSTUDY.JSQ_QUIZ;

public class JSQDTO {
	String quest; // 문제
//	private String quest; // 문제
	
	public JSQDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JSQDTO(String quest) {
		super();
		this.quest = quest;
	}

	public String getQuest() {
		return quest;
	}

	public void setQuest(String quest) {
		this.quest = quest;
	}

	@Override
    public String toString() {
        return " \n # 문제 : " + quest + "\n";
    }
	
}
