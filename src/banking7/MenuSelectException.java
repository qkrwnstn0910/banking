package banking7;

import java.util.Scanner;

public class MenuSelectException {
	Scanner scan = new Scanner(System.in);
	
	public static boolean exception1(String alp) {
		try {
			int number = Integer.parseInt(alp);
			if(number < 1 || number >7) {
				System.out.println("1부터 7까지의 값을 입력하세요");
				return false;
			}
			return true;
			
		}
		catch (NumberFormatException e) {
			System.out.println("숫자만 입력하세요");
			return false;
		}
	}
	public static boolean exception2(String alp2) {
		try {
			int alp = Integer.parseInt(alp2);
			if(alp < 0) {
				System.out.println("음수는 입력불가");
				return false;
			}
			return true;
		}
		catch (NumberFormatException e) {
			System.out.println("문자를 입력하실 수 없습니다.");
			return false;
		}
	}
	
	public static boolean exception3(String alp3) {
		int cho1 = Integer.parseInt(alp3);
		if(cho1%500!=0 && cho1<500) {
			System.out.println("500원 단위로만 입금가능");
			return false;
		}
		else {
			return true;
		}
	}
	
	public static boolean exception4(double alp41, String alp42) {
		int al = Integer.parseInt(alp42);
	
			if(alp41<al) {
				return false;
			}
			else
				return true;
		}
	
	
	public static boolean exception5(String alp3) {
		int cho1 = Integer.parseInt(alp3);
		if(cho1%1000!=0 || cho1<1000) {
			System.out.println("1000원 단위로만 출금가능");
			return false;
		}
		else {
			return true;
		}
	}
	
}



