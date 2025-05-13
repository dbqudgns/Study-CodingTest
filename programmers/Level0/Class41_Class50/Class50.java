// 약수 구하기
package Level0.Class41_Class50;

import java.util.Arrays;
import java.util.Scanner;

public class Class50 {

    public static int[] solution(int n) {
        int[] answer = {};
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) count++;
        }

        answer = new int[count];

        int index = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) answer[index++] = i;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(Arrays.toString(solution(n)));
    }

}
