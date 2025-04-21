package bankingLastExtreme;

import java.util.ArrayList;

public class user {
	
	private String name, phoneNumber, ssn/*주민번호*/,gender,userId,password,email,regisDate;
	private ArrayList<Account> accounts;
	public user(String name, String phoneNumber, String ssn, String gender, String userId, String password,
			String email, String regisDate, ArrayList<Account> accounts) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.ssn = ssn;
		this.gender = gender;
		this.userId = userId;
		this.password = password;
		this.email = email;
		this.regisDate = regisDate;
		this.accounts = accounts;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRegisDate() {
		return regisDate;
	}
	public void setRegisDate(String regisDate) {
		this.regisDate = regisDate;
	}
	public ArrayList<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}
	
	

}
