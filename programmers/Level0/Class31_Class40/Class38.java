// 짝수는 싫어요
package Level0.Class31_Class40;

import java.util.Arrays;
import java.util.Scanner;

public class Class38 {

    public static int[] solution(int n) {
        // answer 초기 사이즈 측정
        int answerSize = n % 2 == 0 ? n / 2 : n / 2 + 1;
        int[] answer = new int[answerSize];

        int size = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) {
                answer[size] = i;
                size++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(Arrays.toString(solution(n)));
    }

}
