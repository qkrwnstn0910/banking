package bankingLastExtreme;

import java.io.Serializable;
import java.util.Objects;

public class Account implements Serializable{

	protected String account;
	protected String name;
	protected double money;
	protected double rate;
	private String accountNumber;  
    private String inputAccount;
	
	public Account(String account, String name, double money,double rate) {
		this.account = account;
		this.name = name;
		this.money = money;
		this.rate = rate;
	}
	
	public Account(String accountNumber, String inputAccount) {
		this.accountNumber = accountNumber;
		this.inputAccount = inputAccount;
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
	public void setRate(double rate) {
		this.rate=rate;
	}
	
	public double rateManager () {
		double rateN = rate * 0.01;
	    return money + (money * rateN);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(accountNumber,inputAccount);
	}
	 @Override
	    public boolean equals(Object obj) {
	        if (this == obj) return true;
	        if (obj == null || getClass() != obj.getClass()) return false;
	        Account account = (Account) obj;
	        return Objects.equals(accountNumber, account.accountNumber) &&
	               Objects.equals(inputAccount, account.inputAccount);
	    }


}


