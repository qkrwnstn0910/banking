package banking;

public class Account {

	private String account,name;
	private int money;
	
	public Account(String account, String name, int money) {
		this.account = account;
		this.name = name;
		this.money = money;
	}
	public String getName() {
		return name;
	}
	public String getAccount() {
		return account;
	}
	public int getMoney() {
		return money;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setAccount(String account) {
		this.account= account;
	}
	public void setMoney(int money) {
		this.money= money;
	}
	void makeAccount() {}    // 계좌개설을 위한 함수
	void depositMoney() {}    // 입    금
	void withdrawMoney() {} // 출    금
	void showAccInfo() {}  // 전체계좌정보출력

}


