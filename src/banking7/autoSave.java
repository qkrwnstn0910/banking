package banking7;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashSet;

public class autoSave extends Thread{
	
	private final HashSet<Account> set ;
	
    public autoSave(HashSet<Account> set) {
        this.set = set;
    }
	
	@Override
	public void run	() {
		while (true) {
		try {
			Thread.sleep(5000);
            System.out.println("자동저장중");

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
            System.out.println("자동저장 : 계좌"+acc.getAccount());
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

