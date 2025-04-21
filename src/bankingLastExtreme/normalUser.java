package bankingLastExtreme;

import java.util.ArrayList;

public class normalUser extends user{

	public normalUser(String name, String phoneNumber, String ssn, String gender, String userId, String password,
			String email, String regisDate, ArrayList<Account> accounts) {
		super(name, phoneNumber, ssn, gender, userId, password, email, regisDate, accounts);
	}

}
