package bankingLastExtreme;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashSet;

public class autoSave extends Thread{
	
	HashSet<Account> set = new HashSet<>();
	
	@Override
	public void run	() {
		while (true) {
		try {
			Thread.sleep(5000);
            System.out.println("");

            PrintWriter out = new PrintWriter(new FileWriter("src/text/AutoSaveAccount.txt"));
            for (Account acc : set) {
                out.println("계좌번호: " + acc.getAccount());
                out.println("이름: " + acc.getName());
                out.println("잔액: " + acc.getMoney());
                out.println("이자율: " + acc.getrate());
            
            if (acc instanceof HighCreditAccount ) {
            	HighCreditAccount hcc = (HighCreditAccount) acc;
            	out.println("등급: "+hcc.getCredit());
            	}
            }
            out.close();
		}
		catch (InterruptedException e) {
            System.out.println("저장 작업이 중단되었습니다.");
            break;  
		}
		catch (Exception e) {
			System.out.println("저장이 실행되지 않았습니다.");
			}
				
			
		
		}
	}
}

