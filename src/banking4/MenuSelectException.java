package banking4;

import java.util.Scanner;

public class MenuSelectException {
	
	
	public static void exception1(int alp) {
		try {
			if(alp < 1 || alp >5) {
				System.out.println("1부터 5까지의 값을 입력하세요");
			}
		}
		catch (Exception e) {
		}
	}
	public static void exception2(int alp2) {
		try {
			if(alp2 < 0) {
				System.out.println("음수는 입력불가");
			}
		}
		catch (Exception e) {
		}
	}
	
	public static void exception3(int alp3) {
		if(alp3%500==0 && alp3>=500) {
			System.out.println("500원 단위로만 입금가능");
			throw new IllegalArgumentException("500원 단위 아님");
		}
	}
	
	public static void exception4(double alp4, int alp41) {
		try {
			Scanner scan = new Scanner(System.in);
			if(alp4<alp41) {
				System.out.println("잔고부족 전체를 출력할까요? Y or N");
				String alp42 = scan.nextLine();
				
				if (alp42.equals("Y")) {
					System.out.println("출금이 완료되었습니다.");	
					alp41 = 0;
				}
				else if (alp42.equals("N")) {
					System.out.println("다음으로 넘어갑니다");
				}
			}
		}
		catch (Exception e) {
		}
	}
	
}

