package banking7;

import java.util.Scanner;

public class BankingSystemMain implements use{

	public static void main(String[] args) {
		AccountManager accounts1 = new AccountManager();
		Scanner scan = new Scanner(System.in);
		String count;
		accounts1.loadFile();
		autoSave auto = new autoSave(null);
		auto.setDaemon(true);
        
		while(true) {
		main();
		count = scan.nextLine();
	
		if (!MenuSelectException.exception1(count)) {
			continue;
		}		
		int count1 = Integer.parseInt(count);
			if(count1 == 1) {
			//계좌계설
			main2();
			int choose = scan.nextInt()	;
			scan.nextLine();
			if (choose == MAKE) {
				//보통계좌
				main3();
				int choose2 = scan.nextInt();
				scan.nextLine();
				if(choose2 == 1 )	{
					accounts1.makeNormalAccount();
				}
				else if(choose2 ==2) {
					accounts1.makeSpecialAccount();
				}
				
			}
			if (choose == 2) {
				//신용계좌
				accounts1.makeCreditAccount();
			}
		}
		if(count1 == DEPOSIT) {
			//입금
			accounts1.depositMoney();
		}
		if(count1 == WITHDRAW) {
			//출금
			accounts1.wihtDrawMoney();
		}
		if(count1 == INQUIRE) {
			accounts1.showAccInfo();
			//전체계좌정보출력
		}
		if(count1 == 5) {
			accounts1.deleteAccount();
		}
		if(count1 == 6) {
			accounts1.autoSave2();
		}
		if(count1 == EXIT) {
			//프로그램 종료
			System.out.println("프로그램을 종료합니다.");
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
		System.out.println("6.저장 옵션");
		System.out.println("7.프로그램종료");
	}
	public static void main2() {
		System.out.println("1.보통예금계좌");
		System.out.println("2.신용신뢰계좌");
	}
	
	public static void main3() {
		System.out.println("1.일반계좌");
		System.out.println("2.특판계좌");
	}

}
