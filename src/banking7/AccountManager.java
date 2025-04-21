package banking7;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

public class AccountManager {
	Scanner scan = new Scanner(System.in);
	HashSet<Account> set = new HashSet<>();
	int count =0;
	autoSave saveThread = new autoSave(set);
	
	public void makeNormalAccount() {
		
		System.out.println("신규계좌개설");
		System.out.println("계좌번호:");
		String gAccount = scan.nextLine();
		Account temp = new NormalAccount(gAccount,"", 0,0);
		  if (set.contains(temp)) {
		        System.out.println("이미 존재하는 계좌번호입니다. 덮어씌우겠습니까? Y N");
		        String sc = scan.nextLine();
		        if(sc.equals("Y")) {
		        	System.out.println("덮어씌우는 데이터를 입력합니다..");
		        	set.remove(temp);
		        	set.add(temp);
		        }
		        else if(sc.equals("N")){
		        	System.out.println("취소합니다.");
		        	return;
		        }
		       
		  }
		  	System.out.println("이름:");
			String gname = scan.nextLine();
			System.out.println("잔액:");
			int gMoney = scan.nextInt();
			scan.nextLine();
			
			System.out.println("이자율(정수형태)");
			int gRate = scan.nextInt();
			scan.nextLine();
			
			System.out.println("계좌가 생성되었습니다.");
			
			set.add(new NormalAccount(gAccount, gname, gMoney, gRate));
			count++;
			
 	}
	public void makeSpecialAccount() {
		System.out.println("특판계좌개설");
		System.out.println("계좌번호:");
		String gAccount = scan.nextLine();
		Account temp = new SpecialAccount(gAccount,"", 0,0);
		if (set.contains(temp)) {
	        System.out.println("이미 존재하는 계좌번호입니다. 덮어씌우겠습니까? Y N");
	        String sc = scan.nextLine();
	        if(sc.equals("Y")) {
	        	System.out.println("덮어씌우는 데이터를 입력합니다..");
	        	set.remove(temp);
	        	set.add(temp);
	        }
	        else if(sc.equals("N")){
	        	System.out.println("취소합니다.");
	        	return;
	        }
	        else {
	        	
	        }
	        System.out.println("이름:");
    		String gname = scan.nextLine();
    		System.out.println("잔액:");
    		double gMoney = scan.nextDouble();
    		scan.nextLine();
    		System.out.println("이자율(정수형태)");
    		double gRate = scan.nextDouble();
    		scan.nextLine();
    		
    		System.out.println("계좌가 생성되었습니다.");
    		
    		set.add(new SpecialAccount(gAccount, gname, gMoney, gRate));
    		
    		count++;
		
		}
	}
	public void makeCreditAccount() {
		System.out.println("특별계좌개설");
		System.out.println("계좌번호:");
		String gAccount = scan.nextLine();
		Account temp = new HighCreditAccount(gAccount,"", 0,0, null);
		if (set.contains(temp)) {
	        System.out.println("이미 존재하는 계좌번호입니다. 덮어씌우겠습니까? Y N");
	        String sc = scan.nextLine();
	        if(sc.equals("Y")) {
	        	System.out.println("덮어씌우는 데이터를 입력합니다..");
	        	set.remove(temp);
	        	set.add(temp);
	        }
	        else if(sc.equals("N")){
	        	System.out.println("취소합니다.");
	        	return;
	        }    
		
		}
		 System.out.println("이름:");
 		String gname = scan.nextLine();
 		System.out.println("잔액:");
 		double gMoney = scan.nextDouble();
 		scan.nextLine();
 		System.out.println("이자율(정수형태)");
 		double gRate = scan.nextDouble();
 		scan.nextLine();
 		System.out.println("등급 입력");
 		String gCredit = scan.nextLine();
 		System.out.println("계좌가 생성되었습니다.");
 		set.add(new HighCreditAccount(gAccount, gname, gMoney, gRate, gCredit));
 		count++;
	}
	public void saveFile() {
		try {ObjectOutputStream out = 
				new ObjectOutputStream(new FileOutputStream("src/text/AccountInfo.obj"));

		for(Account acc : set) {
			out.writeObject(acc);
		}
		} catch (Exception e) {
			System.out.println("저장실패");
			e.printStackTrace();
		}
	}
	public void loadFile() {
		try(ObjectInputStream in = new ObjectInputStream
				(new FileInputStream("src/text/AccountInfo.obj"))){
				System.out.println("계좌목록 불러오기");
			boolean isloaded = false;
		while(true) {
			try {
			Account ac = (Account) in.readObject();
			set.add(ac);
			isloaded = true;
		} catch (Exception e) {
			break;
			}
		}
		if (!isloaded) {
			System.out.println("불러올 값이 없습니다.");
		}
		
	} catch ( Exception  e) {
		System.out.println("불러올 파일이 없습니다.");
		}
			}
	public void depositMoney() {
		
		System.out.println("입금");
		System.out.println("계좌번호를 입력하세요");
		String gAccount = scan.nextLine();
		for (Account acc : set) {
		    if (acc.getAccount().equals(gAccount)) {
		
				System.out.println("입금할 금액을 입력하세요");
				String gmoney = scan.nextLine();
				if(!MenuSelectException.exception2(gmoney)) {
					continue;
				}			
				if(!MenuSelectException.exception3(gmoney)) {
					continue;
				}
				scan.nextLine();
				try {
					int gam = Integer.parseInt(gmoney);
					double alpha = acc.getMoney(); 
					acc.setMoney(alpha+gam);					
					double beta = acc.rateManager();
					acc.setMoney(acc.getMoney()+beta);
					System.out.println("금액이 입금되었습니다. 현재잔액" + acc.getMoney());
				
				}
				catch (Exception e) {
					System.out.println("입금금액을 잘못 입력했습니다.");
					scan.nextLine();
				}
			}
		    else {
		    	System.out.println("계좌번호가 일치하지 않습니다.");
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
				String gmoney1 = scan.nextLine();
				if(!MenuSelectException.exception2(gmoney1)) 
				{
					continue;
				}
				try {	
					int mon = Integer.parseInt(gmoney1);
					double alpha = acc.getMoney(); 
					scan.nextLine();

					if(!MenuSelectException.exception4(alpha, gmoney1))	{
						System.out.println("잔고 부족 전체를 출금하시겠습니까? Y N" );
						String cho =scan.nextLine();
						
						if(cho.equals("Y")) {
							System.out.println("전체가 출력되었습니다.");
							acc.setMoney(mon*0);
						}
						else if(cho.equals("N")) {
							System.out.println("처음으로 돌아갑니다.");
						}
					}
					else if(MenuSelectException.exception5(gmoney1)) {	
						acc.setMoney(alpha-mon);
						System.out.println("금액이 출금되었습니다. 현재잔액" + acc.getMoney());
					}
				}
				catch (Exception e) {
					System.out.println("입금금액을 잘못 입력했습니다.");
					scan.nextLine();
				}
				
			}
			else {
				System.out.println("계좌번호가 일치하지 않습니다.");
			}
		}
	}
	
