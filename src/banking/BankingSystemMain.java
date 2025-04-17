package banking;

import java.util.Scanner;

public class BankingSystemMain {

	public static void main(String[] args) {
		AccountManager accounts1 = new AccountManager();
		Scanner scan = new Scanner(System.in);
		int count =0;
		while(true) {
		main();
		count = scan.nextInt();
		scan.nextLine();
		if(count == 1) {
			//계좌계설
			accounts1.makeAccount(); 
		}
		if(count == 2) {
			//입금
			accounts1.depositMoney();
		}
		if(count == 3) {
			//출금
			accounts1.wihtDrawMoney();
		}
		if(count == 4) {
			accounts1.showAccInfo();
			//전체계좌정보출력
		}
		if(count == 5) {
			//프로그램 종료
		}
		}
		
	}
	
	public static void main	() {
		System.out.println("1.계좌계설");
		System.out.println("2.입금");
		System.out.println("3.출금");
		System.out.println("4.전체계좌정보출력");
		System.out.println("5.프로그램종료");
	}

}
