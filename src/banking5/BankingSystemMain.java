package banking5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankingSystemMain {

	public static void main(String[] args) {
		AccountManager accounts1 = new AccountManager();
		Scanner scan = new Scanner(System.in);
		int count =0;
		accounts1.loadFile();
		while(true) {
		main();
		count = scan.nextInt();
		scan.nextLine();
		MenuSelectException.exception1(count);
		
			if(count == 1) {
			//계좌계설
			main2();
			int choose = scan.nextInt()	;
			if (choose == 1) {
				//보통계좌
				accounts1.makeNormalAccount();
			}
			if (choose == 2) {
				//신용계좌
				accounts1.makeCreditAccount();
			}
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
			accounts1.deleteAccount();
		}
		if(count == 6) {
			//프로그램 종료
			accounts1.saveFile();
			System.exit(0);
		}
		}
		
	}
	
	public static void main	() {
		System.out.println("1.계좌계설");
		System.out.println("2.입금");
		System.out.println("3.출금");
		System.out.println("4.전체계좌정보출력");
		System.out.println("5.계좌 삭제");
		System.out.println("6.프로그램종료");
	}
	public static void main2() {
		System.out.println("1.보통계좌");
		System.out.println("2.신용거래계좌");
	}

}
