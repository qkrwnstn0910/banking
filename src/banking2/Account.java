package banking2;

public class Account {

	private String account,name;
	private double money;
	protected double rate;
	
	
	public Account(String account, String name, double money,double rate) {
		this.account = account;
		this.name = name;
		this.money = money;
		this.rate = rate;
	}
	public String getName() {
		return name;
	}
	public String getAccount() {
		return account;
	}
	public double getMoney() {
		return money;
	}
	public double getrate() {
		return rate;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setAccount(String account) {
		this.account= account;
	}
	public void setMoney(double money) {
		this.money= money;
	}
	public double rateRatio () {
		double ratio = rate*0.01+rate;
		return ratio;
	}
	


}


