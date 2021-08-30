package DONGHANG.ACCOUNT;

public class DPR1Account {
	public String ano; //계좌주
    public String owner; // 계좌번호
    public int balance; // 초기입금액
    
    
    public DPR1Account(String ano) {
		super();
		this.ano = ano;
	}
    
	//생성자
    public DPR1Account (String ano, String owner, int balance) {
        this.ano = ano;
        this.owner = owner;
        this.balance = balance;
    }
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
}
	
	 //메소드
//    public String getAno() {return ano;}
//    public void setAno(String ano) {this.ano = ano;}
//    public String getOwner() {return owner;}
//    public void setOwner(String owner) {this.owner = owner;}
//    public int getBalance() {return balance;}
//    public void setBalance(int balance) {this.balance = balance;}
//    
//    
//}