package banking3;

public class HighCreditAccount extends Account{
	private String credit;

	public HighCreditAccount(String account, String name, double money, double rate, String credit) {
		super(account, name, money, rate);
		this.credit = credit;
	}
	public String getCredit() {
		return credit;
	}
	
	public double rateRatio () {
		
		double rate1 = 0.05;
		double ratio = rate*rate1+rate;
		if (credit.equals("a")) {
			rate+=0.35;
		}
		if (credit.equals("b")) {
			rate+=0.2;
		}
		if (credit.equals("c")) {
			rate+=0.05;
		}
		double ratio1 = rate*0.05+rate;
		return ratio;
	}
	
}
