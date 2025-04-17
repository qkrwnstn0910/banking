package banking7;

public class SpecialAccount extends NormalAccount{
	
	public SpecialAccount(String account, String name, double money, double rate) {
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
	
	@Override
	public double rateManager() {
		int count = 0;
		double add = 0;
		double rateN = rate * 0.01;
		int add2 = 500;
		for(int i=0; i<getAccount().length(); i++) {
			if (count%2 ==0) {
				add= money + (money * rateN)+ add2;
				count++;
			}
			else {
				add = money + (money * rateN);
				count++;
			}
		}
		return add;
	}

}
