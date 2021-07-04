package Hyejin.JSTUDY;

public class Account {
	
	public int key; //코드 
	public String uname; //계좌주
    public String accountNumber; // 계좌번호
    public int importM; // 잔액
    public String Bankname; //주요사용은행명 
    public int mypoint;
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
		public void showmypoint(int index) {	
		System.out.println("["+index+"]"+key +""+"\t"+ uname + "" + "  "+accountNumber + "" +"\t"+"   "+ importM +"\t"+ "" +"\t"+ Bankname +"  "+ mypoint+"\n");

	}	
	public Account(int key, String uname, String accountNumber, int importM, String bankname, int mypoint) {
		super();
		this.key = key;
		this.uname = uname;
		this.accountNumber = accountNumber;
		this.importM = importM;
		this.Bankname = bankname;
		this.mypoint = mypoint;
	}
	
	public int showmypoint2(String uname) {
		System.out.println("나의 잔액포인트:");
	return mypoint;	
	}
	
	public int aftermypoint(int usem) {
		int tot = (mypoint - usem);
	 return tot;
	}
	
	public Account(String uname) {
		this.uname = uname;
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getImportM() {
		return importM;
	}
	public void setImportM(int importM) {
		this.importM = importM;
	}
	public String getBankname() {
		return Bankname;
	}
	public void setBankname(String bankname) {
		Bankname = bankname;
	}
	public int getMypoint() {
		return mypoint;
	}
	public void setMypoint(int mypoint) {
		this.mypoint = mypoint;
	}

}