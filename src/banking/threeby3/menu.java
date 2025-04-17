package banking.threeby3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class menu {
	Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		String[] arr = {"1","2","3","4","5","6","7","8","x"};
		System.out.println("======================");
		Shuffle(arr);
		int index = 0;
		String[][] save = new String[3][3];
		for(int i=0; i<3; i++) {
			for(int z=0; z<3; z++) {
				save[i][z] = arr[index];
				index++;
			}
		}
		for(int i=0; i<3; i++) {
			for(int z=0; z<3; z++) {
				System.out.print(save[i][z]+" ");
			}
			System.out.println(" | ");
		}
		System.out.println();
		
	}
	public static void Shuffle(String[] arr) {
		Random rand = new Random()	;
		
		for(int i =arr.length -1; i>0; i--) {
			int j = rand.nextInt(i+1);
			
			String temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		
	}
	
	public void Right() {
		System.out.println("오른쪽의 값과 바꿉니다.");
		if()
	}
	public void handler() {
		System.out.println("1.오른쪽");
		System.out.println("2.왼쪽");
		System.out.println("3.위");
		System.out.println("4.아래");
		
		String choose = scan.nextLine();
		int choose1 = Integer.parseInt(choose);
		if (choose1 == 1) {
			
		}
	}
	
	
}
