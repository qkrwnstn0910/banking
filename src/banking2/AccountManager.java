package banking2;

import java.util.Scanner;

public class AccountManager {
	Scanner scan = new Scanner(System.in);
	Account account[] = new Account[50];
	int count =0;
	public void makeNormalAccount() {
		System.out.println("신규계좌개설");
		System.out.println("계좌번호:");
		String gAccount = scan.nextLine();
		System.out.println("이름:");
		String gname = scan.nextLine();
		System.out.println("잔액:");
		double gMoney = scan.nextDouble();
		System.out.println("이자율(정수형태)");
		double gRate = scan.nextDouble();
		scan.nextLine();
		System.out.println("계좌가 생성되었습니다.");
		
		account[count] = new Account(gAccount,gname,gMoney,gRate);
		count++;
 	}
	public void makeCreditAccount() {
		System.out.println("특별계좌개설");
		System.out.println("계좌번호:");
		String gAccount = scan.nextLine();
		System.out.println("이름:");
		String gname = scan.nextLine();
		System.out.println("잔액:");
		double gMoney = scan.nextDouble();
		System.out.println("이자율(정수형태)");
		double gRate = scan.nextDouble();
		scan.nextLine();
		System.out.println("등급 입력");
		String gCredit = scan.nextLine();
		System.out.println("계좌가 생성되었습니다.");
		
		account[count] = new Account(gAccount,gname,gMoney, gRate);
		
		count++;
 	}
	
	public void depositMoney() {
		
		System.out.println("입금");
		System.out.println("계좌번호를 입력하세요");
		String gAccount = scan.nextLine();
		for (int i=0; i<=gAccount.length(); i++) {
			if (account[i] != null && account[i].getAccount().equals(gAccount )) {
			
				System.out.println("입금할 금액을 입력하세요");
				try {
					int gmoney = scan.nextInt();
					scan.nextLine();
					double alpha = account[i].getMoney(); 
					double beta = account[i].rateRatio();
					account[i].setMoney(alpha+gmoney+beta);
					System.out.println("금액이 입금되었습니다. 현재잔액" + account[i].getMoney());
				
				}
				catch (Exception e) {
					System.out.println("입금금액을 잘못 입력했습니다.");
					scan.nextLine();
				}
			}
		}
	}
	
	public void wihtDrawMoney() {
		System.out.println("출금");
		System.out.println("계좌번호를 입력하세요");
		String gAccount = scan.nextLine();
		for (int i=0; i<=gAccount.length(); i++) {
			if (account[i] != null && account[i].getAccount().equals(gAccount )) {
			
				System.out.println("출금할 금액을 입력하세요");
				
				try {	
					int gmoney = scan.nextInt();
					scan.nextLine();
					if (account[i].getMoney()>gmoney) {	
						int gmoney1 = scan.nextInt();
						scan.nextLine();
						double alpha = account[i].getMoney(); 
						account[i].setMoney(alpha-gmoney1);
						System.out.println("금액이 출금되었습니다. 현재잔액" + account[i].getMoney());
					}
					else {
						System.out.println("금액이 충분하지 않습니다.");
					}
					
				}
				catch (Exception e) {
					System.out.println("입금금액을 잘못 입력했습니다.");
					scan.nextLine();
				}
			}
		}
	}
	public void showAccInfo() {
		for(int i =0; i<account.length; i++) {
			
			if (account[i] != null) {
			System.out.println("현재상태");
			System.out.println(account[i].getAccount());
			System.out.println(account[i].getName());
			System.out.println(account[i].getMoney());
			}
			
		}
	}
}
	
	

