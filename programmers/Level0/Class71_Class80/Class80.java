// 캐릭터의 좌표
package Level0.Class71_Class80;

import java.util.Arrays;
import java.util.Scanner;

public class Class80 {

    public static int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[2];

        int final_x = board[0] / 2;
        int minus_final_x = final_x * -1;
        int final_y = board[1] / 2;
        int minus_final_y = final_y * -1;


        for (String key : keyinput) {
            if (key.equals("left") && answer[0] - 1 >= minus_final_x) {
                answer[0] -= 1;
            }
            else if (key.equals("right") && answer[0] + 1 <= final_x) {
                answer[0] += 1;
            }
            else if (key.equals("up") && answer[1] + 1 <= final_y) {
                answer[1] += 1;
            }
            else if (key.equals("down") && answer[1] - 1  >= minus_final_y) {
                answer[1] -= 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] keyinput = sc.nextLine().split(" ");
        int[] board = new int[2];

        for(int i = 0; i < 2; i++) {
            board[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(solution(keyinput, board)));
    }
}