	public void showAccInfo() {
		System.out.println("계좌정보출력");
		try {
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
		} catch (NullPointerException  e) {
			System.out.println("저장되어있는 계좌가 없습니다.");
		}
	}
	public void deleteAccount() {
		if (set ==null || set.isEmpty()){
			System.out.println("저정된 계좌가 없습니다.");
		}
		for(Account acc : set) {
			String delAccount = acc.getAccount();
			
			System.out.println("삭제할 계좌를 입력해주세요");
			String delete =scan.nextLine();
			if (delAccount.equals(delete)) {
				set.remove(acc);
				System.out.println("삭제되었습니다.");
			}
			
			else {
				System.out.println("일치하는 계좌가 없습니다.");
			}
		}
		
	}
	
	public void autoSave2() {
		System.out.println("1. 자동저장on, 2. 자동저장off");
		int choose = scan.nextInt();
		try {
			if (choose == 1 ) {
				if(saveThread !=null && saveThread.isAlive()) {
					System.out.println("이미 자동저장이 실행중입니다.");
					}
				else {
					System.out.println("자동저장을 시작합니다.");
					saveThread.start();
					}
			}
			else if(choose == 2) {
				System.out.println("자동저장을 종료합니다.");
				saveThread.interrupt();
			}
			else if(choose == 3) {
				System.out.println("현재 저장된 정보를 출력합니다.");
				try {
					BufferedReader reader = 
							new BufferedReader(new FileReader
									("src/text/AutoSaveAccount.txt"));
					String line;
					boolean data;
					while((line = reader.readLine()) !=null) {
						System.out.println("읽은내용:" +line );
						data = true;
					}
					reader.close();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}catch (Exception e) {
			e.getStackTrace();
		}
	}
}

//메서드	설명
//start()	스레드 실행 (비동기로 run() 호출됨)
//run()	직접 실행 (동기 실행, 거의 안 씀)
//interrupt()	스레드에 "멈춰!" 신호 보내기 (즉시 멈추는 건 아님)
//isAlive()	스레드가 살아있는지(실행 중인지) 확인
//join()	이 스레드가 끝날 때까지 기다림
	

