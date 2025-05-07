// 아이스 아메리카노
package Level0.Class21_Class30;

import java.util.Arrays;
import java.util.Scanner;

public class Class22 {

    public static int[] solution(int money) {
        int[] answer = {0,0};

        answer[0] = money/5500;
        answer[1] = money - 5500 * answer[0];

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();

        System.out.println(Arrays.toString(solution(money)));

    }

}
