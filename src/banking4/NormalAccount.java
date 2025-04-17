package banking4;

public class NormalAccount extends Account{

	public NormalAccount(String account, String name, double money, double rate) {
		super(account, name, money, rate);
	}

	public String setAccount() {
		return account;
	}
	public void getAccount(String account) {
		this.account=account;
	}
	public String setName() {
		return name;
	}
	public void getName(String name) {
		this.name=name;
	}
	public double setMoney() {
		return money;
	}
	public void getMoney(double money) {
		this.money=money;
	}
	public double setrate() {
		return rate;
	}
	public void getAccount(double rate) {
		this.rate=rate;
	}

}
