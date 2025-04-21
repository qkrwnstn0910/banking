package banking.threeby3;
import java.util.Random;
import java.util.Scanner;

public class PuzzleGame {
    public static void main(String[] args) {
    	while(true){
        Scanner scan = new Scanner(System.in);
        String[][] puzzle = {
            {"1", "2", "3"},
            {"4", "5", "6"},
            {"7", "8", "x"}  
        };
        
        shuffle(puzzle, 3);

        playGame(puzzle, scan);
    }
}

    // 셔플 함수: 주어진 횟수만큼 퍼즐을 섞는 함수
    public static void shuffle(String[][] puzzle, int shuffleCount) {

        // 퍼즐이 풀릴 수 있는 상태에서만 셔플
        for (int i = 0; i < shuffleCount; i++) {
            // 빈 칸의 위치 찾기
            int[] emptyPosition = findEmptyPosition(puzzle);

            // 빈 칸의 인접한 위치를 랜덤으로 선택
            String moveDirection = randomMove(emptyPosition);
            moveBefore(puzzle, emptyPosition, moveDirection);
        }
    }

    // 퍼즐에서 빈 칸(x)의 위치를 찾아 반환하는 함수
    public static int[] findEmptyPosition(String[][] puzzle) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (puzzle[i][j].equals("x")) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    // 빈 칸의 인접한 방향으로 숫자를 이동시키는 함수
    public static void move(String[][] puzzle, int[] emptyPosition, String direction) {
        int x = emptyPosition[0];
        int y = emptyPosition[1];
        switch (direction) {
            case "w": // 위로
                if (x > 0) {
                    swap(puzzle, x, y, x - 1, y);
                }
                else {
                	System.out.println("이동 불가");
                }
                break;
            case "a": // 왼쪽
                if (y > 0) {
                    swap(puzzle, x, y, x, y - 1);
                }
                else {
                	System.out.println("이동 불가");
                }
                break;
            case "s": // 아래로
                if (x < 2) {
                    swap(puzzle, x, y, x + 1, y);
                }
                else {
                	System.out.println("이동 불가");
                }
                break;
            case "d": // 오른쪽
                if (y < 2) {
                    swap(puzzle, x, y, x, y + 1);
                }
                else {
                	System.out.println("이동 불가");
                }
                break;
            default:
                System.out.println("잘못된 입력입니다. w, a, s, d 중 하나를 입력하세요.");
        	}
        }
    public static void moveBefore(String[][] puzzle, int[] emptyPosition, String direction) {
        int x = emptyPosition[0];
        int y = emptyPosition[1];
        switch (direction) {
            case "w": // 위로
                if (x > 0) {
                    swap(puzzle, x, y, x - 1, y);
                }
                
                break;
            case "a": // 왼쪽
                if (y > 0) {
                    swap(puzzle, x, y, x, y - 1);
                }
                
                break;
            case "s": // 아래로
                if (x < 2) {
                    swap(puzzle, x, y, x + 1, y);
                }
                
                break;
            case "d": // 오른쪽
                if (y < 2) {
                    swap(puzzle, x, y, x, y + 1);
                }
                
                break;
        	}
        }
        
    // 두 위치의 값을 교환하는 함수
    public static void swap(String[][] puzzle, int x1, int y1, int x2, int y2) {
        String temp = puzzle[x1][y1];
        puzzle[x1][y1] = puzzle[x2][y2];
        puzzle[x2][y2] = temp;
    }

    // 랜덤으로 이동 방향을 선택하는 함수
    public static String randomMove(int[] emptyPosition) {
        String[] directions = {"w", "a", "s", "d"};
        Random rand = new Random();
        return directions[rand.nextInt(4)]; // 랜덤객체 0에서 3중 랜덤하게 받아옴
    }

    // 게임 플레이 함수
    public static void playGame(String[][] puzzle, Scanner scan) {
        while (true) {
            printPuzzle(puzzle);
            System.out.println("이동할 방향을 입력하세요 w 위 a 좌 s 밑 d 우 ");
            String move = scan.nextLine();

            if (move.equals("w") || move.equals("a") || move.equals("s") || move.equals("d")) {
                // 빈 칸의 위치 찾기
                int[] emptyPosition = findEmptyPosition(puzzle);
                move(puzzle, emptyPosition, move);
            }

            // 퍼즐이 완성된 상태인지 확인
            if (isSolved(puzzle)) {
                printPuzzle(puzzle);
                System.out.println("게임을 클리어하였습니다. 재시작하겠습니까? Y S");
                String choose = scan.nextLine();
                if (choose.equals("Y")) {
                	System.out.println("게임을 재시작합니다.");
                }
                else if (choose.equals("N")) {
                	System.out.println("게임을 종료합니다.");
                	System.exit(0);
                }
            }
        }
    }

    // 퍼즐이 풀린 상태인지 확인하는 함수
    public static boolean isSolved(String[][] puzzle) {
        String[][] solvedPuzzle = {
            {"1", "2", "3"},
            {"4", "5", "6"},
            {"7", "8", "x"}
        };

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!puzzle[i][j].equals(solvedPuzzle[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    // 퍼즐을 출력하는 함수
    public static void printPuzzle(String[][] puzzle) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(puzzle[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}