package banking5;

public class HighCreditAccount extends Account{
	private String credit;

	public HighCreditAccount(String account, String name, double money, double rate, String credit) {
		super(account, name, money, rate);
		this.credit = credit;
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
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.rate=rate;
	}
	
	@Override
	public double rateManager() {
		double newRate = 0.02;
		if (credit.equals("a")) {
			newRate+=0.35;
		}
		else if (credit.equals("b")) {
			newRate+=0.2;
		}
		else if (credit.equals("c")) {
			newRate+=0.05;
		}
		else {
			System.out.println("보통계좌는 기존의 이자율이 적용됩니다.");
		}
		return money + (money * newRate);
	}
	
	
}
