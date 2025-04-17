package banking4;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

public class AccountManager {
	Scanner scan = new Scanner(System.in);
	HashSet<Account> set = new HashSet<>();
	
	int count =0;

	public void makeNormalAccount() {
		System.out.println("신규계좌개설");
		System.out.println("계좌번호:");
		String gAccount = scan.nextLine();
		Account temp = new Account(gAccount, "");
		  if (set.contains(temp)) {
		        System.out.println("이미 존재하는 계좌번호입니다. 덮어씌우겠습니까? Y N");
		        String sc = scan.nextLine();
		        if(sc.equals("Y")) {
		        	System.out.println("수정되었습니다.");
		        	set.remove(temp);
		        	set.add(temp);
		        }
		        else {
		        	System.out.println("취소합니다.");
		        	return;
		        }
		    }
		System.out.println("이름:");
		String gname = scan.nextLine();
		System.out.println("잔액:");
		double gMoney = scan.nextDouble();
		System.out.println("이자율(정수형태)");
		double gRate = scan.nextDouble();
		scan.nextLine();
		System.out.println("계좌가 생성되었습니다.");
		
		set.add(new NormalAccount(gAccount, gname, gMoney, gRate));
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
		
		set.add(new HighCreditAccount(gAccount, gname, gMoney, gRate, gCredit));
		
		count++;
 	}
    
	
	public void depositMoney() {
		
		System.out.println("입금");
		System.out.println("계좌번호를 입력하세요");
		String gAccount = scan.nextLine();
		for (Account acc : set) {
		    if (acc.getAccount().equals(gAccount)) {
		        // 찾음!
		
				System.out.println("입금할 금액을 입력하세요");
				int gmoney = scan.nextInt();
				MenuSelectException.exception2(gmoney);
				MenuSelectException.exception3(gmoney);
				scan.nextLine();
				try {
					double alpha = acc.getMoney(); 
					double beta = acc.rateManager();
					acc.setMoney(alpha+beta);
					System.out.println("금액이 입금되었습니다. 현재잔액" + acc.getMoney());
				
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
		for(Account acc : set) {
			if(acc.getAccount().equals(gAccount)) {
			
				System.out.println("출금할 금액을 입력하세요");
				
				try {	
					int gmoney = scan.nextInt();
				
					int gmoney1 = scan.nextInt();
					double alpha = acc.getMoney(); 
					scan.nextLine();

					MenuSelectException.exception4(alpha, gmoney1);
					if (acc.getMoney()>gmoney) {	
						
						acc.setMoney(alpha-gmoney1);
						System.out.println("금액이 출금되었습니다. 현재잔액" + acc.getMoney());
					}
					else {

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
		System.out.println("계좌정보출력");
		for(Account acc : set) {
			System.out.println("---계좌정보출력---");
			System.out.println("계좌번호:"+acc.getAccount());
			System.out.println("고객이름"+acc.getName());
			System.out.println("잔고"+acc.getMoney());
			System.out.println("이자율"+acc.getrate());
			 if (acc instanceof HighCreditAccount) {
		            HighCreditAccount hAcc = (HighCreditAccount) acc;
		            System.out.println("등급: " + hAcc.getCredit());
		        } else {
		            System.out.println("등급: 해당 없음"); 
		        }
			}
		}
	public void deleteAccount() {
		System.out.println("삭제할 계좌를 입력해주세요");
		String delete =scan.nextLine();
		for(Account acc : set) {
			String delAccount = acc.getAccount();
			if (delAccount.equals(delete)) {
				set.remove(acc);
				System.out.println("삭제되었습니다.");
			}
			else {
				System.out.println("입력한 계좌가 존재하지 않습니다.");
			}
		}
		
	}
}

	
	

